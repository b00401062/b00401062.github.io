#!/usr/bin/env python

from numpy import *
from scipy.stats import kstest
from scipy.stats import norm
from sklearn.model_selection import KFold
from nmmi.Constants import *


class Diagnostics:
    def __init__(self, sex, model, tract):
        self.sex = sex
        self.model = model
        self.tract = tract

    def fit(self, x, y):
        self.xs = []
        self.ys = []
        self.rs = []
        self.zs = []
        for train, test in KFold(5, True, 0).split(x):
            self.model.fit(x[train], y[train])
            y_hat = self.model.predict(x[test])
            self.xs.extend(x[test])
            self.ys.extend(y[test])
            self.rs.extend(y[test] - y_hat)
            self.zs.extend((y[test] - y_hat) / self.model.s[x[test] - 18])
        return self

    def standard(self):
        return kstest(self.zs, "norm").pvalue

    def percentage(self):
        return sum(absolute(self.zs) < norm.ppf(1 - ALPHA / 2)) / len(self.zs)
