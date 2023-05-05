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
- In statistics:
  - Going from particular observations to general descriptions is called *inference*.
  - Learning is called *estimation*.

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

- $H$ **shatters** $N$ points if:
  - For any learning problem definable by $N$ examples.
  - It can be learned with no error by a hypothesis drawn from $H$.
- **Vapnik-Chervonenkis (VC) dimension** of $H$, VC($H$), is the maximum number of points that can be shattered by $H$.
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
  - Model used in learning, $\hat{f}(x\|θ)$.
  - Loss function, $L(·)$.
  - Optimization procedure to find $θ^\*$ that minimizes the total error.

### Notes

- Active learning where the learning algorithm can generate instances itself and ask for them to be labeled.

## Bayesian Decision Theory

### Introduction

- In reality, we have $x$ = $f(z)$, where:
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
- When $K$ = 2, the classification system is a **dichotomizer** and for $K$ ≥ 3, it is a **polychotomizer**.

### Association Rules

- An association rule is an implication of the form $X → Y$.
- One example of association rules is in basket analysis.
- Three measures in learning association rules:
  - **Support**: $P(X,Y)$
  - **Confidence**: $P(Y\|X)$
  - **Lift** or **interest**: $P(Y\|X)/P(Y)$

## Parametric Methods

### Introduction

- The model is defined up to a small number of parameters.
- The estimated distribution is then used to make a decision.
- The method used to estimate the parameters of a distribution is maximum likelihood estimation.

### Maximum Likelihood Estimation

- The **likelihood** of parameter $θ$ given sample $X$ is the product of the likelihoods of the individual points.
- **Maximum likelihood estimator**: $\hat{θ}$ = $\text{argmax}_{θ}\ p(X\|θ)$.

#### Bernoulli Density

- The estimate for $p$ is the ratio of the number of occurrences of the event to the number of experiments.

#### Multinomial Density

- The estimate for $p_i$ is the ratio of experiments with outcome of state $i$ to the total number of experiments.

#### Gaussian (Normal) Density

- The estimate for $μ$ is sample mean $m$.
- The estimate for $σ^2$ is sample variance $s^2$.

### Evaluating an Estimator: Bias and Variance

- Let $X$ be a sample from a population specified up to a parameter $θ$.
- Let $\hat{θ}$ be an estimator of $θ$, which is learned from $X$.
- The **mean square error (MSE)** of the estimator $\hat{θ}$ is defined as $r(\hat{θ},θ)$ = $E[(\hat{θ}-θ)^2]$
- The **bias** of an estimator is given as $b_θ(\hat{θ})$ = $E[\hat{θ}]-θ$.
- $\hat{θ}$ is an **unbiased estimator** of $θ$ if $b_θ(\hat{θ})$ = 0 for all $θ$ values.
- In Gaussian density:
  - $s^2$ is a biased estimator of $σ^2$.
  - $(N/(N−1))s^2$ is an unbiased estimator.
  - $s^2$ is an *asymptotically unbiased estimator* whose bias goes to 0 as $N$ goes to infinity.
- $r(\hat{θ},θ)$ = $E[(\hat{θ}-θ)^2]$ = $(E[\hat{θ}]-θ)^2 + E[(\hat{θ}-E[\hat{θ}])^2]$ = $b_θ(\hat{θ})^2 + \text{Var}(\hat{θ})$.
- MSE = bias squared + variance.

### The Bayes' Estimator

- Prior information on the possible distribution of a parameter, $θ$.
- Evaluating posterior density can involve intractable integrals.
- When the full integration is not feasible, we reduce it to a single point.
- **Maximum a posteriori (MAP) estimator**: $\hat{θ}$ = $\text{argmax}_{θ}\ p(θ\|X)$.
- If there is no prior knowledge of $θ$, the MAP estimate will be equivalent to the MLE.
- **Bayes' estimator**: $\hat{θ}$ = $E[θ\|X]$.
- Both MAP and Bayes' estimators reduce the whole posterior density to a single point.
- **Monte Carlo** approach generates samples from the posterior density.

### Parametric Classification

