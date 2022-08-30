# Montgomery's Design and Analysis of Experiments

- **Publisher**: Wiley
- **Author**: Douglas C. Montgomery
- **Presenter**: Wen-Bin Luo
- **Link**: https://www.wiley.com/en-us/Design+and+Analysis+of+Experiments

## Introduction

### Strategy of Experimentation

- **Best-guess approach**:
  - Switching the levels of one or two (or perhaps several) factors for the next test, based on the outcome of the current test.
  - No guarantee of success or that the best solution has been found.
- **One-factor-at-a-time (OFAT) approach**:
  - Selecting a starting point (**baseline**) for each factor, and then successively varying each factor over its range with the other factors held constant at the baseline level.
  - Fails to consider any possible **interaction** between the factors.
- **Factorial experiment**:
  - Factors are varied together, instead of one at a time.
  - All possible combinations of the two factors across their levels are used in the design.
**Fractional factorial experiment**: A variation of the basic factorial design in which only a subset of the runs is used.

### Some Typical Applications of Experimental Design

- Experimental design methods have found broad application in many disciplines.

### Basic Principles

- The three basic principles of experimental design are *randomization*, *replication*, and *blocking*.
- **Randomization**:
  - Both the allocation of the experimental material and the order in which the individual runs of the experiment are to be performed are randomly determined.
  - Averaging out the effects of extraneous factors that may be present.
- **Replication**:
  - An independent repeat run of each factor combination.
  - Allows the experimenter to obtain an estimate of the experimental error.
  - Permits the experimenter to obtain a more precise estimate of a parameter.
  - Replication ≠ Repeated measurements.
  - Reflects sources of variability both between runs and (potentially) within runs.
- **Blocking**:
  - A **block** is a set of relatively homogeneous experimental conditions.
  - Improves the precision with which comparisons among the factors of interest are made.
  - Reduces or eliminates the variability trasmitted from *nuisance factors*.
- **Nuisance factors**:
  - Factors that may influence the experimental response but in which we are not directly interested.
  - Classified as *controllable*, *uncontrollable*, or *noise* factors. The blocking principle is often useful in dealing with *controllable* nuisance factors.
  - If a nuisance factor is *uncontrollable* but can be measured, analysis of covariance can often be used to compensate for its effect.
  - **Noise factor**: A factor that varies naturally and uncontrollably in the process can be controlled for purposes of an experiment.

### Guidelines for Designing Experiments

- Recognition of and statement of the problem
- Selection of the response variable
- Choice of factors, levels, and ranges:
  - Once the experimenter has selected the design factors, the followings have to be determined:
    - The ranges over which these factors will be varied.
    - The specific levels at which runs will be made.
  - **Process knowledge**: A combination of practical experience and theoretical understanding.
  - When the objective of the experiment is *factor screening* or *process characterization*, the common practice is to keep the number of factor levels *low*.
  - In *factor screening*, the range over which the factors are varied should be broad.
  - The **cause-and-effect diagram (fishbone diagram)** is useful for organizing some of the information generated in pre-experimental planning.
- Choice of experimental design:
  - Consideration of sample size (number of replicates).
  - Selection of a suitable run order for the experimental trials.
  - Determination of whether or not blocking or other randomization restrictions are involved.
  - Selecting a tentative empirical model to describe the results.
- Performing the experiment:
  - Prior to conducting the experiment a few trial runs (**pilot runs**) are often helpful.
- Statistical analysis of the data:
  - Results and conclusions are objective rather than judgmental in nature.
  - Cannot prove that a factor (or factors) has a particular effect but provide guidelines as to the reliability and validity of results.
- Conclusions and recommendations:
  - Experimentation is *iterative* - formulate new hypotheses on the basis of the results.

### A Brief History of Statistical Design

- Applications of statistical design in industrial settings certainly began in the 1930s.
- **Immediacy**: The response variable can usually be observed (nearly) immediately.
- **Sequentiality**: The experimenter can quickly learn crucial information from a small group of runs that can be used to plan the next experiment.
- Taguchi advocated using designed experiments for what he termed **robust parameter design**:
  - Making processes insensitive to environmental factors or other factors that are difficult to control.
  - Making products insensitive to variation transmitted from components
  - Finding levels of the process variables that force the mean to a desired value while simultaneously reducing variability around this value.

### Summary: Using Statistical Techniques in Experimentation

- Use your non-statistical knowledge of the problem.
- Keep the design and analysis as simple as possible.
- Recognize the difference between practical and statistical significance.
- Experiments are usually iterative.
