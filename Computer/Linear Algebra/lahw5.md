## Homework 5

1. Prove. Let $A = \begin{bmatrix} 3 & 2 & 1 \\ 0 & -1 & 0 \\ 0 & 0 & 1 \end{bmatrix}$. If $w_1, w_2, w_3$ are linearly dependent, then $\exists x≠0$ s.t. $[w_1 w_2 w_3]x=0$. $[w_1 w_2 w_3]x=[v_1 v_2 v_3]Ax=0$. $Ax≠0$ because $A$ is fully-ranked and $x≠0$. However, there is a contradiction to that $v_1, v_2, v_3$ are linearly independent because $\exists x'=Ax≠0$ s.t. $[v_1 v_2 v_3]x'≠0$. Therefore, $w_1, w_2, w_3$ are linearly independent.
2. Prove. $\begin{bmatrix} 1 & 1 & 5 \\ 1 & -1 & 8 \\ 1 & -3 & 11 \end{bmatrix}$ &rarr; $\begin{bmatrix} 1 & 1 & 5 \\ 0 & -2 & 3 \\ 0 & 0 & 0 \end{bmatrix}$. Therefore, rank($S_2$) $=2$, and span($S_2$) is a plane $\in\mathbb{R}^3$. The plane $\in\mathbb{R}^3$ is $(1,1,1)\times(1,-1,-3)\cdot(x,y,z)=x-2y+z=0$. Both $(1,2,3)$ and $(2,3,4)$ are in the plane, therefore, span($S_1$) is a subspace of span($S_2$).
3.
    a. $U$ is an upper triangular matrix of $LU$ decomposition of $A$.
    For $A$, $(1,1,3)×(1,3,1)=(-8,2,2) \parallel (4,-1,-1)$, and $(1,1,0)×(1,3,1)=(1,-1,2)$.
    &rArr; $C(A)=\{(x,y,z)\in\mathbb{R}^3|4x-y-z=0\}$; $C(A^\text{T})=\{(x,y,z)\in\mathbb{R}^3|x-y+2z=0\}$; $N(A)=\{(1,-1,2)t|t\in\mathbb{R}\}$; $N(A^\text{T})=\{(4,-1,1)t|t\in\mathbb{R}\}$.
    For $U$, $(1,0,0)×(1,2,0)=(0,0,2) \parallel (0,0,1)$, and $(1,1,0)×(0,2,1)=(1,-1,2)$.
    &rArr; $C(U)=\{(x,y,0)\in\mathbb{R}^3\}$; $C(U^\text{T})=\{(x,y,z)\in\mathbb{R}^3|x-y+2z=0\}$; $N(U)=\{(1,-1,2)t|t\in\mathbb{R}\}$; $N(U^\text{T})=\{(0,0,z)|z\in\mathbb{R}\}$.
    b. $C(A^\text{T})=C(U^\text{T})$, and $N(A)=N(U)$.
4.
    a. $\{(1,1,1,1)\}$
    b. $\{(-1,1,0,0), (-1,0,1,0), (-1,0,0,1)\}$
    c. $\{(-1,1,1,0), (-1,1,0,1)\}$, which span the nullspace of $\begin{bmatrix} 1 & 1 & 0 & 0 \\ 1 & 0 & 1 & 1 \end{bmatrix}$.
    d. $\{(1,0), (0,1)\}$, and $\{(-1,0,1,0,0), (0,-1,0,1,0), (-1,0,0,0,1)\}$
5. Basis for $p(x)$: $\{1,x,x^2,x^3\}$. Basis for the subspace with $p(1)=0$: $\{x-1,x^2-1,x^3-1\}$.
6.
    a. $C(A):5$; $C(A^\text{T}):5$; $N(A):4$; $N(A^\text{T}):2$.
    b. $C(A)$ is $\mathbb{R}^3$. $N(A^\text{T})=0\in\mathbb{R}^3$.
7. Row space and nullspace do not change. $(2,1,3,4)$.
8. (b) and \(c\) satisfy $T(𝑣 + 𝑤) = T(𝑣) + T(𝑤)$.<br>(b) and \(c\) satisfy $T(c𝑣) = cT(𝑣)$.
    b. $T(cv+w)=(cv_1+w_1)+(cv_2+w_2)+(cv_3+w_3)=c(v_1+v_2+v_3)+(w_1+w_2+w_3)=cT(v)+T(w)$.
    c. $T(cv+w)=(cv_1+w_1,2cv_2+2w_2,3cv_3+3w_3)=c(v_1,2v_2,3v_3)+(w_1,2w_2,3w_3)=cT(v)+T(w)$.
    d. $T(cv)=\max{cv}≠c\max v=cT(v)$.
9. $T(\begin{bmatrix} 1 \\ 0 \end{bmatrix}) = \begin{bmatrix} 1 & 1 \\ 3 & 1 \\ 2 & -2 \end{bmatrix} \begin{bmatrix} 1 & 2 \\ 1 & 3 \end{bmatrix}^{-1} \begin{bmatrix} 1 \\ 0 \end{bmatrix} =\begin{bmatrix} 2 \\ 8 \\ 8 \end{bmatrix}$. $T(\begin{bmatrix} 0 \\ 1 \end{bmatrix}) = \begin{bmatrix} 1 & 1 \\ 3 & 1 \\ 2 & -2 \end{bmatrix} \begin{bmatrix} 1 & 2 \\ 1 & 3 \end{bmatrix}^{-1} \begin{bmatrix} 0 \\ 1 \end{bmatrix} =\begin{bmatrix} -1 \\ -5 \\ -6 \end{bmatrix}$.
