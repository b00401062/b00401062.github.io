#!/usr/bin/env python

import os
from pandas import (DataFrame, read_csv)
from sklearn.model_selection import train_test_split
from dlc.Configuration import Set


class Dataset:
    def __init__(self, DATASETDIR, PREPROCESSEDDIR):
        self.DATASETDIR = DATASETDIR
        self.PREPROCESSEDDIR = PREPROCESSEDDIR

    def load(self):
        if os.path.isfile("Labels.csv"):
            LABELS = read_csv(self.DATASETDIR + "Labels.csv")
        else:
            fs = os.listdir(self.PREPROCESSEDDIR)
            fs = list(filter(lambda f: f.split("_")[1] == "IMG", fs))
            labels = list(map(lambda f: f.split("_")[0], fs))
            LABELS = DataFrame({"ImageID": fs, "Label": labels})
            LABELS.to_csv(self.DATASETDIR + "Labels.csv", index=False)
        LABELS.Label = LABELS.Label.astype("category")
        LABELS = Set(*train_test_split(LABELS, test_size=0.2, stratify=LABELS.Label))
        LABELS.training.index = list(range(LABELS.training.shape[0]))
        LABELS.test.index = list(range(LABELS.test.shape[0]))
        return LABELS