- The discriminant function: $f_i(x)$ = $p(x\|C_i)P(C_i)$.
- $P(C_i)$ and $p(x\|C_i)$ are estimated from a sample.
- Their estimates are plugged in to get the estimate for the discriminant function.
- Decision: $\hat{y}$ = $C_i$ that maximizes $f_i(x)$.
- *Likelihood-based approach* to classification:
  1. Estimate the densities separately.
  2. Calculate posterior densities using Bayes' rule.
  3. Get the discriminant.
- *Discriminant-based approach* directly estimates the discriminants.

### Regression

- $y$ = $f(x) + ϵ$ where:
  - $f(x)$ is some unknown function whose estimator is $\hat{f}(x\|θ)$.
  - $ϵ$ is zero mean Gaussian with constant variance $σ^2$.
- $p(y\|x) \sim N(\hat{f}(x\|θ),σ^2)$.
- Use maximum likelihood to learn the parameters $θ$.
- Decision: $\hat{y}$ = $\hat{f}(x\|\hat{θ})$.
- **Total sum-of-squares (TSS)** = $\sum (y_i-\bar{y})^2$.
- **Residual sum-of-squares (RSS)** = $\sum (y_i-\hat{y})^2$.
- **Explained sum-of-squares (ESS)** = $\sum (\hat{y}-\bar{y})^2$.
- TSS = RSS + ESS.
- A measure to check the goodness of fit by regression is the **coefficient of determination**.
- **Coefficient of determination**: $R^2$ = ESS/TSS = 1 - RSS/TSS.

### Tuning Model Complexity: Bias/Variance Dilemma

- MSE = bias squared + variance.
- The bias/variance dilemma and is true for any machine learning system:
  - **Underfitting**: If there is bias, this indicates that the model class does not contain the solution.
  - **Overfitting**: If there is variance, the model class is too general and also learns the noise.
- The optimal model is the one that has the best trade-off between the bias and the variance.

### Model Selection Procedures

- One approach to find the optimal complexity is **cross-validation**.
- Another approach that is used frequently is **regularization**.
  - Regularization penalizes complex models with large variance.
  - Regularization can be seen as an *optimism* term estimating the discrepancy between training and test error.
- **Akaike's information criterion (AIC)** and **Bayesian information criterion (BIC)**:
  - Estimating the optimism.
  - Adding the optimism to the training error to estimate test error.
  - No need for validation.
- **Structural risk minimization (SRM)** uses a set of models ordered in terms of their complexities.
- **Minimum description length (MDL)** is based on an information theoretic measure.
- **Bayesian model selection** is used when there is prior knowledge about the class of approximating functions.

## Multivariate Methods

### Multivariate Data

-  The sample may be viewed as a *data matrix*
  - Columns represent inputs, features, or attributes.
  - Rows represent observations, examples, or instances.
- Typically these variables are correlated; otherwise; there is no need for a multivariate analysis.

### Parameter Estimation

- The maximum likelihood estimator for the mean $μ$ is the sample mean, $m$.
- The estimator of $Σ$ is $S$, the sample covariance matrix.

### Estimation of Missing Values

- **Imputation**: fill in the missing entries by estimating them.

### Multivariate Normal Distribution

- **Mahalanobis distance** is given as $(x−μ)^⊤Σ^{−1}(x−μ)$.
- $(x−μ)^⊤Σ^{−1}(x−μ)$ = $c^2$ is the multi-dimensional hyperellipsoid:
  - It is centered at $μ$.
  - Its shape and orientation are defined by $Σ$.

### Multivariate Classification

- The class-conditional densities, $p(x\|C_i)$, are taken as normal density, $N(μ_i,Σ_i)$.
- Reducing covariance matrix through simplifying assumptions:
  - **Quadratic discriminant**
  - **Linear discriminant**
    - The covariance matrix is shared by all classes.
  - **Naive Bayes' classifier**
    - The covariance matrix is shared by all classes.
    - All off-diagonals of the covariance matrix are 0.
  - **Nearest mean classifier**
    - The covariance matrix is shared by all classes.
    - All off-diagonals of the covariance matrix are 0.
    - All variances are equal.

### Tuning Complexity

- **Regularized discriminant analysis (RDA)**: $S_i'$ = $ασ^2I + βS + (1-α-β)S_i$
  - When $α$ = $β$ = 0: quadratic discriminant.
  - When $α$ = 0 and $β$ = 1: linear discriminant. 
  - When $α$ = 1 and $β$ = 0: nearest mean classifier.
  - In between these extremes, $α$ and $β$ are optimized by cross-validation.

