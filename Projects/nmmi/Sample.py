#!/usr/bin/env python

import pickle
from pandas import read_csv
from matplotlib.pyplot import *


class Sample:
    @staticmethod
    def load():
        DF = read_csv("./Downloads/Projects/NMMI/Datasets/Demographics.csv", index_col=0)
        with open("./Downloads/Projects/NMMI/Datasets/Indices/FA.pkl", "rb") as fin:
            FA = pickle.load(fin)
        return (DF, FA)

    @staticmethod
    def hist(DF):
        hist(
            [DF.age.loc[DF.sex == "FEMALE"], DF.age.loc[DF.sex == "MALE"]],
            bins=range(18, 90),
            label=["Female", "Male"],
            stacked=True
        )
        legend()
        xlabel("Age")
        ylabel("Frequency")
        yticks(range(0, 20, 2))
        savefig("./Downloads/Projects/NMMI/Figures/Sample")
        clf()
