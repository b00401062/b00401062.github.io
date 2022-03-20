#!/usr/bin/env python

import os
from numpy import *
from scipy.ndimage import binary_fill_holes
from cv2.saliency import StaticSaliencySpectralResidual_create
from skimage.filters import gaussian
from skimage.morphology import remove_small_objects
from skimage.measure import label
from skimage.measure import regionprops
from matplotlib.pyplot import *


class Cropper:
    def __init__(self, DATASETDIR, RAWDIR):
        self.DATASETDIR = DATASETDIR
        self.RAWDIR = RAWDIR

    def run(self):
        boxes = open(self.DATASETDIR + "Boxes.csv", "w")
        boxes.write("{},{},{},{},{}\n".format("ImageID", "minr", "minc", "maxr", "maxc"))
        for f in os.listdir(self.RAWDIR):
            if f[0] == ".": continue
            X = imread(self.RAWDIR + f)
            S = (gaussian(X, multichannel=True) * 255).astype("uint8")
            M = StaticSaliencySpectralResidual_create().computeSaliency(S)[1]
            M = (M * 255).astype("uint8") >= 10
            M = binary_fill_holes(M)
            L = label(M)
            L = remove_small_objects(L, 4192)
            for i, region in enumerate(regionprops(L)):
                minr, minc, maxr, maxc = region.bbox
                O = X[minr:maxr, minc:maxc]
                if all(ptp(O, 2) <= 40): continue
                boxes.write("{},{},{},{},{}\n".format(f, *region.bbox))
        boxes.close()
