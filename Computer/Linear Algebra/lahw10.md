## Homework 10

1. 
    a. F. Suppose $A = I_{2×2}$. Adding 0 times row 1 to row 2 gives $B = A$. det$B$ = 1 ≠ 0 · det$A$ = 0.
    b. T.
    c. T.
    d. T.
2. det$A$ = $-11$.
    a. det$\frac{1}{2}A$ = $(\frac{1}{2})^4$det$A$ = $-\frac{11}{16}$.
    b. det$-A$ = $(-1)^4$det$A$ = $-11$.
    c. det$A^2$ = (det$A$)$^2$ = $121$.
    d. det$A^{-1}$ = $-\frac{1}{11}$.
3. Let $A$ = $\begin{bmatrix} 1 & a & a^2 \\ 1 & b & b^2 \\ 1 & c & c^2 \end{bmatrix}$ = $\begin{bmatrix} 1 & 0 & 0 \\ 1 & 1 & 0 \\ 1 & \frac{c-a}{b-a} & 1 \end{bmatrix}$ $\begin{bmatrix} 1 & a & a^2 \\ 0 & b-a & b^2-a^2 \\ 0 & 0 & c^2-a^2-\frac{(b^2-a^2)(c-a)}{b-a} \end{bmatrix}$.
    det$A$ = $(b-a)(c^2-a^2-\frac{(b^2-a^2)(c-a)}{b-a})$ = $bc^2-ac^2-ba^2-b^2c+a^2c+ab^2$ = $(b−a)(c−a)(c−b)$.
4. 
    a. $A$ = $\begin{bmatrix} 1 & 0 & 0 & 0 \\ 1 & 1 & 0 & 0 \\ 1 & 1 & 1 & 0 \\ 1 & 1 & 1 & 1 \end{bmatrix}$ $\begin{bmatrix} n_1 & n_1 & n_1 & n_1 \\ 0 & n_2-n_1 & n_2-n_1 & n_2-n_1 \\ 0 & 0 & n_3-n_2 & n_3-n_2 \\ 0 & 0 & 0 & n_4-n_3 \end{bmatrix}$
    b. det$A$ = $n_1(n_2-n_1)(n_3-n_2)(n_4-n_3)$.
5. $S_n$ = 3 · $S_{n-1}$ − $S_{n-2}$. $S_1$ = 3. $S_2$ = 8. Hence, $S_n$ = $\frac{5+3\sqrt{5}}{10}(\frac{3+\sqrt{5}}{2})^n + \frac{5-3\sqrt{5}}{10}(\frac{3-\sqrt{5}}{2})^n$.
6. 
    a. When $t = 0$, $A = \begin{bmatrix} 2 & 0 & 5 \\ 0 & 1 & 0 \\ 0 & 5 & 5 \end{bmatrix}$.
    $A^{-1}$ = $\frac{1}{\text{det}A}\begin{bmatrix} \begin{vmatrix} 1 & 0 \\ 5 & 5 \end{vmatrix} & -\begin{vmatrix} 0 & 5 \\ 5 & 5 \end{vmatrix} & \begin{vmatrix} 0 & 5 \\ 1 & 0 \end{vmatrix} \\ -\begin{vmatrix} 0 & 0 \\ 0 & 5 \end{vmatrix} & \begin{vmatrix} 2 & 5 \\ 0 & 5 \end{vmatrix} & -\begin{vmatrix} 2 & 5 \\ 0 & 0 \end{vmatrix} \\ \begin{vmatrix} 0 & 1 \\ 0 & 5 \end{vmatrix} & -\begin{vmatrix} 2 & 0 \\ 0 & 5 \end{vmatrix} & \begin{vmatrix} 2 & 0 \\ 0 & 1 \end{vmatrix} \end{bmatrix}$ = $\frac{1}{10}\begin{bmatrix} 5 & 25 & -5 \\ 0 & 10 & 0 \\ 0 & -10 & 2 \end{bmatrix}$.
    b. det$A$ = $2t^2+4t+10$ ≥ 8 > 0. Hence, $A^{-1}$ always exists.
7. det$\begin{vmatrix} a & 1 & 1 \\ 1 & a & 1 \\ 1 & 1 & a \end{vmatrix}$ = $a^3-3a+2$. There is a solution when $a≠1,-2$.
    $x$ = $\frac{1}{a^3-3a+2}\begin{vmatrix} 1 & 1 & 1 \\ 0 & a & 1 \\ 0 & 1 & a \end{vmatrix}$ = $\frac{a^2-1}{a^3-3a+2}$.
    $y$ = $\frac{1}{a^3-3a+2}\begin{vmatrix} a & 1 & 1 \\ 1 & 0 & 1 \\ 1 & 0 & a \end{vmatrix}$ = $\frac{1-a}{a^3-3a+2}$.
    $z$ = $\frac{1}{a^3-3a+2}\begin{vmatrix} a & 1 & 1 \\ 1 & a & 0 \\ 1 & 1 & 0 \end{vmatrix}$ = $\frac{1-a}{a^3-3a+2}$.
