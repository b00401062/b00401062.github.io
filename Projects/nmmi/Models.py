#!/usr/bin/env python

from numpy import *
from sklearn.base import BaseEstimator
from matplotlib.pyplot import *
from nmmi.Constants import *


class Model:
    def __init__(self, df, model, tract):
        self.df = df
        self.model = model
        self.tract = tract

    def scatter(self, x, y):
        scatter(x, y, s=4, c=list(map("C{}".format, self.df.sex.astype("category").cat.codes)), alpha=.5)
        for sex in Sex._fields:
            model = self.model.fit(x.loc[self.df.sex == sex.upper()], y[self.df.sex == sex.upper()])
            plot(AGES, model.m)
            fill_between(AGES, model.m - model.s, model.m + model.s, alpha=.5)
        title(self.tract.fullname)
        legend(list(map(str.capitalize, Sex._fields)), loc="lower left")
        xlabel("Age")
        ylabel("Integrity")
        savefig("./Downloads/Projects/NMMI/Figures/Scatter/{}/{}".format(self.model.__class__.__name__, self.tract.nickname))
        clf()


class CMA(BaseEstimator):
    def fit(self, x, y):
        self.m = array([y[bitwise_and(age - 2 <= x, x <= age + 2)].mean() for age in AGES])
        self.s = array([y[bitwise_and(age - 2 <= x, x <= age + 2)].std() for age in AGES])
        return self

    def predict(self, x):
        return self.m[x - 18]


class LLSR(BaseEstimator):
    def fit(self, x, y):
        x = array(x).reshape(-1, 1)
        model = OLS(y, PolynomialFeatures(1).fit_transform(x)).fit()
        self.m = model.predict(PolynomialFeatures(1).fit_transform(AGES.reshape(-1, 1)))
        self.s = wls_prediction_std(model, PolynomialFeatures(1).fit_transform(AGES.reshape(-1, 1)))[0]
        return self

    def predict(self, x):
        return self.m[x - 18]


from statsmodels.api import OLS
from sklearn.preprocessing import PolynomialFeatures
from statsmodels.sandbox.regression.predstd import wls_prediction_std


class QLSR(BaseEstimator):
    def fit(self, x, y):
        x = array(x).reshape(-1, 1)
        model = OLS(y, PolynomialFeatures(2).fit_transform(x)).fit()
        self.m = model.predict(PolynomialFeatures(2).fit_transform(AGES.reshape(-1, 1)))
        self.s = wls_prediction_std(model, PolynomialFeatures(2).fit_transform(AGES.reshape(-1, 1)))[0]
        return self

    def predict(self, x):
        return self.m[x - 18]


from sklearn.gaussian_process import GaussianProcessRegressor
from sklearn.gaussian_process.kernels import RBF
from sklearn.gaussian_process.kernels import WhiteKernel


class GPR(BaseEstimator):
    def fit(self, x, y):
        x = array(x).reshape(-1, 1)
        model = GaussianProcessRegressor(kernel=RBF() + WhiteKernel(), alpha=.0).fit(x, y)
        self.m, self.s = model.predict(AGES.reshape(-1, 1), return_std=True)
        return self

    def predict(self, x):
        return self.m[x - 18]
