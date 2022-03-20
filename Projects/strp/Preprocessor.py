#!/usr/bin/env python

import os
import pickle
import sys
from matplotlib.pyplot import *
from numpy import *
from pandas import *
from scipy.stats import kstest
from scipy.stats import boxcox
from sklearn.base import BaseEstimator
from sklearn.base import ClassifierMixin
from sklearn.decomposition import PCA
from sklearn.preprocessing import scale
from statsmodels.formula.api import ols
from statsmodels.stats.anova import anova_lm
from strp.Constants import *


class Preprocessor(BaseEstimator, ClassifierMixin):
    def __init__(self, estimator=None, alpha=.05, indices=("GFA",), n_components=.6, output=False):
        self.estimator = estimator
        self.alpha = alpha
        self.indices = indices
        self.features = ["_".join([index, tract.Nickname, str(step)]) for index in indices for tract in TRACTS for step in range(100)]
        self.n_components = n_components
        self.output = output
        self.subjects = None
        self.pvalues = None
        self.segments = None
        self.analysis = None

    def get_params(self, deep=True):
        return self.estimator.get_params(deep)

    def set_params(self, **params):
        self.estimator.set_params(**params)
        return self

    def fit(self, X, y):
        if self.subjects != hash(tuple(sorted(X.index))):
            self.preprocess(X, y)
        self.estimator.fit(self.transform(X), y)
        return self

    def transform(self, X):
        X = X[self.features]
        X = self.__extract_average(X)
        X = self.__extract_analysis(X)
        return X

    def decision_function(self, X):
        return self.estimator.decision_function(self.transform(X))

    def predict(self, X):
        return self.estimator.predict(self.transform(X))

    def preprocess(self, X, y):
        if not self.output: sys.stdout = open(os.devnull, "w")
        print("\n## Preprocessing Session\n")
        self.subjects = hash(tuple(sorted(X.index)))
        print("- Feature selection: analysis of covariance (ANCOVA)")
        self.pvalues = self.__pvalues(X, y)
        print("\t- %d significant steps (alpha = %.2f) are found." % (sum(self.pvalues < self.alpha), self.alpha))
        segments = self.__segments()
        print("\t- %d segments are found." % len(segments))
        self.__plot_segments(segments)
        self.segments = self.__select_segments(segments)
        print("\t- %d significant segments (>= %d steps) are found." % (len(self.segments), min(map(len, self.segments))))
        X = X[self.features]
        self.__plot_pvalues(-sign(X.groupby(y).mean().diff().loc["R", :]))
        print("- Feature extraction: average")
        X = self.__extract_average(X)
        changes = -sign(X.groupby(y).mean().diff().loc["R", :])
        print("- Feature extraction: principal component analysis (PCA)")
        self.__plot_percentage(PCA().fit(X))
        self.analysis = PCA(n_components=self.n_components).fit(X)
        X = self.__extract_analysis(X)
        print("\t- %d components explain %.4f of variance." % (self.analysis.components_.shape[0], sum(self.analysis.explained_variance_ratio_)))
        self.__plot_weighting()
        self.__print_segments(changes)
        sys.stdout = sys.__stdout__
        return self

    def __pvalues(self, X, y):
        fname = "Pvalues%d.pkl" % hash(tuple(sorted(X.index)))
        if os.path.isfile("./Downloads/Researches/STRP/Datasets/Pvalues/%s" % fname):
            with open("./Downloads/Researches/STRP/Datasets/Pvalues/%s" % fname, "rb") as fin:
                return pickle.load(fin)[isin(FEATURES, self.features)]
        data = concat((X, y), axis=1)
        pvalues = zeros(len(FEATURES))
        for i, feature in enumerate(FEATURES):
            formula = "%s ~ Category + Age + Sex + Duration * Dose" % feature
            pvalues[i] = anova_lm(ols(formula, data).fit()).loc["Category", "PR(>F)"]
        with open("./Downloads/Researches/STRP/Datasets/Pvalues/%s" % fname, "wb") as fout:
            pickle.dump(pvalues, fout, pickle.HIGHEST_PROTOCOL)
        return pvalues[isin(FEATURES, self.features)]

    def __segments(self):
        segments = []
        for step in where(self.pvalues < self.alpha)[0]:
            if len(segments) == 0 or step % 100 == 0 or segments[-1][-1] + 1 != step:
                segments.append([step])
            else:
                segments[-1].append(step)
        return array(segments)

    def __select_segments(self, segments):
        lens = list(map(len, segments))
        threshold = percentile(lens, 90)
        return segments[lens >= threshold]

    def __extract_average(self, X):
        predictor = DataFrame()
        for segment in self.segments:
            predictor[predictor.shape[1]] = X.iloc[:, segment].mean(axis=1)
        return self.__normalize(predictor)

    def __extract_analysis(self, X):
        return self.__normalize(DataFrame(self.analysis.transform(X)))

    def __normalize(self, X):
        pvalues = X.apply(lambda col: kstest(scale(list(col)), "norm").pvalue)
        if sum(pvalues < self.alpha) != 0:
            print("\t- %d features do not pass normalization test." % sum(pvalues < self.alpha))
        for feature in where(pvalues < self.alpha)[0]:
            X[feature] = boxcox(X[feature] - min(X[feature]) + 1)[0]
        return X.apply(lambda col: scale(list(col)))

    def __plot_pvalues(self, changes):
        if not self.output: return
        for i in range(len(self.indices)):
            lower, upper = i * len(TRACTS) * 100, (i + 1) * len(TRACTS) * 100
            data = array(-log10(self.pvalues[lower:upper]) * changes[lower:upper]).reshape((len(TRACTS), 100))
            pcolor(data, cmap="coolwarm", vmin=log10(self.alpha), vmax=-log10(self.alpha))
            title("p Value Map of %s" % self.indices[i].upper())
            xlabel("Step")
            xlim((0, 100))
            ylabel("Tract")
            ylim((0, len(TRACTS)))
            colorbar(aspect=10).ax.set_title("-log(p)sign(NR-R)")
            savefig("./Downloads/Researches/STRP/Figures/Pvalues/Pvalues %s.png" % self.indices[i].upper())
            close()

    def __plot_segments(self, segments):
        if not self.output: return
        lens = list(map(len, segments))
        hist(lens, range(min(lens), max(lens)))
        axvline(x=percentile(lens, 90), color="red", lw=2)
        title("Histogram of Segment Length")
        xlabel("Length")
        ylabel("Count")
        savefig("./Downloads/Researches/STRP/Figures/Histogram.png")
        close()

    def __print_segments(self, changes):
        if not self.output: return
        print("\n## Significant Segments\n")
        print("||Index|NR|Tract|Steps|")
        print("|-|-|-|-|-|")
        for i, segment in enumerate(self.segments):
            elements = self.features[segment[0]].split("_")
            index = elements[0]
            change = "↑" if changes[i] > 0 else "↓"
            tract = TRACTS[int(elements[1][2:]) - 1]
            steps = (elements[-1], self.features[segment[-1]].split("_")[-1])
            print("|%d|%s|%s|%s|%s ~ %s|" % (i + 1, index, change, tract.Fullname, steps[0], steps[1]))

    def __plot_percentage(self, analysis):
        if not self.output: return
        percentages = cumsum(analysis.explained_variance_ratio_)
        plot(range(1, len(percentages) + 1), percentages, lw=2)
        plot(range(1, len(percentages) + 1), percentages, "ko")
        axhline(y=self.n_components, color="red", lw=2)
        title("Percentage of Variance Expained by Components")
        xlabel("Number of components")
        ylabel("Percentage")
        grid()
        savefig("./Downloads/Researches/STRP/Figures/Analysis/Analysis Percentage.png")
        close()

    def __plot_weighting(self):
        if not self.output: return
        pcolor(self.analysis.components_, cmap="seismic", vmin=-1, vmax=1)
        title("Feature Weighting")
        xlabel("Segment")
        xlim((0, self.analysis.components_.shape[1]))
        xticks(arange(self.analysis.components_.shape[1]) + .5, arange(self.analysis.components_.shape[1]) + 1)
        ylabel("Feature")
        ylim((0, self.analysis.components_.shape[0]))
        yticks(arange(self.analysis.components_.shape[0]) + .5, arange(self.analysis.components_.shape[0]) + 1)
        colorbar(aspect=10).ax.set_title("Weight")
        savefig("./Downloads/Researches/STRP/Figures/Analysis/Analysis Weighting.png")
        close()
