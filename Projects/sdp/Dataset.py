#!/usr/bin/env python

from numpy import *
from pandas import (DataFrame, read_csv)
from re import compile
from scipy.io import loadmat
from sdp.Constants import *

class Dataset:
    @staticmethod
    def get(indices, tracts):
        dataset = {"training": {"X": None, "y": None}, "test": {"X": None, "y": None}}
        values = empty((128, 0))
        for index in indices:
            raw = loadmat("./Downloads/Projects/SDP/Datasets/all_array_{}.mat".format(index.lower()))
            for tract in tracts:
                values = hstack((values, array(list(map(lambda x: x[tract.indices].mean(axis = 0), raw["array"][0])))))
        pattern = "F:\\\\[^\\\\]+\\\\[^\\\\]+\\\\([^\\\\]+)\\\\.*"
        subjects = array(list(map(compile(pattern).findall, map(lambda x: x[0][0], raw["index_name"])))).flatten()
        subjects = array(list(map(str.upper, subjects)))
        for set in Set._fields:
            file = "./Downloads/Projects/SDP/Datasets/{}.csv".format(set.capitalize())
            metadata = read_csv(file, index_col = 0)
            mask = isin(subjects, metadata.index)
            dataset[set]["X"] = DataFrame(values[mask], index = subjects[mask]).dropna(axis = 1)
            dataset[set]["y"] = metadata.final[subjects[mask]].astype("category")
        return Set(training = Data(**dataset["training"]), test = Data(**dataset["test"]))
