#!/usr/bin/env python

from skimage.transform import resize
from skimage.util import pad
from matplotlib.pyplot import (imread, imsave)


class Preprocesser:
    def __init__(self, RAWDIR, PREPROCESSEDDIR, BOXES, S):
        self.RAWDIR = RAWDIR
        self.PREPROCESSEDDIR = PREPROCESSEDDIR
        self.BOXES = BOXES
        self.S = S

    def run(self):
        for i, (f, minr, minc, maxr, maxc) in self.BOXES.iterrows():
            if f[0] == ".": continue
            h = maxr - minr
            w = maxc - minc
            m = max(w, h)
            X = imread(self.RAWDIR + f)[minr:maxr, minc:maxc]
            X = pad(X, ((int((m - h) / 2),) * 2, (int((m - w) / 2),) * 2, (0,) * 2), mode="constant", constant_values=0)
            X = resize(X, (self.S, self.S, 3))
            imsave(self.PREPROCESSEDDIR + f[:-4] + str(minr) + str(minc), X)
