#!/usr/bin/env python

from sklearn.metrics import confusion_matrix
from sklearn.metrics import roc_curve, roc_auc_score
from matplotlib.pyplot import *


class Evaluator:
    def __init__(self, reducer, classifier):
        self.reducer = reducer
        self.classifier = classifier

    def fit(self, X, y):
        print(confusion_matrix(y, self.classifier.predict(self.reducer.transform(X))))
        p = self.classifier.predict_proba(self.reducer.transform(X))[:, 1]
        plot(*roc_curve(y == "S", p)[:2], label="AUC: {:.2f}".format(roc_auc_score(y == "S", p)))
        plot([0, 1], [0, 1], linestyle="--")
        xlabel("1 - Specificity")
        ylabel("Sensitivity")
        legend(loc="lower right")
        axes().set_aspect("equal")
        savefig("./Downloads/Projects/SDP/Figures/ROC")
        clf()
        return self