### Discrete Features

### Multivariate Regression

- In statistical literature, this is called **multiple regression**.
- Statisticians use the term *multivariate* when there are multiple outputs.

## Dimensionality Reduction

### Introduction

- Two main methods for reducing dimensionality:
  - **Feature selection**: finding $k$ of the $d$ dimensions that give the most information.
  - **Feature extraction**: finding a new set of $k$ dimensions that are combinations of the original $d$ dimensions.
- These methods may be supervised or unsupervised.

### Subset Selection

- Two approaches: **forward selection** and **backward selection**.
- Checking the error should be done on a validation set.
- The *sequential* selection algorithm is also known as **wrapper** approach. 
- The features we select at the end depend heavily on the classifier we use.
- This process of testing features one by one may be costly.
- Subset selection is supervised.

### Principal Component Analysis

- PCA is an unsupervised method.
- The principal component is the eigenvector of $X^⊤X$, or the covariance matrix $Σ$.
- Proportion of variance explained by the $k$ principal components is $\sum_{i=1}^k λ_i/\sum_{i=1}^d λ_i$.
- **Scree graph** is the plot of variance explained as a function of the number of eigenvectors kept.
- PCA explains variance and is sensitive to outliers.
- PCA minimizes the **reconstruction error**.

### Feature Embedding

- The $N$-dimensional eigenvectors of $XX^⊤$ are the coordinates in the new space.
- Feature embedding does not generate projection vectors but the coordinates directly.
- Feature embedding places instances in a $k$-dimensional space such that pairwise similarities are preserved.

### Factor Analysis

- FA assumes that there is a set of unobservable, **latent factors** $z$.
- FA partitions variables into groups that have high correlation among themselves.
- Latent factors $z$ have the properties: $E[z_i]$ = 0, $\text{Var}(z_i)$ = 1, and $\text{Cov}(z_i,z_j)$ = 0.
- $x_i-μ_i$ = $\sum_{j=1}^k v_{ij}z_j+ϵ_i$: Each input dimension is a weighted sum of the factors plus the residual term.
- Residual terms $ϵ$ have the properties: $E[ϵ_i]$ = 0, $\text{Var}(ϵ_i)$ = $ψ_i$, and $\text{Cov}(ϵ_i,ϵ_j)$ = 0.
- $Σ$ = $WW^⊤+Ψ$ where:
  - $Σ$ is the covariance matrix of $X$
  - $W$ is the **factor loadings**, the $d × k$ matrix of weights that transform latent factors to input dimension.
  - $Ψ$ is a diagonal matrix with $ψ_i$ on the diagonals.
- **Probabilistic PCA** is when all $ψ_i$ are equal, namely, $Ψ$ = $ψI$.
- Conventional PCA is when $Ψ$ = 0.
- For dimensionality reduction, FA offers no advantage over PCA.

### Singular Value Decomposition and Matrix Factorization

- **Singular value decomposition** $X$ = $UΛV^⊤$ where:
  - $U$ contains the eigenvectors of $XX^⊤$.
  - $V$ contains the eigenvectors of $X^⊤X$.
  - $Λ$ contains the $k$ = $\text{min}(N,d)$ singular values on its diagonal.
- **Matrix factorization** decomposes a large matrix into a product of (generally) two matrices.

### Multidimensional Scaling

- MDS places points in a low dimensional space such that the distance between them is as close as possible to the original space.
- **Sammon mapping**: a nonlinear mapping from the original space to a low dimensional space.
- **Sammon stress**: the normalized error in mapping.
- MDS does not learn a general mapping function.

### Linear discriminant analysis

- LDA is a supervised method for dimensionality reduction for classification problems.
- LDA finds the projection such that examples from different classes are as well separated as possible.

### Canonical Correlation Analysis

- CCA reduces the dimensionality of two sets of variables to a joint space.
- CCA maximizes the correlation between two sets of variables after projection.
- For CCA to make sense, the two sets of variables need to be dependent.
- It is possible to generalize CCA for more than two sets of variables.

### Isomap

- **Geodesic distance** is the distance along the manifold.
- **Isometric feature mapping** estimates the geodesic distance and applies MDS, using it for dimensionality reduction.
- As with MDS, Isomap uses feature embedding and does not learn a general mapping function.

