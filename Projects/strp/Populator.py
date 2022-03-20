#!/usr/bin/env python

import os
import pickle
import re
from numpy import *
from pandas import (DataFrame, read_csv)
from scipy.io import loadmat
from sklearn.model_selection import train_test_split
from strp.Constants import *


class Populator:
    def __init__(self):
        self.DATASETS = self.__datasets()
        self.BESTS = Model(
            LinearDiscriminantAnalysis=Best(Index=0, Parameter=0.000000, Mean=0.0000, SD=0.0000),
            QuadraticDiscriminantAnalysis=Best(Index=0, Parameter=0.000000, Mean=0.5000, SD=0.5000),
            LogisticRegression=Best(Index=91, Parameter=2 ** -.9, Mean=0.4219, SD=0.4939),
            SVC=Best(Index=93, Parameter=2 ** -.7, Mean=0.4844, SD=0.4998))

    def populate(self):
        return (self.DATASETS, self.BESTS)

    def __datasets(self):
        if os.path.isfile("./Downloads/Researches/STRP/Datasets/Datasets.pkl"):
            with open("./Downloads/Researches/STRP/Datasets/Datasets.pkl", "rb") as fin:
                return pickle.load(fin)
        fname = "./Downloads/Researches/STRP/Datasets/Metadata/Response.csv"
        table = read_csv(fname, header=0, index_col=0)[COLUMNS + ["Category"]]
        datasets = {
            "Training": {
                "NR": None,
                "R": DataFrame(columns=COLUMNS)},
            "Test": {
                "Chronic": {
                    "NR": table[table.Duration > 2].groupby("Category").get_group("NR").drop(columns="Category"),
                    "R": table[table.Duration > 2].groupby("Category").get_group("R").drop(columns="Category")},
                "Early": {
                    "NR": table[table.Duration <= 2].groupby("Category").get_group("NR").drop(columns="Category"),
                    "R": table[table.Duration <= 2].groupby("Category").get_group("R").drop(columns="Category")}}}
        datasets["Training"]["NR"], datasets["Test"]["Chronic"]["NR"] = train_test_split(
            datasets["Test"]["Chronic"]["NR"],
            train_size=32,
            random_state=0)
        cumulative = Category(
            NR=datasets["Training"]["NR"][["Duration", "Dose"]].prod(axis=1).sort_values(),
            R=datasets["Test"]["Chronic"]["R"][["Duration", "Dose"]].prod(axis=1).sort_values())
        for dose in cumulative.NR:
            unicode = cumulative.R.index[abs(cumulative.R - dose).values.argmin()]
            datasets["Training"]["R"].loc[unicode, :] = datasets["Test"]["Chronic"]["R"].loc[unicode, :]
            datasets["Test"]["Chronic"]["R"].drop(index=unicode, inplace=True)
            cumulative.R.drop(unicode, inplace=True)
        datasets["Training"]["R"] = datasets["Training"]["R"].infer_objects()
        for category in Category._fields:
            self.__loadmat(datasets["Training"], category)
            self.__loadmat(datasets["Test"]["Chronic"], category)
            self.__loadmat(datasets["Test"]["Early"], category)
        datasets = Set(
            Training=Category(**datasets["Training"]),
            Test=Course(
                Chronic=Category(**datasets["Test"]["Chronic"]),
                Early=Category(**datasets["Test"]["Early"])))
        with open("./Downloads/Researches/STRP/Datasets/Datasets.pkl", "wb") as fout:
            pickle.dump(datasets, fout, pickle.HIGHEST_PROTOCOL)
        return datasets

    def __loadmat(self, dataset, category):
        dataset[category].Sex = dataset[category].Sex.astype("category")
        dataset[category] = dataset[category].reindex(columns=COLUMNS + FEATURES)
        assert all(isin(dataset[category].File, os.listdir("/Volumes/Transcend/STRP/")))
        for subject in dataset[category].index:
            print("== Session %s ==" % subject)
            dname = "/Volumes/Transcend/STRP/%s/lddmm-dsi/" % dataset[category].File[subject]
            for index in INDICES:
                matched = list(filter(re.compile(".*\\.%s_Array\\.mat$" % index.lower()).match, os.listdir(dname)))
                assert len(matched) == 1
                features = ["_".join([index, tract.Nickname, str(step)]) for tract in TRACTS for step in range(100)]
                dataset[category].loc[subject, features] = loadmat(dname + matched[0])["array"].reshape(7600)
