## Homework 7

1. 
    a. For any nonzero vectors $v$ on the intersection line of two planes, $v\cdot v ≠ 0$.
    b. The dimensions of two subspaces $≤ \mathbb{R}^5$ are both two. $5≠2+2$.
    c. span{(1,2)} and span{(2,1)} meet only at 0 but are not orthogonal.
2. 
    a. $\langle f_1,f_2 \rangle = \int_{-1}^1(x+1)(2x+3)dx = \frac{2}{3}x^3 + \frac{5}{2}x^2 + 3x |_{-1}^1 = \frac{22}{3}$.
    b. $\lVert f_1\rVert = \sqrt{\langle f_1,f_1 \rangle} = \small\sqrt{\int_{-1}^1 (x+1)(x+1)dx} = \small\sqrt{\frac{1}{3}x^3 + x^2 + x |_{-1}^1} = \sqrt{\frac{8}{3}}$.
3. Let $A,B\in\mathbb{R}^{2\times2}$ and $A$ is diagonal. $\forall A$, $\langle A,B\rangle = \text{tr}(AB^\top) = a_{11}b_{11} + a_{22}b_{22} =0$ iff $(b_{11},b_{22}) = 0$. Hence, $W^\bot = \{B|B$ is a $2\times2$ hollow matrix (all diagonal elements are 0) $\}$.
4. $x = (2,2,4,1)$ and $\lVert x\rVert = 5$. $y = (-2,1,2,0)$ and $\lVert y\rVert = 3$.
    a. $\cos\theta = \frac{x^\top y}{\lVert x\rVert\lVert y\rVert} = \frac{6}{15} = \frac{2}{5}$. $\tan^2\theta = \frac{1}{\cos^2\theta}-1 = \frac{21}{4}$.
    b. $\frac{y y^\top}{y^\top y}x = \frac{1}{9} \small\begin{bmatrix} 4 & -2 & -4 & 0 \\ -2 & 1 & 2 & 0 \\ -4 & 2 & 4 & 0 \\ 0 & 0 & 0 & 0 \end{bmatrix} \small\begin{bmatrix} 2 \\ 2 \\ 4 \\ 1 \end{bmatrix} = \small\begin{bmatrix} -12/9 \\ 6/9 \\ 12/9 \\ 0 \end{bmatrix}$.
    c. $\frac{x x^\top}{x^\top x}y = \frac{1}{25} \small\begin{bmatrix} 4 & 4 & 8 & 2 \\ 4 & 4 & 8 & 2 \\ 8 & 8 & 16 & 4 \\ 2 & 2 & 4 & 1 \end{bmatrix} \small\begin{bmatrix} -2 \\ 1 \\ 2 \\ 0 \end{bmatrix} = \small\begin{bmatrix} 12/25 \\\ 12/25 \\ 24/25 \\ 6/25 \end{bmatrix}$.
5. 
    a. Disprove. Let $S=\{1\}\subset\mathbb{R}$. $S^\bot = \{0\}$. $(S^\bot)^\bot = \mathbb{R} ≠ S$.
    b. Disprove. Let $S_1=\{1\}\subset\mathbb{R}$ and $S_2=\{2\}\subset\mathbb{R}$. $S_1^\bot = \{0\} = S_2^\bot$. But $S_1 ≠ S_2$.
    c. Disprove. Let $V = W = \{0\}\subset\mathbb{R}$ s.t. $V \bot W$. $V^\bot = W^\bot = \mathbb{R}$. But $\forall v,w ≠ 0 \in\mathbb{R}$, $vw ≠ 0$.
    d. Disprove. Let $V = \{1\}, W = \{0\}, Z = \{1\}$ s.t. $V \bot W$ and $W \bot Z$. But $1\cdot1 ≠ 0$.
6. Let $D$ be a square diagonal matrix with $d_{ii} = (w_i)^\frac{1}{2}$ for $i = 1,...,n$.<br>Let $u_w = Du = ((w_1)^\frac{1}{2}u_1,...,(w_n)^\frac{1}{2}u_n)$, and $v_w = Dv = ((w_1)^\frac{1}{2}v_1,...,(w_n)^\frac{1}{2}v_n)$.<br>By Cauchy's Inequality, we know $|u_w^\top v_w| ≤ \lVert u_w\rVert\lVert v_w\rVert$. And, $u_w^\top v_w = w_1u_1v_1 + ... + w_nu_nv_n$.<br>Hence, $|w_1u_1v_1 + ... + w_nu_nv_n| ≤ (w_1u_1^2 + ... + w_nu_n^2)^\frac{1}{2} (w_1v_1^2 + ... + w_nv_n^2)^\frac{1}{2}$
7. 
    a. $(1,-1,1)\cdot(2,1,-1) = 0$ and $(1,0,2)\cdot(2,1,-1) = 0$.
    b. Prove by showing $T \subseteq N(A^\top)$ and $N(A^\top) \subseteq T$.
    - Prove $T \subseteq N(A^\top)$. $\forall t \in T$, $t$ can be expressed as $\alpha(2,1,-1)$, and $A^\top\alpha(2,1,-1) = 0$. Hence, $T \subseteq N(A^\top)$.
    - Prove $N(A^\top) \subseteq T$. We know rank($A^\top$) $= 2$ and dim($N(A^\top)$) $= 3-2 = 1$. $(2,1,-1)$ is the only basis of $N(A^\top)$. Hence, $N(A^\top) \subseteq T$.

    c. $U = \{0\}$.
    d. Let $t = (2,1,-1)$. $x_2 = \frac{t t^\top}{t^\top t}x = \frac{1}{6}(36,18,-18) = (6,3,-3)$. $x_1 = (9,2,2) - (6,3,-3) = (3,-1,5)$.
