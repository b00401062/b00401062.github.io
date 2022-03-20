#!/usr/bin/env python

from numpy import (arange, linspace)
from pandas import (Series, concat)
from sklearn.discriminant_analysis import LinearDiscriminantAnalysis
from sklearn.discriminant_analysis import QuadraticDiscriminantAnalysis
from sklearn.linear_model import LogisticRegression
from sklearn.svm import SVC
from strp.Constants import *
from strp.Preprocessor import Preprocessor
from strp.Validator import Validator
from strp.Evaluator import Evaluator


class Pipeline:
    def __init__(self, bests, validate=False, evaluate=True, transfer=True):
        self.bests = bests
        self.validate = validate
        self.evaluate = evaluate
        self.transfer = transfer
        self.datasets = None

    def fit(self, datasets):
        self.datasets = datasets
        self.preprocess(datasets.Training)
        return self

    def preprocess(self, dataset):
        X = concat((dataset.NR, dataset.R))
        y = Series(
            ["NR"] * dataset.NR.shape[0] + ["R"] * dataset.R.shape[0],
            index=dataset.NR.index.append(dataset.R.index),
            dtype="category"
        ).rename("Category")
        Preprocessor(output=True).preprocess(X, y)

    def run(self, estimator):
        if self.validate:
            self.bests = self.__validate(estimator)
        if self.evaluate:
            evaluator = self.__evaluate(estimator)
            evaluator.predict(self.datasets.Training, "Training")
            evaluator.predict(self.datasets.Test.Chronic, "Test 1")
            evaluator.predict(self.datasets.Test.Early, "Test 2")
        if self.transfer:
            evaluator = self.__evaluate(estimator)
            evaluator.transfer(self.datasets.Test.Early, "Transfer Test 2")

    def __validate(self, estimator):
        return Model(
            LinearDiscriminantAnalysis=Validator(
                preprocessor=Preprocessor(LinearDiscriminantAnalysis(solver="lsqr")),
                param_name="shrinkage",
                param_range=linspace(0, 1, 101),
                xlabel="shrinkage",
                xtickslabels=linspace(0, 1, 11)
            ).fit(self.datasets.Training).best if estimator == LinearDiscriminantAnalysis else self.bests.LinearDiscriminantAnalysis,
            QuadraticDiscriminantAnalysis=Validator(
                preprocessor=Preprocessor(QuadraticDiscriminantAnalysis()),
                param_name="reg_param",
                param_range=linspace(0, 1, 101),
                xlabel="shrinkage",
                xtickslabels=linspace(0, 1, 11)
            ).fit(self.datasets.Training).best if estimator == QuadraticDiscriminantAnalysis else self.bests.QuadraticDiscriminantAnalysis,
            LogisticRegression=Validator(
                preprocessor=Preprocessor(LogisticRegression()),
                param_name="C",
                param_range=2 ** linspace(-10, 10, 201),
                xlabel="log2(C)",
                xtickslabels=arange(21) - 10
            ).fit(self.datasets.Training).best if estimator == LogisticRegression else self.bests.LogisticRegression,
            SVC=Validator(
                preprocessor=Preprocessor(SVC(kernel="linear")),
                param_name="C",
                param_range=2 ** linspace(-10, 10, 201),
                xlabel="log2(C)",
                xtickslabels=arange(21) - 10
            ).fit(self.datasets.Training).best if estimator == SVC else self.bests.SVC)

    def __evaluate(self, estimator):
        if estimator == LinearDiscriminantAnalysis:
            return Evaluator(
                preprocessor=Preprocessor(LinearDiscriminantAnalysis(solver="lsqr", shrinkage=self.bests.LinearDiscriminantAnalysis.Parameter))
            ).fit(self.datasets.Training)
        elif estimator == QuadraticDiscriminantAnalysis:
            return Evaluator(
                preprocessor=Preprocessor(QuadraticDiscriminantAnalysis(reg_param=self.bests.QuadraticDiscriminantAnalysis.Parameter))
            ).fit(self.datasets.Training)
        elif estimator == LogisticRegression:
            return Evaluator(
                preprocessor=Preprocessor(LogisticRegression(C=self.bests.LogisticRegression.Parameter))
            ).fit(self.datasets.Training)
        elif estimator == SVC:
            return Evaluator(
                preprocessor=Preprocessor(SVC(kernel="linear", C=self.bests.SVC.Parameter))
            ).fit(self.datasets.Training)
        else:
            return None
