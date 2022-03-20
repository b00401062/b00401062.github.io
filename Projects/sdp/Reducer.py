#!/usr/bin/env python

from numpy import *
from sklearn.decomposition import PCA
from sklearn.gaussian_process import GaussianProcessClassifier
from matplotlib.pyplot import *


class Reducer:
    def fit(self, X, y):
        param_grid = arange(.01, 1, .01)
        classifier = GaussianProcessClassifier()
        score = list(
            map(lambda i: classifier.fit(PCA(i).fit_transform(X), y).log_marginal_likelihood_value_, param_grid))
        plot(range(1, 100), score)
        xticks(linspace(0, 100, 11), list(map("{:.1f}".format, linspace(0, 1, 11))))
        xlabel("Percentage")
        ylabel("Log marginal likelihood")
        savefig("./Downloads/Projects/SDP/Figures/Reducer")
        clf()
        return PCA(param_grid[argmax(score)])
