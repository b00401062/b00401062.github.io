#!/usr/bin/env python

from numpy import *
from scipy.optimize import curve_fit
from scipy.stats import t
from matplotlib.pyplot import *
from nmmi.Constants import *


class Regression:
    def __init__(self, sex, model, tract):
        self.sex = sex
        self.model = model
        self.peak = argmax(model.m) + 18
        self.tract = tract
        self.x = None
        self.y = None
        self.b = None

    def fit(self, x, y):
        self.x = x
        self.y = y
        (self.b, _) = curve_fit(self.piecewise, x.astype("float").tolist(), y)
        if self.b[0] == 1: self.b[0] = NaN
        if self.b[1] == 1: self.b[1] = NaN
        return self

    def piecewise(self, x, b0, b1, b2):
        return piecewise(x, [x < self.peak], [lambda x: b1 * (x - self.peak) + b0, lambda x: b2 * (x - self.peak) + b0])

    @staticmethod
    def peak(model):
        return argmax(model.m) + 18

    def p(self):
        n = len(self.x)
        x1 = self.x[self.x < self.peak]
        y1 = self.y[self.x < self.peak]
        se1 = sqrt(sum(square(y1 - self.b[0] + self.b[1] * (x1 - self.peak))) / (n - 2)) / sqrt(
            sum(square(x1 - mean(x1))))
        x2 = self.x[self.x >= self.peak]
        y2 = self.y[self.x >= self.peak]
        se2 = sqrt(sum(square(y2 - self.b[0] + self.b[2] * (x2 - self.peak))) / (n - 2)) / sqrt(
            sum(square(x2 - mean(x2))))
        return (2 * (1 - t(n - 2).cdf(abs(self.b[1] / se1))), 2 * (1 - t(n - 2).cdf(abs(self.b[2] / se2))))

    def scatter(self):
        scatter(self.x, self.y, s=4, alpha=.5)
        plot(AGES, self.model.m)
        axvline(x=self.peak, color="k")
        plot(AGES, self.piecewise(arange(18., 89.), *self.b))
        xlabel("Age")
        ylabel("Integrity")
        savefig("./Downloads/Projects/NMMI/Figures/Regression/{}/{}".format(self.sex.capitalize(), self.tract))
        clf()

    @staticmethod
    def pcolor(slopes, pvalues, peaks, sex):
        color = sign(slopes).values * -log10(pvalues).values
        pcolor(list(map(lambda x: repeat(x[0], x[1]), zip(color, map(lambda peak: (peak - 18, 89 - peak), peaks)))),
               cmap="coolwarm")
        axhline(y=11, color="k")
        axhline(y=18, color="k")
        xticks(arange(0, 70, 5) + 2, arange(20, 90, 5))
        yticks(arange(len(TRACTS)) + .5, list(map(lambda tract: tract.nickname[5:], TRACTS)))
        xlabel("Age")
        ylabel("Tract")
        colorbar(aspect=10).ax.set_title("-log(p)sign(b)")
        n = len(TRACTS) * 2 - array(isnan(pvalues)).sum()
        clim(log10(ALPHA / n), -log10(ALPHA / n))
        savefig("./Downloads/Projects/NMMI/Figures/Regression/Heatmap ({})".format(sex.capitalize()))
        clf()

    @staticmethod
    def dump(SLOPES, PVALUES):
        with open("./Downloads/Projects/NMMI/Datasets/Slopes.pkl", "wb") as fout:
            pickle.dump(SLOPES, fout, pickle.HIGHEST_PROTOCOL)
        with open("./Downloads/Projects/NMMI/Datasets/Pvalues.pkl", "wb") as fout:
            pickle.dump(PVALUES, fout, pickle.HIGHEST_PROTOCOL)

    @staticmethod
    def load():
        with open("./Downloads/Projects/NMMI/Datasets/Slopes.pkl", "rb") as fin:
            SLOPES = pickle.load(fin)
        with open("./Downloads/Projects/NMMI/Datasets/Pvalues.pkl", "rb") as fin:
            PVALUES = pickle.load(fin)
        return (SLOPES, PVALUES)
