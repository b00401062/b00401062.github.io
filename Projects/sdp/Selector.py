#!/usr/bin/env python

from scipy.stats import ttest_ind
from matplotlib.pyplot import *


class Selector:
    def __init__(self, tract):
        self.tract = tract
        self.pvalue = None

    def fit(self, X, y):
        groups = X.groupby(y)
        self.pvalue = ttest_ind(groups.get_group("N").mean(axis=1), groups.get_group("S").mean(axis=1)).pvalue
        plot(groups.get_group("N").mean(axis=0), label="Non-schizophrenia")
        plot(groups.get_group("S").mean(axis=0), label="Schizophrenia")
        title(self.tract.fullname)
        xlabel("Steps")
        ylabel("Mean GFA")
        legend(loc="lower center")
        savefig("./Downloads/Projects/SDP/Figures/Tracts/{}".format(self.tract.nickname))
        clf()
        return self
