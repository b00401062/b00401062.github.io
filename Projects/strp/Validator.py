#!/usr/bin/env python

from numpy import *
from pandas import *
from sklearn.model_selection import LeaveOneOut
from sklearn.model_selection import validation_curve
from matplotlib.pyplot import *
from strp.Constants import *


class Validator:
    def __init__(self, preprocessor, param_name, param_range, xlabel, xtickslabels):
        self.preprocessor = preprocessor
        self.param_name = param_name
        self.param_range = param_range
        self.title = "".join([c for c in preprocessor.estimator.__class__.__name__ if c.isupper()])
        self.xlabel = xlabel
        self.xtickslabels = xtickslabels
        self.best = None

    def fit(self, dataset):
        print("\n## Validation Session: %s\n" % self.title)
        scores_train, scores_valid = validation_curve(
            estimator=self.preprocessor,
            cv=LeaveOneOut(),
            X=concat((dataset.NR, dataset.R)),
            y=Series(
                ["NR"] * dataset.NR.shape[0] + ["R"] * dataset.R.shape[0],
                index=dataset.NR.index.append(dataset.R.index),
                dtype="category"
            ).rename("Category"),
            param_name=self.param_name,
            param_range=self.param_range)
        arg = argmax(scores_valid.mean(axis=1))
        self.best = Best(arg, self.param_range[arg], scores_valid[arg, :].mean(), scores_valid[arg, :].std())
        print("- Best parameter: " + ("%d" if self.param_range.dtype == int else "%f") % self.best.Parameter)
        print("- Best mean (sd) of accuracy: %.4f (%.4f)" % (self.best.Mean, self.best.SD))
        self.__plot_validation_curve(scores_train, scores_valid)
        return self

    def __plot_validation_curve(self, scores_train, scores_valid):
        axvline(x=self.best.Index, lw=2, color="red")
        scores_train_mean = scores_train.mean(axis=1)
        scores_train_std = scores_train.std(axis=1)
        plot(scores_train_mean, label="Training", lw=2)
        fill_between(
            x=range(scores_train.shape[0]),
            y1=scores_train_mean - scores_train_std,
            y2=scores_train_mean + scores_train_std,
            color="C0", alpha=.2)
        scores_valid_mean = scores_valid.mean(axis=1)
        scores_valid_std = scores_valid.std(axis=1)
        plot(scores_valid_mean, label="Validation", lw=2)
        fill_between(
            x=range(scores_valid.shape[0]),
            y1=scores_valid_mean - scores_valid_std,
            y2=scores_valid_mean + scores_valid_std,
            color="C1", alpha=.2)
        title("%s Validation Curve" % self.title)
        xlim([0, scores_valid.shape[0] - 1])
        xticks(
            linspace(0, scores_valid.shape[0] - 1, len(self.xtickslabels)),
            [("%d" if label.dtype == int else "%.1f") % label for label in self.xtickslabels])
        xlabel(self.xlabel)
        ylabel("Accuracy")
        legend(frameon=False)
        savefig("./Downloads/Researches/STRP/Figures/Validation/Validation %s.png" % self.title)
        close()
