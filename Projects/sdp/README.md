# Schizophrenia Development Prediction (SDP)

## Importing Data

- [Constants.py](Constants.py): Define a list of constants including tracts and features.
- [Dataset.py](Dataset.py): Load training/test sets populated with diffusion indices.

## Analysis Pipeline

- [Selector.py](Selector.py): Test the difference of GFA between the two groups.
- [Reducer.py](Reducer.py): Determine # components for the principal component analysis.
- [Evaluator.py](Evaluator.py): Evaluate the performance of the model on the test set.

## Execution

```bash
export PYTHONHASHSEED=0
export PYTHONPATH=$HOME/Documents/Projects/
python -B -m sdp
```
