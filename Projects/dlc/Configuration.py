#!/usr/bin/env python

from collections import namedtuple

Set = namedtuple("Set", ["training", "test"])
DATASETDIR = "./"
RAWDIR = DATASETDIR + "Raw/"
PREPROCESSEDDIR = DATASETDIR + "Preprocessed/"
S = 224