### Locally Linear Embedding

- LLE recovers global nonlinear structure from locally linear fits.
- Each local patch of the manifold is approximated linearly.
- Given enough data, each point can be written as a linear, weighted sum of its neighbors.
- The reconstruction weights reflect the intrinsic geometric properties of the data.
- As with Isomap, LLE solution is the set of new coordinates.
- In both Isomap and LLE, there is local information that is propagated over neighbors to get a global solution.

### Laplacian Eigenmaps

- Similar to Isomap and LLE,  Laplacian eigenmaps care for similarities only locally.
- The Laplacian eigenmap is also a feature embedding method.

### t-Distributed Stochastic Neighbor Embedding

- In **stochastic neighbor embedding (SNE)**, the neighborhood structure is represented by probabilities calculated from distances.
- t-stochastic neighbor embedding (t-SNE), which is the improved version of SNE.
- This optimization problem is not convex; there is no single best solution.
- *Gradient descent* is used to obtain local optimum.

### Notes

- There is a trade-off between feature extraction and decision making.
- There exist algorithms that do some feature selection internally, though in a limited way.

## Clustering

### Introduction

- **Semiparametric density estimation** still assumes a parametric model for each group in the sample.
- Clustering is also used for preprocessing.

### Mixture Densities

- The **mixture density** is written as $p(x)$ = $\sum_{i=1}^k p(x\|G_i)P(G_i)$ where:
  - $G_i$ are the **mixture components** or **group** or **clusters**.
  - $p(x\|G_i)$ are the **component densities**.
  - $P(G_i)$ are the **mixture proportions**.
- Parametric classification is a bona fide mixture model where groups $G_i$ correspond to classes $C_i$.

### k-Means Clustering

- k-mean finds codebook vectors that minimize the total **reconstruction error**.
- The reference vector is set to the mean of all the instances that it represents.
- There are also algorithms for adding new centers incrementally or deleting empty ones.
- **Leader cluster algorithm**:
  - An instance that is far away from existing centers causes the creation of a new center.
  - A center that covers a large number of instances can be split into two.

### Expectation-Maximization Algorithm

- EM looks for the component density parameters that maximize the likelihood of the sample.
- EM has no analytical solution and needs to resort to iterative optimization.
- The EM algorithm works as follows:
  - **E-step**: estimate these labels given our current knowledge of components.
  - **M-step**: update component knowledge given the labels estimated in the E-step.
- EM is initialized by k-means.
- k-means clustering is a special case of EM applied to Gaussian mixtures where:
  - Inputs have equal and shared variances.
  - All components have equal priors.
  - Labels are hardened.

### Mixtures of Latent Variable Models

- Full covariance matrices used with Gaussian mixtures are subject to overfitting.
- The alternative is dimensionality reduction in the clusters.

### Supervised Learning after Clustering

- A large amount of unlabeled data is used for learning the cluster parameters.
- Then, smaller labeled data is used to learn the second stage of classification or regression.

### Spectral Clustering

- Clustering can be applied in reduced dimensionality.
- Laplacian eigenmaps place the data instances in such a way that given pairwise similarities are preserved.

### Hierarchical Clustering

- It is one of the methods for clustering that use only similarities of instances.
- A similarity, or equivalently a distance, measure is defined between instances.
- Two approaches to hierarchical clustering: **agglomerative clustering** and **divisive clustering**.
- At each iteration of an agglomerative algorithm, the two closest groups are merged.
- The distance between two groups is defined as:
  - **Single-link**: the smallest distance between all possible pairs of elements of the two groups.
  - **Complete-link**: the largest distance between all possible pairs.
  - Other possibilities: **average-link** and **centroid-link**.
- A hierarchical structure is usually represented as a dendrogram.

### Choosing the Number of Clusters

- $k$ is the hyperparameter in clustering.
- $k$ can be predefined by applications
- Plotting the data in lower dimensions helps determine $k$.
- Validation of the groups can be done manually by checking whether clusters are meaningful.
- The reconstruction error or log-likelihood is plotted as a function of $k$.
- The "elbow" is chosen as a heuristic.

## Nonparametric Methods

### Introduction

