# Alpaydin's Introduction to Machine Learning

- Publisher: The MIT Press
- Author: Ethem Alpaydin
- Presenter: Wen-Bin Luo
- Link: https://www.amazon.com/Introduction-Machine-Learning-Adaptive-Computation-dp-0262043793/dp/0262043793/ref=dp_ob_title_bk

## Introduction

### What Is Machine Learning?

- **Machine learning** is programming computers to optimize a performance criterion using example data or past experience.

### Examples of Machine Learning Applications

#### Association Rules

- Finding association rules can help build a recommendation system.

#### Classification

- Learning a rule from data also allows **knowledge extraction**.
- **Outlier detection** is finding instances that do not obey the general rule and are exceptions.

#### Regression

- Problems where the output is a number are **regression** problems.

#### Unsupervised Learning

- Both regression and classification are **supervised learning**.
- In unsupervised learning, the aim is to find the regularities in the input.
- One method for density estimation is **clustering**.

#### Reinforcement Learning

- In reinforcement learning, the output of the system is a sequence of *actions*.

### History

- Almost all of science is fitting models to data.
- In statistics, going from particular observations to general descriptions is called *inference*, and learning is called *estimation*.

### Related Topics

#### High-Performance Computing

- Distribute storage and processing efficiently over many computers is important for big data.
- GPUs allow large chunks of data to be moved and processed in parallel.
- Good software is needed to manage the execution of the task on parallel hardware.

#### Data Privacy and Security

- Personal data should be sanitized by hiding all the personal details.

#### Model Interpretability and Trust

- A small test error is considered as a good criterion of the generalization ability.
- A poorly-generalized system is specialized to its training data and sensitive to *adversarial examples*.
- Explainable articial intelligence implies that a model is interpretable.

#### Data Science

- Machine learning is a new field of data science.

## Supervised Learning

### Learning a Class from Examples

- **Generalization**: How well a hypothesis will correctly classify future examples that are not part of the training set.
- **Margin**: the distance between the boundary and the instances closest to it.

### Vapnik-Chervonenkis Dimension

- $H$ is said to **shatters** $N$ points if any learning problem definable by #N# examples can be learned with no error by a hypothesis drawn from $H$.
- **Vapnik-Chervonenkis (VC) dimension** of $H$, denoted as VC($H$), is the maximum number of points that can be shattered by $H$.
- VC dimension is independent of the probability distribution from which instances are drawn.
