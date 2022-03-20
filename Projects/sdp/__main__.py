#!/usr/bin/env python

from sklearn.gaussian_process import GaussianProcessClassifier
from sdp.Constants import *
from sdp.Dataset import Dataset
from sdp.Selector import Selector
from sdp.Reducer import Reducer
from sdp.Evaluator import Evaluator

if __name__ == "__main__":
    for tract in TRACTS:
        DATASET = Dataset.get(["GFA"], [tract])
        Selector(tract).fit(*DATASET.test).pvalue
    DATASET = Dataset.get(["GFA"], list(map(lambda i: TRACTS[i], [5, 8])))
    reducer = Reducer().fit(*DATASET.training)
    classifier = GaussianProcessClassifier()
    classifier.fit(reducer.fit_transform(DATASET.training.X), DATASET.training.y)
    Evaluator(reducer, classifier).fit(*DATASET.test)
