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

- $H$ is said to **shatters** $N$ points if any learning problem definable by $N$ examples can be learned with no error by a hypothesis drawn from $H$.
- **Vapnik-Chervonenkis (VC) dimension** of $H$, denoted as VC($H$), is the maximum number of points that can be shattered by $H$.
- VC dimension is independent of the probability distribution from which instances are drawn.
- VC dimension may seem pessimistic.

### Probably Approximately Correct Learning

- In **probably approximately correct (PAC) learning**, the hypothesis is approximately correct.
- The error probability is bounded by some value.

### Noise

- **Noise** is any unwanted anomaly in the data.
- There are several interpretations of noise:
  - Imprecision in recording the input attributes.
  - Errors in labeling the data points.
  - *Hidden* or *latent* attributes not taken into account.
- **Occam's razor**: simpler explanations are more plausible and any unnecessary complexity should be shaved off.

### Learning Multiple Classes

- If all classes have similar distribution, then the same hypothesis class can be used for all classes.
- Alternatively, sometimes it is preferable to build different hypotheses for different classes.

### Regression

- If there is no noise, the task is **interpolation**.
- In **regression**, there is noise added to the output of the unknown function.

### Model Selection and Generalization

- An **ill-posed problem** where the data by itself is not sufficient to find a unique solution.
- The set of assumptions we make to have learning possible is called the **inductive bias** of the learning algorithm.
- **Model selection** is the question is how to choose the right bias.
- How well a model trained on the training set predicts the right output for new instances is called **generalization**.
- **Underfitting** is when $H$ is less complex than the function.
- **Overfitting** is when an overcomplex hypothesis learns not only the underlying function but also the noise in the data.
- **Triple trade-off** is a trade-off between three factors in all learning algorithms:
  - The complexity of the hypothesis.
  - The amount of training data.
  - The generalization error on new examples.
- **Validation set** and is used to test the generalization ability.
- A **test set**, sometimes also called the publication set, contains examples not used in training or validation.

### Dimensions of a Supervised Machine Learning Algorithm

- Three decisions we must make during machine learning:
  - Model used in learning, $g(x\|θ)$.
  - Loss function, $L(·)$.
  - Optimization procedure to find $θ^\*$ that minimizes the total error.

### Notes

- Active learning where the learning algorithm can generate instances itself and ask for them to be labeled.

## Bayesian Decision Theory

### Introduction

- In reality, we have $x = f(z)$, where
  - $x$ is the observable variables.
  - $z$ is the unobservable variables.
  - $f(·)$ is the deterministic function that defines the outcome from the unobservable pieces of knowledge.

### Classification

- The **Bayes' classifier** chooses the class with the highest posterior probability.

### Losses and Risks

- It may be the case that decisions are not equally good or costly.
- Some wrong decisions, namely, misclassifications, may have very high cost.

### Discriminant Functions

- Discriminant functions divide the feature space into decision regions.
- When $K = 2$, the classification system is a **dichotomizer** and for $K ≥ 3$, it is a **polychotomizer**.

### Association Rules

- An association rule is an implication of the form $X → Y$.
- One example of association rules is in basket analysis.
- Three measures in learning association rules:
  - **Support**: $P(X,Y)$
  - **Confidence**:  $P(Y\|X)$
  - **Lift** or **interest**: $P(Y\|X)/P(Y)$
