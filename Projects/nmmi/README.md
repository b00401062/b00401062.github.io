# Normative Model for Microstructural Integrity (NMMI)

## Importing Data

- [Constants.py](Constants.py): Define a list of constants including tracts and features.
- [Sample.py](Sample.py): Import the sample and display demographics.

## Standardized Pipeline

- [Models.py](Models.py): Models for estimation of normative models.
- [Diagnostics.py](Diagnostics.py): Diagnostic metrics for validation of models.
- [Selection.py](Selection.py): Compare the models with different metrics.
- [Regression.py](Regression.py): Piecewise linear regression to estimate rate of maturation and decline.

## Execution

```bash
export PYTHONHASHSEED=0
export PYTHONPATH=$HOME/Documents/Projects/
python -B -m nmmi
```
