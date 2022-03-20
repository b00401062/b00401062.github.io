#!/usr/bin/env python

from numpy import random
from pandas import (DataFrame, Series, concat)
from sklearn.metrics import confusion_matrix
from strp.Constants import *


class Evaluator:
    def __init__(self, preprocessor):
        self.preprocessor = preprocessor
        self.title = "".join([c for c in preprocessor.estimator.__class__.__name__ if c.isupper()])
        self.threshold = None

    def fit(self, dataset):
        assert hasattr(self.preprocessor, "decision_function")
        print("\n## Evaluation Session: %s\n" % self.title)
        X = concat((dataset.NR, dataset.R))
        y = Series(
            ["NR"] * dataset.NR.shape[0] + ["R"] * dataset.R.shape[0],
            index=dataset.NR.index.append(dataset.R.index),
            dtype="category"
        ).rename("Category")
        self.preprocessor.fit(X, y)
        return self

    def predict(self, dataset, title=None):
        print("- Contingency table: %s" % title)
        X = concat((dataset.NR, dataset.R))
        y = Series(
            ["NR"] * dataset.NR.shape[0] + ["R"] * dataset.R.shape[0],
            index=dataset.NR.index.append(dataset.R.index),
            dtype="category"
        ).rename("Category")
        prediction = self.preprocessor.predict(X)
        Evaluator.__print_confusion_matrix(y, prediction)
        return prediction

    def transfer(self, dataset, title=None):
        X = concat((dataset.NR, dataset.R))
        y = Series(
            ["NR"] * dataset.NR.shape[0] + ["R"] * dataset.R.shape[0],
            index=dataset.NR.index.append(dataset.R.index),
            dtype="category"
        ).rename("Category")
        pool = Set(Training=Outcome(Actual=[], Predicted=[]), Test=Outcome(Actual=[], Predicted=[]))
        random.seed(0)
        for _ in range(400):
            train = random.choice(range(y.size), round(y.size * .6), replace=False)
            test = list(set(range(y.size)) - set(train))
            self.preprocessor.estimator.fit(self.preprocessor.transform(X.iloc[train]), y[train])
            pool.Training.Actual.extend(y[train])
            pool.Training.Predicted.extend(self.preprocessor.estimator.predict(self.preprocessor.transform(X.iloc[train])))
            pool.Test.Actual.extend(y[test])
            pool.Test.Predicted.extend(self.preprocessor.estimator.predict(self.preprocessor.transform(X.iloc[test])))
        print("- Contingency table: %s Training" % title)
        Evaluator.__print_confusion_matrix(pool.Training.Actual, pool.Training.Predicted)
        print("- Contingency table: %s Test" % title)
        Evaluator.__print_confusion_matrix(pool.Test.Actual, pool.Test.Predicted)

    @staticmethod
    def __print_confusion_matrix(y, prediction):
        table = confusion_matrix(y, prediction)
        table[0, 0], table[1, 1] = table[1, 1], table[0, 0]
        table = DataFrame(table)
        table.columns = ["Actual R", "Actual NR"]
        table.index = ["Predicted R", "Predicted NR"]
        tn = table.loc["Predicted NR", "Actual NR"]
        tp = table.loc["Predicted R", "Actual R"]
        fn = table.loc["Predicted NR", "Actual R"]
        fp = table.loc["Predicted R", "Actual NR"]
        acc = (tp + tn) / (tp + fp + tn + fn)
        sen = tp / (tp + fn)
        spe = tn / (tn + fp)
        ppv = tp / (tp + fp)
        npv = tn / (tn + fn)
        for k, v in Result(acc, sen, spe, ppv, npv)._asdict().items():
            print("\t- %s: %.4f" % (k, v))
        lines = table.to_csv(sep="|").strip().split("\n")
        lines.insert(1, ":-:|:-:|:-:")
        print()
        for line in lines: print("|%s|" % line)
        print()
        return Result(acc, sen, spe, ppv, npv)
