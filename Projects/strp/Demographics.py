#!/usr/bin/env python

from scipy.stats import ttest_ind
from scipy.stats import chi2_contingency
from strp.Constants import *


class Demographics:
    def __init__(self, alpha=.05):
        self.alpha = alpha
        self.dataset = None

    def fit(self, dataset, title):
        self.dataset = dataset
        print("\n## Demographics: %s\n" % title)
        print("||R (n=%d)|NR (n=%d)|p value|" % (dataset.R.shape[0], dataset.NR.shape[0]))
        print("|-|-|-|-|")
        self.__fit_continuous("Age (year)", ["Age"], "sum")
        self.__fit_categorical("Sex (% male)")
        self.__fit_continuous("Duration of illness (year)", ["Duration"], "sum")
        self.__fit_continuous("Antipsychotic dose (mg/d)", ["Dose"], "sum")
        self.__fit_continuous("Cumulative dose (mg/d-year)", ["Duration", "Dose"], "prod")
        self.__fit_continuous("P1+P2+P3", ["P1", "P2", "P3"], "sum")
        self.__fit_continuous("N1+N4+N6", ["N1", "N4", "N6"], "sum")
        self.__fit_continuous("G5+G9", ["G5", "G9"], "sum")
        return self

    def __fit_continuous(self, title, features, operation):
        groups = Category(
            NR=getattr(self.dataset.NR[features], operation)(axis=1),
            R=getattr(self.dataset.R[features], operation)(axis=1))
        means = Category(NR=groups.NR.mean(), R=groups.R.mean())
        stds = Category(NR=groups.NR.std(), R=groups.R.std())
        pvalue = ttest_ind(groups.NR, groups.R).pvalue
        print("|%s|%.2f±%.2f|%.2f±%.2f|%s%.2f%s|" % (
            title,
            means.R, stds.R, means.NR, stds.NR,
            "<" if pvalue < .01 else "",
            .01 if pvalue < .01 else pvalue,
            "*" if pvalue < self.alpha else ""))

    def __fit_categorical(self, title):
        groups = Category(NR=self.dataset.NR.Sex, R=self.dataset.R.Sex)
        table = [
            [groups.NR.value_counts().F, groups.R.value_counts().F],
            [groups.NR.value_counts().M, groups.R.value_counts().M]]
        pvalue = chi2_contingency(table)[1]
        print("|%s|%d (%2.0f%%)|%d (%2.0f%%)|%s%.2f%s|" % (
            title,
            groups.R.value_counts().M,
            100 * groups.R.value_counts().M / groups.R.count(),
            groups.NR.value_counts().M,
            100 * groups.NR.value_counts().M / groups.NR.count(),
            "<" if pvalue < .01 else "",
            .01 if pvalue < .01 else pvalue,
            "*" if pvalue < self.alpha else ""))
