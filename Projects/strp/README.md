# Schizophrenia Treatment Response Prediction (STRP)

## Importing Data

- [Constants.py](Constants.py): define a list of constants including tracts and features.
- [Populator.py](Populator.py): load diffusion indices of chronic and first-episode patients.

## Demographics

- [Demographics.py](Demographics.py): demographics of the participants.

## Standardized Pipeline

- [Pipeline.py](Pipeline.py): define standardized analysis pipeline for each model.
- [Preprocessor.py](Preprocessor.py): preprocess raw data with average and PCA.
- [Validator.py](Validator.py): perform cross validation to select the best hyperparameters and model.
- [Evaluator.py](Evaluator.py): evaluate the performance the final model.

## Execution

```bash
export PYTHONHASHSEED=0
export PYTHONPATH=$HOME/Documents/Projects/
python -B -m strp
```
