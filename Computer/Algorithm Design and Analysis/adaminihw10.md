## Mini Homework 10

1. __push()__: 1 + cap = Θ(cap).
    __pop()__: 1 + cap / 4 = Θ(cap).
2. Define $\Phi(D_i)$ after the $i$-th operation to be $\begin{cases}
        \text{(2 × size − cap) when size ≥ cap / 2} \\
        \text{(cap / 2 − size) when size ≤ cap / 2}
    \end{cases}$
    - Validity of $\Phi(D_i)$:
        - $\Phi(D_0)$ = 0.
        - $\Phi(D_i)$ ≥ 0:
            - When size ≥ cap / 2, (2 × size − cap) ≥ 0.
            - When size ≤ cap / 2, (cap / 2 − size) ≥ 0.
    -  The amortized cost of __push()__:
        - When pushing an element causes a resize:
            [1 + cap] + [2 × (size + 1) − 2 × cap] − [2 × size − cap] = 3.
        - When pushing an element does __not__ cause a resize:
            1 + [2 × (size + 1) − cap] − [2 × size − cap] = 3.
            1 + [cap / 2 − (size + 1)] − [cap / 2 − size] = 0.
        - All operations have O(1) amortized cost.
    -  The amortized cost of __pop()__:
        - When popping an element causes a resize:
            [1 + cap / 4] + [cap / 4 − (size − 1)] − [cap / 2 − size] = 2.
        - When popping an element does __not__ cause a resize:
            1 + [2 × (size − 1) − cap] − [2 × size − cap] = −1.
            1 + [cap / 2 − (size − 1)] − [cap / 2 − size] = 2.
        - All operations have O(1) amortized cost.
