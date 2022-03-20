# MATLAB Deep Learning Challenge

## Pipeline

- [Configuration.py](Configuration.py): Specifying folders and initial values of hyperparameters.
- [Cropper.py](Cropper.py): Crop images to focus on object(s) of interest.
- [Preprocessor.py](Preprocessor.py):  Resize cropped images for subsequent neural networks.
- [Dataset.py](Dataset.py): Load metadata and features into the scope.
- [Classifier.py](Classifier.py): Feed training data to models and evaluate the performance.

## Execution

```bash
export PYTHONHASHSEED=0
export PYTHONPATH=$HOME/Documents/Projects/
python -B -m dlc
```
