#!/usr/bin/env python

from numpy import *
from pandas import DataFrame
from sklearn.model_selection import (KFold, cross_validate)
from matplotlib.pyplot import *
from nmmi.Constants import *
from nmmi.Sample import Sample
from nmmi.Models import (CMA, GPR, Model)
from nmmi.Diagnostics import Diagnostics
from nmmi.Selection import Selection

if __name__ == "__main__":
    (DF, FA) = Sample.load()
    Sample.hist(DF)
    MODELS = [CMA, GPR]
    SCORES = DataFrame(
        index=[
            repeat(Sex._fields, len(MODELS) * len(TRACTS)),
            tile(repeat([model.__name__ for model in MODELS], len(TRACTS)), len(Sex._fields)),
            tile(range(len(TRACTS)), len(Sex._fields) * len(MODELS)),
        ],
        columns=[
            "fit_time",
            "score_time",
            "test_neg_mean_squared_error",
            "train_neg_mean_squared_error",
            "test_r2",
            "train_r2",
        ],
        dtype="float"
    )
    STANDARDS = DataFrame(
        index=[
            repeat(Sex._fields, len(MODELS) * len(TRACTS)),
            tile(repeat([model.__name__ for model in MODELS], len(TRACTS)), len(Sex._fields)),
            tile(range(len(TRACTS)), len(Sex._fields) * len(MODELS)),
        ],
        columns=["p"],
        dtype="float"
    )
    PERCENTAGES = DataFrame(
        index=[
            repeat(Sex._fields, len(MODELS) * len(TRACTS)),
            tile(repeat([model.__name__ for model in MODELS], len(TRACTS)), len(Sex._fields)),
            tile(range(len(TRACTS)), len(Sex._fields) * len(MODELS)),
        ],
        columns=["p"],
        dtype="float"
    )
    for model in MODELS:
        for i in range(len(TRACTS)):
            for sex in Sex._fields:
                x = DF.age.loc[DF.sex == sex.upper()]
                y = FA[i].mean(axis=0)[DF.sex == sex.upper()]
                SCORES.loc[(sex, model.__name__, i)] = DataFrame(cross_validate(
                    model(), x, y,
                    cv=KFold(5, True, 0),
                    scoring=("neg_mean_squared_error", "r2"),
                    return_train_score=True
                )).mean(axis=0)
                diagnostic = Diagnostics(sex, model(), TRACTS[i]).fit(x, y)
                STANDARDS.loc[(sex, model.__name__, i)] = diagnostic.standard()
                PERCENTAGES.loc[(sex, model.__name__, i)] = diagnostic.percentage()
                hist(array(diagnostic.zs)[isfinite(diagnostic.zs)], bins=linspace(-4, 4, 80), alpha=.5)
            xlabel("Z-score")
            ylabel("Frequency")
            legend(list(map(str.capitalize, Sex._fields)))
            savefig("./Downloads/Projects/NMMI/Figures/Residual/{}/{}".format(model.__name__, TRACTS[i].nickname))
            clf()
    Selection.dump(SCORES, STANDARDS, PERCENTAGES)
    (SCORES, STANDARDS, PERCENTAGES) = Selection.load()
    Selection.mse(SCORES)
    Selection.cod(SCORES)
    Selection.standard(STANDARDS)
    Selection.percentage(PERCENTAGES)
    for model in MODELS:
        for i in range(len(TRACTS)):
            Model(DF, model(), TRACTS[i]).scatter(DF.age, FA[i].mean(axis=0))
