#!/usr/bin/env python

import pickle
from numpy import sqrt
from scipy.stats import t
from matplotlib.pyplot import *
from nmmi.Constants import *


class Selection:
    MODELS = ["CMA", "GPR"]

    @staticmethod
    def stats(x):
        n = len(TRACTS)
        m = x.mean()
        se = x.std() / sqrt(n)
        e = se * t(n - 1).ppf(.975)
        p = 2 - 2 * t(n - 1).cdf(abs(m) / se)
        return (m, se, e, p)

    @staticmethod
    def display(label, stats):
        m = [stats.female[0], stats.male[0]]
        se = [stats.female[1], stats.male[1]]
        e = [stats.female[2], stats.male[2]]
        p = [stats.female[3], stats.male[3]]
        print("- Difference of {}".format(label))
        for i in range(2):
            print("\t- {}: {:.2e} ± {:.2e} (95% CI = [{:.2e},{:.2e}]; p = {})".format(
                Sex._fields[i].capitalize(), m[i], se[i], m[i] - e[i], m[i] + e[i], p[i]
            ))
        bar(range(2), m)
        errorbar(range(2), m, e, fmt="o", capsize=4, color="k")
        xticks(range(2), list(map("".join, zip(map(str.capitalize, Sex._fields), map("\n(p={:.3e})".format, p)))))
        title("Difference of {}".format(label))
        ylabel("GPR - CMA")
        grid(axis="y")
        ticklabel_format(style="sci", axis="y", scilimits=(0, 0))
        savefig("./Downloads/Projects/NMMI/Figures/Selection/{}".format(label))
        close()

    @staticmethod
    def mse(SCORES):
        x = -SCORES.test_neg_mean_squared_error.unstack()
        Selection.display("MSE", Sex(*[Selection.stats(x.loc[sex].diff().T.GPR) for sex in Sex._fields]))

    @staticmethod
    def cod(SCORES):
        x = SCORES.test_r2.unstack()
        Selection.display("COD", Sex(*[Selection.stats(x.loc[sex].diff().T.GPR) for sex in Sex._fields]))

    @staticmethod
    def standard(STANDARDS):
        x = STANDARDS.p.unstack()
        Selection.display("P-value", Sex(*[Selection.stats(x.loc[sex].diff().T.GPR) for sex in Sex._fields]))

    @staticmethod
    def percentage(PERCENTAGES):
        x = PERCENTAGES.p.unstack()
        n = len(TRACTS)
        for sex, _ in zip(Sex._fields, subplots(1, 2, sharey=True)[1]):
            sca(_)
            m = x.loc[sex].mean(axis=1)
            se = x.loc[sex].std(axis=1) / sqrt(n)
            e = se * t(2 * n - 2).ppf(.975)
            p = (1 - t(2 * n - 2).cdf(abs(m - .95) / se)) * 2
            print("- {}".format(sex.capitalize()))
            for i in range(2):
                print("\t- {}: {:.2e} ± {:.2e} (95% CI = [{:.2e},{:.2e}]; p = {:.2e})".format(
                    Selection.MODELS[i], m[i], se[i], m[i] - e[i], m[i] + e[i], p[i]
                ))
            errorbar(range(2), m, e, fmt="o", capsize=4)
            xticks(range(2), list(map("".join, zip(Selection.MODELS, map("\n(p={:.3e})".format, p)))))
            title(sex.capitalize())
            ylabel("Percentage")
            xlim((-0.49, 1.49))
            axhline(.95, color="r")
            grid(axis="y")
        savefig("./Downloads/Projects/NMMI/Figures/Selection/Percentage")
        close()

    @staticmethod
    def dump(SCORES, STANDARDS, PERCENTAGES):
        with open("./Downloads/Projects/NMMI/Datasets/Scores.pkl", "wb") as fout:
            pickle.dump(SCORES, fout, pickle.HIGHEST_PROTOCOL)
        with open("./Downloads/Projects/NMMI/Datasets/Standards.pkl", "wb") as fout:
            pickle.dump(STANDARDS, fout, pickle.HIGHEST_PROTOCOL)
        with open("./Downloads/Projects/NMMI/Datasets/Percentages.pkl", "wb") as fout:
            pickle.dump(PERCENTAGES, fout, pickle.HIGHEST_PROTOCOL)

    @staticmethod
    def load():
        with open("./Downloads/Projects/NMMI/Datasets/Scores.pkl", "rb") as fin:
            SCORES = pickle.load(fin)
        with open("./Downloads/Projects/NMMI/Datasets/Standards.pkl", "rb") as fin:
            STANDARDS = pickle.load(fin)
        with open("./Downloads/Projects/NMMI/Datasets/Percentages.pkl", "rb") as fin:
            PERCENTAGES = pickle.load(fin)
        return (SCORES, STANDARDS, PERCENTAGES)
