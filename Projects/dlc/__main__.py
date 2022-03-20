#!/usr/bin/env python

from pandas import read_csv
from dlc.Configuration import *
from dlc.Cropper import Cropper
from dlc.Preprocessor import Preprocesser
from dlc.Dataset import Dataset
from dlc.Classifier import Classifier

if __name__ == "__main__":
    Cropper(DATASETDIR, RAWDIR).run()
    BOXES = read_csv(DATASETDIR + "Boxes.csv")
    Preprocesser(RAWDIR, PREPROCESSEDDIR, BOXES, S).run()
    LABELS = Dataset(DATASETDIR, PREPROCESSEDDIR).load()
    model = Classifier(PREPROCESSEDDIR, S).fit(LABELS)