- In parametric methods, a model is valid over the whole input space.
- In nonparametric estimation, it is assumed that similar inputs have similar outputs.
- The algorithm is composed of:
  - Finding similar past instances from the training set using a suitable distance measure.
  - Interpolating from them to find the right output.
- Nonparametric methods are also called **instance-based** or **memory-based** learning algorithms.
- Its complexity depends on the size of the training set.

### Nonparametric Density Estimation

- $x$ is drawn independently from some unknown probability density $p(·)$.
- $\hat{p}(·)$ is the estimator of $p(·)$.

#### Histogram Estimator

- The input space is divided into equal-sized intervals named bins.
- The **histogram estimate** is given as $\hat{p}(·)$ = #{ $x_i$ in the same bin as $x$ } / $Nh$.
- In constructing the histogram, both an origin and a bin width have to be determined.
- The **naive estimator** is the histogram estimate where $x$ is always at the center of a bin of size $h$.

#### Kernel Estimator

- A kernel function is used to get a smooth estimate.
- The **kernel estimator**, also called **Parzen windows**, is defined as $\hat{p}(x)$ = $\sum_i K(\frac{x-x_i}{h})/Nh$ where:
  - The **kernel function** $K(·)$ determines the shape of the influences.
  - The window width $h$ determines the width.
- Various adaptive methods have been proposed to tailor $h$ as a function of the density around $x$.

#### k-Nearest Neighbor Estimator

- The amount of smoothing is adapted to the local density of data.
- The degree of smoothing is controlled by $k$, the number of neighbors taken into account.
- The **k-nearest neighbor** (k-nn) density estimate is given as $\hat{p}(x)$ = $k/(2Nd_k(x))$.
- This is like a naive estimator with $h$ = $2d_k(x)$.
- The k-nn estimator is not continuous and is not a probability density function.
- To get a smoother estimate, a kernel function can be incorporated.

### Generalization to Multivariate Data

- In high-dimensional spaces, nonparametric estimates are subject to the **curse of dimensionality**.
- In high dimensions, the concept of "close" also becomes blurry.

### Nonparametric Classification

- The class-conditional densities, $p(x\|C_i)$, is estimated using the nonparametric approach.
- For the special case of k-nn estimator, $\hat{p}(x\|C_i)$ = $k_i/N_iV^k(x)$ where:
  - $k_i$ is the number of neighbors out of the $k$ nearest that belong to $C_i$.
  - $V^k(x)$ is the volume of the $d$-dimensional hypersphere centered at $x$.
- The **k-nn classifier** has a posterior density $\hat{p}(C_i\|x)$ = $k_i/k$.
- A special case of k-nn is the **nearest neighbor classifier** where $k$ = 1.

### Condensed Nearest Neighbor

- Time and space complexity of nonparametric methods are proportional to the size of the training set.
- *Condensing* methods have been proposed to decrease the number of stored instances without degrading performance.
- Only the instances that define the discriminant need to be kept.

### Distance-Based Classification

- Most classification algorithms can be recast as a distance-based classifier.
- *Locally adaptive distance functions* can be defined and used.
- The idea of distance learning is to parameterize $D(x,x_i\|θ)$.
- $θ$ is learnt from a labeled sample in a supervised manner.

### Outlier Detection

- An **outlier**, **novelty**, or **anomaly** is an instance that is very much different from other instances in the sample.
- **Outlier detection** is not generally cast as a supervised, two-class classification problem.
- It is sometimes called **one-class classification**.

### Nonparametric Regression: Smoothing Models

- The only assumption is that close $x$ have close $\hat{f}(x)$ values.
- The nonparametric regression estimator is also called a **smoother** and the estimate is called a **smooth**.

#### Running Mean Smoother

- **Regressogram** is the average the $y$ values in the bin.
- As in the naive estimator, in the running mean smoother, a bin can be symmetric around $x$.

#### Kernel Smoother

- As in the kernel estimator, **kernel smoother** gives less weight to further points.
- **k-nn smoother** fixes $k$ and adapts the estimate to the density around $x$.

#### Running Line Smoother

- **Running line smoother**:
  - Uses the data points in the neighborhood, as defined by $h$ or $k$.
  - Fits a local regression line.
- **Locally weighted running line smoother**, known as **loess**, uses kernel weighting.

