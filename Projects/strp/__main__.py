#!/usr/bin/env python

from sklearn.discriminant_analysis import LinearDiscriminantAnalysis
from sklearn.discriminant_analysis import QuadraticDiscriminantAnalysis
from sklearn.linear_model import LogisticRegression
from sklearn.svm import SVC
from strp.Populator import Populator
from strp.Demographics import Demographics
from strp.Pipeline import Pipeline

if __name__ == "__main__":
    DATASETS, BESTS = Populator().populate()
    Demographics().fit(DATASETS.Training, "Training")
    Demographics().fit(DATASETS.Test.Chronic, "Test 1")
    Demographics().fit(DATASETS.Test.Early, "Test 2")
    PIPELINE = Pipeline(BESTS).fit(DATASETS)
    PIPELINE.run(LinearDiscriminantAnalysis)
    PIPELINE.run(QuadraticDiscriminantAnalysis)
    PIPELINE.run(LogisticRegression)
    PIPELINE.run(SVC)
