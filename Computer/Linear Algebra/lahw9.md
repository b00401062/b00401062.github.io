## Homework 9

1. $1,x,x^2$ are three basis. Let $\{q_1,q_2,q_3\}$ be an orthonormal set.
    $q_1' = 1$ &rArr; $q_1 = \frac{1}{\sqrt{\int_{-1}^1 1 dx}} = \frac{\sqrt{2}}{2}$
    $q_2' = x - (\int_{-1}^1 \frac{\sqrt{2}}{2}x dx)\frac{\sqrt{2}}{2} = x$ &rArr; $q_2 = \frac{x}{\sqrt{\int_{-1}^1 x^2 dx}} = \frac{\sqrt{6}}{2}x$
    $q_3' = x^2 - (\int_{-1}^1 \frac{\sqrt{2}}{2}x^2 dx)\frac{\sqrt{2}}{2} - (\int_{-1}^1 \frac{\sqrt{6}}{2}x^3 dx)\frac{\sqrt{6}}{2}x = x^2 - \frac{1}{3}$ &rArr; $q_3 = \frac{x^2 - \frac{1}{3}}{\sqrt{\int_{-1}^1 (x^2 - \frac{1}{3})^2 dx}} = \frac{3\sqrt{10}}{4}x^2 - \frac{\sqrt{10}}{4}$
2. Let $\{q_1,q_2,q_3\}$ be an orthonormal set than spans the column space of $A$.
    $q_1' = (1,0,1)$ &rArr; $q_1 = \frac{1}{\sqrt{2}}(1,0,1)$
    $q_2' = (2,1,4) - (\frac{1}{\sqrt{2}}(1,0,1)⋅(2,1,4))\frac{1}{\sqrt{2}}(1,0,1) = (-1,1,1)$ &rArr; $q_2 = \frac{1}{\sqrt{3}}(-1,1,1)$
    $q_3' = (3,1,6) - (\frac{1}{\sqrt{2}}(1,0,1)⋅(3,1,6))\frac{1}{\sqrt{2}}(1,0,1) - (\frac{1}{\sqrt{3}}(-1,1,1)⋅(3,1,6))\frac{1}{\sqrt{3}}(-1,1,1)$ $=(-\frac{1}{6},-\frac{1}{3},\frac{1}{6})$ &rArr; $q_3 = \sqrt{6}(-\frac{1}{6},-\frac{1}{3},\frac{1}{6}) = \frac{1}{\sqrt{6}}(-1,-2,1)$
    Hence, $A = QR = \begin{bmatrix} \frac{1}{\sqrt{2}} & -\frac{1}{\sqrt{3}} & -\frac{1}{\sqrt{6}} \\ 0 & \frac{1}{\sqrt{3}} & -\frac{2}{\sqrt{6}} \\ \frac{1}{\sqrt{2}} & \frac{1}{\sqrt{3}} & \frac{1}{\sqrt{6}} \end{bmatrix} \begin{bmatrix} \sqrt{2} & \frac{6}{\sqrt{2}} & \frac{9}{\sqrt{2}} \\ 0 & \sqrt{3} & \frac{4}{\sqrt{3}} \\ 0 & 0 & \frac{1}{\sqrt{6}} \end{bmatrix}$.
3. $\begin{vmatrix} x_1 & x_2 & x_3 & x_4 \\ 1 & 0 & 1 & 0 \\ 1 & 1 & 1 & 0 \\ 1 & -1 & 0 & 1 \end{vmatrix} = -x_1 + x_3 + x_4$. $(1,1,1,1)-\frac{(-1,0,1,1)⋅(1,1,1,1)}{(-1,0,1,1)⋅(-1,0,1,1)}(-1,0,1,1) = (\frac{4}{3},1,\frac{2}{3},\frac{2}{3})$.
4. Let $\{q_1,q_2\}$ be an orthonormal set than spans the column space of $A$.
    $q_1' = (2,1,2)$ &rArr; $q_1 = \frac{1}{3}(2,1,2)$
    $q_2' = (1,1,1) - (\frac{1}{3}(2,1,2)⋅(1,1,1))\frac{1}{3}(2,1,2) = \frac{1}{9}(-1,4,-1)$ &rArr; $q_2 = \frac{1}{3\sqrt{2}}(-1,4,-1)$
    Hence, $A = QR = \begin{bmatrix} \frac{2}{3} & \frac{-1}{3\sqrt{2}} \\ \frac{1}{3} & \frac{4}{3\sqrt{2}} \\ \frac{2}{3} & \frac{-1}{3\sqrt{2}} \end{bmatrix} \begin{bmatrix} 3 & \frac{5}{3} \\ 0 & \frac{\sqrt{2}}{3} \end{bmatrix}$.
    $Ax = b$ &rArr; $\tilde{x} = R^{-1}Q^\top b = \frac{1}{\sqrt{2}} \begin{bmatrix} \frac{\sqrt{2}}{3} & -\frac{5}{3} \\ 0 & 3 \end{bmatrix} \begin{bmatrix} \frac{2}{3} & \frac{1}{3} & \frac{2}{3} \\ \frac{-1}{3\sqrt{2}} & \frac{4}{3\sqrt{2}} & \frac{-1}{3\sqrt{2}} \end{bmatrix} \begin{bmatrix} 12 \\ 6 \\ 18 \end{bmatrix} = \begin{bmatrix} 9 \\ -3 \end{bmatrix}$

5. The parallelepiped is the region defined by $0 ≤ 2x-2y+z ≤ 4$, $0 ≤ 2y-z ≤ 2$, $0 ≤ z ≤ 2$.
    Let $u = 2x-2y+z$, $v = 2y-z$, $w = z$, where $0 ≤ u ≤ 4$, $0 ≤ v ≤ 2$, $0 ≤ w ≤ 2$.
    Then, $x = \frac{1}{2}(u+v)$, $y = \frac{1}{2}(v+w)$, $z = w$.
    $\int (x-y) dV$ = $\iiint (x-y) dxdydz$ = $\int_0^2\int_0^2\int_0^4 (\frac{1}{2}(u+v)-\frac{1}{2}(v+w)) \begin{vmatrix} \frac{1}{2} & \frac{1}{2} & 0 \\ 0 & \frac{1}{2} & \frac{1}{2} \\ 0 & 0 & 1 \end{vmatrix} dudvdw$ = $\frac{1}{8} \int_0^2\int_0^2\int_0^4 (u-w) dudvdw$ = $\frac{1}{2} \int_0^2\int_0^2 (2-w) dvdw$ = $\int_0^2 (2-w) dw$ = 2.