### How to Choose the Smoothing Parameter

- The critical parameter is the smoothing parameter as used in:
  - Bin width or kernel spread $h$.
  - The number of neighbors $k$.
- A regularized cost function is used in **smoothing splines**.
- Cross-validation is used to tune $h$, $k$, or $λ$.

## Decision Trees

### Introduction

- A **decision tree** is a hierarchical model for supervised learning.
- The local region is identified in a sequence of recursive splits in a smaller number of steps.
- A decision tree is composed of internal decision nodes and terminal leaves.
- Each decision node $m$ implements a test function $f_m(x)$.
- This process starts at the root and is repeated recursively until a **leaf node** is hit.
- The value written in the leaf constitutes the output.
- A decision tree is also a nonparametric model.
- Each $f_m(x)$ defines a discriminant in the $d$-dimensional input space.
- The hierarchical placement of decisions allows a fast localization of the region covering an input.

### Univariate Trees

- In a **univariate tree**, in each internal node, the test uses only one of the input dimensions.
- Successive decision nodes generate splits orthogonal to each other.
- Tree induction is the construction of the tree given a training sample.
- Tree learning algorithms are greedy.

#### Classification Trees

- The goodness of a split is quantified by an **impurity measure**.
- For a two-class problem, $ϕ(p,1-p)$ is a nonnegative function measuring the impurity of a split.
- Examples of impurity measure: **entropy**, **Gini index**, and **misclassification error**.
- The algorithm looks for the split that minimizes impurity after the split.
- It is locally optimal, and the smallest decision tree is not guaranteed.
- This is the basis of the **classification and regression tree (CART)** algorithm.
- One problem is that such splitting favors attributes with many values.
- Growing the tree until it is purest may result in a very large tree and overfitting.
- The posterior probabilities of classes should be stored in a leaf.

#### Regression Trees

- In regression, the goodness of a split is measured by the mean square error from the estimated value.
- This creates a piecewise constant approximation with discontinuities at leaf boundaries.
- The acceptable error threshold is the complexity parameter.

### Pruning

- Any decision based on too few instances causes variance and thus generalization error.
- Stopping tree construction early on before it is full is called **prepruning** the tree.
- In **postpruning**, subtrees that cause overfitting are pruned after full tree construction.
- A **pruning set**, unused during training, is used for pruning.
- If the leaf node does not perform worse than the subtree on the pruning set, the subtree is pruned.

### Rule Extraction from Trees

- Features closer to the root are more important globally.
- Another main advantage of decision trees is interpretability.
- Such a rule base allows **knowledge extraction**.
- Pruning a subtree corresponds to pruning terms from a number of rules.

### Learning Rules from Data

- Tree induction goes breadth-first and generates all paths simultaneously.
- **Rule induction** does a depth-first search and generates one path (rule) at a time.
- A rule is said to *cover* an example if the example satisfies all the conditions of the rule.
- **Sequential covering**:
  - Once a rule is grown and pruned, it is added to the rule base.
  - All the training examples covered by the rule are removed from the training set.
  - The process continues until enough rules are added.
- A rule is pruned back by deleting conditions in reverse order to find the rule that maximizes the **rule value metric**.

### Multivariate Trees

- In a **multivariate tree**, at a decision node, all input dimensions can be used.
- The node becomes more flexible by using a nonlinear multivariate node.

### Notes

- The **omnivariate decision tree** is a hybrid tree architecture.
- Decision trees are used more frequently for classification than for regression.
- The decision tree is a nonparametric method.
- An ensemble of decision trees is called a **decision forest**.
- Each decision tree is trained on a random subset of the training set or the input features.
- The decision tree is *discriminant-based* whereas the statistical methods are **likelihood-based**.

## Linear Discrimination

### Introduction

- **Discriminant-based classification** assume a model directly for the discriminant.
- Learning is the optimization of the model parameters to maximize the quality of the separation.
- The **linear discriminant** is used frequently mainly due to its simplicity.

### Generalizing the Linear Model

- Adding **higher-order terms**, also called **product terms**, provides more flexibility.
- **Basis functions** are nonlinear transformation to a new space where the function can be written in a linear form.
- The discriminant is given as $f(x)$ = $w^⊤Φ(x)$ where $Φ(x)$ are basis functions.
