## Mini Homework 6

1. Define $l$ be a list storing the elements that sum to $k$. Pseudocode is given as follows:
    1. __for__ $i := n-1$; $i ≥ 0$; $i := i-1$:
        1. __if__ $s_i ≤ k$:
            1. Add $s_i$ to $l$
            2. $k := k-s_i$
    2. __if__ $k=0$:
        1. Output $l$
    3. __else__:
        1. Output $-1$ (impossible)
2. A greedy algorithm is designed to examine $s$ from last to first, add $s_i$ into $l$ whenever $s_i ≤ k$, and update $k$ accordingly. Suppose this greedy choice is not included in an optimal solution. At some point, $i$ is the largest index s.t. $s_i<k$, but $s_j$ is selected for some $j<i$. However, this is a contradiction to that there is an optimal solution because $\sum_{k=0}^j s_k < s_i < k$, i.e., it is not possible to achieve the optimal solution even if every element from $s_j$ down to $s_0$ is selected. Therefore, this greedy choice must be included in the optimal solution. And if there is no solution, then $k≠0$ no matter how the algorithm is designed.
