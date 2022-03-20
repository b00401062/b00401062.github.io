## Homework 6

1. 
    a. $\begin{bmatrix} \cos^20 & \sin0\cos0 \\ \sin0\cos0 & \sin^20 \end{bmatrix} \begin{bmatrix} \cos90° & -\sin90° \\ \sin90° & \cos90° \end{bmatrix} = \begin{bmatrix} 0 & -1 \\ 0 & 0 \end{bmatrix}$.
    b. $\begin{bmatrix} 0 & 0 \\ 0 & 1 \end{bmatrix} \begin{bmatrix} 1 & 0 \\ 0 & 0 \end{bmatrix} = \begin{bmatrix} 0 & 0 \\ 0 & 0 \end{bmatrix}$
2. $\begin{bmatrix} 2 & 0 & 0 & 0 \\ 3 & 2 & 0 & 0 \\ 0 & 3 & 2 & 0 \\ 0 & 0 & 3 & 2 \\ 0 & 0 & 0 & 3 \end{bmatrix}$.
3. $⟨.,.⟩$ is an inner product since it satisfies the following properties:
    a. $⟨αx+y,z⟩=2(αx_1+y_1)z_1 + (αx_2+y_2)z_2 + 3(αx_3+y_3)z_3 =$$α(2x_1z_1 + x_2z_2 + 3x_3z_3) + (2y_1z_1 + y_2z_2 + 3y_3z_3) = α⟨x,z⟩+⟨y,z⟩$.
    b. $⟨y,x⟩ = 2y_1x_1 + y_2x_2 + 3y_3x_3 = \overline{2x_1y_1 + x_2y_2 + 3x_3y_3} = \overline{⟨x,y⟩}$.
    c. $⟨x,x⟩ = 2x_1^2 + x_2^2 + 3x_3^2 = 0$ iff $x=0$. Hence, if $x≠0$, then $⟨x,x⟩≠0$.
4. 
    a. $(v_1,v_3)$, $(v_2,v_3)$
    b. $A = \begin{bmatrix} 1 & 2 & -2 & 1 \\ 1 & 1 & 1 & 1 \end{bmatrix}$.<br>All vectors orthogonal to $S$ is $N(A) = \text{span}\{(-4,3,1,0), (-1,0,0,1)\}$.
5. $\begin{bmatrix} 1 & 0 & 0 \\ -2 & 1 & 0 \\ -1 & -1 & 1 \end{bmatrix}A = \begin{bmatrix} 1 & 2 & 1 \\ 0 & 0 & 1 \\ 0 & 0 & 0 \end{bmatrix}$
    a. $N(A)=\text{span}\{(-2,1,0)\}\ni x$, e.g., $(-2,1,0)/\sqrt{5}$.
    b. $N(A^\top)=\text{span}\{(-1,-1,1)\}\ni y$, e.g., $(-1,-1,1)/\sqrt{3}$.
    c. $C(A^\top)=\text{span}\{(1,2,1),(3,6,4)\}\ni z$, e.g., $(1,2,1)/\sqrt{6}$.
6. 
    a. $\begin{bmatrix} 1 & 2 & -3 \\ 2 & -3 & 1 \\ -3 & 5 & -2 \end{bmatrix}$.
    b. Impossible. $(2-3,5)\cdot(1,1,1=4≠0)$.
    c. Impossible. $(1,1,1)\in C(A)$ and $(1,0,0)\in N(A^\top)$, but $(1,1,1)\cdot(1,0,0)=1≠0$.
    d. Any solution to $A^2=0$, e.g., $\begin{bmatrix} 0 & 1 \\ 0 & 0 \end{bmatrix}$.
    e. Impossible. $A^\top 1 = 0$ and $A1=1$. However, $1^\top A1=0^\top1=0$ and $1^\top A1=1^\top 1≠0$ are contradictory. Hence, there is no such $A$.
7. $\lVert 3u+4v \rVert^2 = (3u+4v)^\top(3u+4v) = 9u^\top u + 12 u^\top v + 12 v^\top u + 16 v^\top v = 25$.
