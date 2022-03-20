# Biostatistics

## Research Bias

- Sampling bias
  - Berkson bias
- Selection bias
  - Attrition bias
- Recall bias
- Measurement bias
  - Hawthorne effect
- Procedure bias
- Observer-expectancy bias
  - Pygmalion effect
- Confounding bias
- Lead-time bias
- Late-look bias

## Observational Studies

||Cross Section|Case Control|Cohort|
|-|-|-|-|
|Time|Time point|Retrospective|Retrospective<br>Prospective|
|Incidence|-|-|+|
|Prevalence|+|-|-|
|Causality|-|+|+|
|Analysis|Chi-squared|Odds ratio (OR)|Relative risk (RR)|

## Statistical Tests

|Independent Variable|Dependent Variable|Sampling|Parametric|Test|
|-|-|-|-|-|
|-|Dichotomous|Independent|-|Pearson Chi-squared test & Binomial test|
|-|Polytomous|Independent|-|Pearson Chi-squared test & Multinomial test|
|-|Continuous|Independent|+|Z-test & T-test|
|Dichotomous|Dichotomous|Independent|-|Pearson Chi-squared test & Fisher exact test|
|Dichotomous|Dichotomous|Dependent|-|McNemar Chi-squared test|
|Dichotomous|Polytomous|Independent|-|Pearson Chi-squared test|
|Dichotomous|Continuous|Independent|-|Wilcoxon rank-sum test|
|Dichotomous|Continuous|Independent|+|Z-test & T-test|
|Dichotomous|Continuous|Dependent|-|Wilcoxon signed-rank test|
|Dichotomous|Continuous|Dependent|+|Paired Z-test & T-test|
|Polytomous|Dichotomous|Independent|-|Pearson Chi-squared test|
|Polytomous|Polytomous|Independent|-|Pearson Chi-squared test|
|Polytomous|Continuous|Independent|-|Kruskal-Wallis test|
|Polytomous|Continuous|Independent|+|ANOVA F-test|
|Polytomous|Continuous|Dependent|-|Friedman test|
|Polytomous|Continuous|Dependent|+|Repeated measures ANOVA F-test|
|Continuous|Dichotomous|Independent|+|Logistic regression :: binomial|
|Continuous|Polytomous|Independent|+|Logistic regression :: multinomial|
|Continuous|Continuous|Independent|-|Spearman correlation|
|Continuous|Continuous|Independent|+|Pearson correlation|

## Inferences for Means ![](https://latex.codecogs.com/gif.latex?\overline{X})

|Samples|Confidence Interval|Hypothesis Test|
|-|-|-|
|One|![][1]|![][2]|
|Two|![][3]|![][4]|

## Inferences for Proportions ![](https://latex.codecogs.com/gif.latex?\hat{p})

|Samples|Confidence Interval|Hypothesis Test|
|-|-|-|
|One|![][5]|![][6]|
|Two|![][7]|![][8]|

## Sensitivity & Specificity

|Sensitivity|Specificity|
|-|-|
|Ture positive|True negative|
|Rule out when negative|Rule in when positive|
|Screening test|Confirmation test|
|High type 1 error|Low type 1 error|
|Low type 2 error|High type 2 error|

## Likelihood Ratios

- Positive likelihood ratio = sensitivity / (1 - specificity)
- Negative likelihood ratio = (1 - sensitivity) / specificity

## Supervised Learning Steps

- Collection
- Splitting
- Preprocessing
- Modeling
- Validation
- Evaluation
- Prediction

[1]: https://latex.codecogs.com/gif.latex?\overline{X}\pm{t}_\text{df}\frac{S}{\sqrt{n}},\text{df}=n-1
[2]: https://latex.codecogs.com/gif.latex?t_\text{df}=(\overline{X}-\mu)/\frac{S}{\sqrt{n}},\text{df}=n-1
[3]: https://latex.codecogs.com/gif.latex?(\overline{X}_1-\overline{X}2)\pm{t}_\text{df}\sqrt{\frac{S_1^2}{n_1}&plus;\frac{S_2^2}{n_2}},\text{df}=\min\{n_1-1,n_2-1\}
[4]: https://latex.codecogs.com/gif.latex?t_\text{df}=(\overline{X}_1-\overline{X}_2)/\sqrt{\frac{S_1^2}{n_1}&plus;\frac{S_2^2}{n_2}},\text{df}=\min\{n_1-1,n_2-1\}
[5]: https://latex.codecogs.com/gif.latex?\hat{p}\pm{z}\sqrt{\frac{\hat{p}(1-\hat{p})}{n}}
[6]: https://latex.codecogs.com/gif.latex?z=(\hat{p}-p)/\sqrt{\frac{p(1-p)}{n}}
[7]: https://latex.codecogs.com/gif.latex?(\hat{p}_1-\hat{p}_2)\pm{z}\sqrt{\frac{\hat{p}_1(1-\hat{p}_1)}{n_1}&plus;\frac{\hat{p}_2(1-\hat{p}_2)}{n_2}}
[8]: https://latex.codecogs.com/gif.latex?z=(\hat{p}_1-\hat{p}_2)/\sqrt{\frac{p(1-p)}{n_1}&plus;\frac{p(1-p)}{n_2}},p=\frac{n_1\hat{p}_1&plus;n_2\hat{p}_2}{n_1&plus;n_2}
