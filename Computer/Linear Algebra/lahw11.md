## Homework 11

1. $T = \begin{bmatrix} 1 & 0 & 0 & 0 \\ 0 & 0 & 0 & 0 \\ 0 & 0 & 1 & 0 \\ 0 & 0 & 0 & 0 \end{bmatrix}$
    a. Eigenvalues $λ = -1,-1,0,0$. Eigenvectors $v = (0,0,1,0),(1,0,0,0),(0,0,0,1),(0,1,0,0)$.
    b. $\begin{bmatrix} 0 & 1 & 0 & 0 \\ 0 & 0 & 0 & 1 \\ 1 & 0 & 0 & 0 \\ 0 & 0 & 1 & 0 \end{bmatrix}$ T $\begin{bmatrix} 0 & 1 & 0 & 0 \\ 0 & 0 & 0 & 1 \\ 1 & 0 & 0 & 0 \\ 0 & 0 & 1 & 0 \end{bmatrix}$ = $\begin{bmatrix} 1 & 0 & 0 & 0 \\ 0 & 1 & 0 & 0 \\ 0 & 0 & 0 & 0 \\ 0 & 0 & 0 & 0 \end{bmatrix}$
2. $λ_1+λ_2=7$ and $λ_1λ_2=12$. Eigenvalues $λ=4,3$.
3. 
    a. det($A-I-λI$) = $λ^4-6λ^2-8λ-3$ = $(λ-3)(λ+1)^3$ := 0. $λ=3,-1,-1,-1$.
    b. det($A-I$) = $-3$.
4. 
    a. Nullspace: $\{u\}$. Column space: $\{v,w\}$.
    b. $Av=3v$ and $Aw=5w$. Hence, $A(\frac{1}{3}v+\frac{1}{5}w) = v+w$.
        $x_p = \frac{1}{3}v+\frac{1}{5}w$. $x=\alpha u+\frac{1}{3}v+\frac{1}{5}w$ where $α\in\mathbb{R}$.
    c. $u,v,w$ are independent. Hence, $u$ is not in span$\{v,w\}$, and thus, not in the column space of $A$. Hence, $Ax=u$ has no solution.
5. $A = \begin{bmatrix} 6 & -5 & 5 \\ -5 & 6 & -5 \\ 5 & -5 & 6 \end{bmatrix}$.  $u^\top A^{-1}u = \frac{3}{16}$.
6. det($Q-λI$) = $(\cos\theta-λ)^2+\sin^2\theta$ = $λ^2-2λ\cos\theta+1$ := 0. $λ=\cos\theta ± i\sin\theta$.
    When $λ = \cos\theta + i\sin\theta$, $v = (i,1)$.
    When $λ = \cos\theta - i\sin\theta$, $v = (-i,1)$.
