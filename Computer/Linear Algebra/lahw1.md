## Homework 1

1.
	a. $\begin{bmatrix}1\\3\\2\end{bmatrix} = -\begin{bmatrix}1\\1\\0\end{bmatrix} + 2\begin{bmatrix}1\\2\\1\end{bmatrix}$
	b. $(u,v,w)$ is parallel to $(1,1,1)\times(0,1,2)=(1,-2,1)$. Therefore, $(u,v,w)\in\{(1,-2,1)t\ |\ t\in\mathbb{R}\}$.
2. $\begin{bmatrix} 2 & 3 & 1 & | & 8 \\ 4 & 7 & 5 & | & 20 \\ 0 & -2 & 2 & | & 0 \end{bmatrix}$ $\to$ $\begin{bmatrix} 2 & 3 & 1 & | & 8 \\ 0 & 1 & 3 & | & 4 \\ 0 & -2 & 2 & | & 0 \end{bmatrix}$ $\to$ $\begin{bmatrix} 2 & 3 & 1 & | & 8 \\ 0 & 1 & 3 & | & 4 \\ 0 & 0 & 8 & | & 8 \end{bmatrix}$.<br>Therefore, $z = 1$, $y = 4-3z = 1$, $x = (8-z-3y)/2 = 2$. Therefore, $(x,y,z) = (2,1,1)$.
3. $\begin{vmatrix} a & 2 & 3 \\ a & a & 4 \\ a & a & a \end{vmatrix} = a(a-4)(a-2) := 0$. Therefore, $a = 0,2,4$.
4. $\begin{bmatrix} k & 1 & 1 & | & 1 \\ 1 & k & 1 & | & 1 \\ 1 & 1 & k & | & 1 \end{bmatrix}$ $\to$ $\begin{bmatrix} 1 & 1 & k & | & 1 \\ 1 & k & 1 & | & 1 \\ k & 1 & 1 & | & 1 \end{bmatrix}$ $\to$ $\begin{bmatrix} 1 & 1 & k & | & 1 \\ 0 & k-1 & 1-k & | & 0 \\ 0 & 1-k & 1-k^2 & | & 1-k \end{bmatrix}$ $\to$ $\begin{bmatrix} 1 & 1 & k & | & 1 \\ 0 & k-1 & 1-k & | & 0 \\ 0 & 0 & 2-k-k^2 & | & 1-k \end{bmatrix}$
	a. No solution if $k-1 \ne 0$ and $2-k-k^2=0$, i.e. $k=-2$
	b. One solution if $k-1 \ne 0$ and $2-k-k^2 \ne 0$, i.e. $k\in\mathbb{R}-\{1,-2\}$
	c. Infinitely many solutions if $k-1=0$ and $2-k-k^2=0$, i.e. $k=1$
5. Four equations $x_1+x_4=600+400$, $800+x_1=800+x_2$, $x_2+1200=x_3+1000$, $x_3+x_4=1000+600$ can be simplified to $x_1+x_4=1000$, $x_1-x_2=0$, $x_2-x_3=-200$, $x_3+x_4=1600$, which can be expressed in matrix form: $\begin{bmatrix} 1 & 0 & 0 & 1 \\ 1 & -1 & 0 & 0 \\ 0 & 1 & -1 & 0 \\ 0 & 0 & 1 & 1 \end{bmatrix} \begin{bmatrix} x_1 \\ x_2 \\ x_3 \\ x_4 \end{bmatrix} = \begin{bmatrix} 1000 \\ 0 \\ -200 \\ 1600 \end{bmatrix}$.<br>By Gaussian elimination, $\begin{bmatrix} 1 & 0 & 0 & 1 & | & 1000 \\ 1 & -1 & 0 & 0 & | & 0 \\ 0 & 1 & -1 & 0 & | & -200 \\ 0 & 0 & 1 & 1 & | & 1600 \end{bmatrix}$ $\to$ $\begin{bmatrix} 1 & 0 & 0 & 1 & | & 1000 \\ 0 & -1 & 0 & -1 & | & -1000 \\ 0 & 1 & -1 & 0 & | & -200 \\ 0 & 0 & 1 & 1 & | & 1600 \end{bmatrix}$ $\to$ $\begin{bmatrix} 1 & 0 & 0 & 1 & | & 1000 \\ 0 & -1 & 0 & -1 & | & -1000 \\ 0 & 0 & -1 & -1 & | & -1200 \\ 0 & 0 & 1 & 1 & | & 1600 \end{bmatrix}$ $\to$ $\begin{bmatrix} 1 & 0 & 0 & 1 & | & 1000 \\ 0 & -1 & 0 & -1 & | & -1000 \\ 0 & 0 & -1 & -1 & | & -1200 \\ 0 & 0 & 0 & 0 & | & 400 \end{bmatrix}$. Therefore, there is no solution.
6. a. $I_3$ b. $I_3$ c. $I_3$ d. $I_3$
7. $(A+B)^2 = A(A+B)+B(A+B) = (A+B)(B+A) = A^2+AB+BA+B^2$, i.e. (b), \(c\), (d) are guaranteed.
8. $E_{21} = \begin{bmatrix} 1 & 0 & 0 \\ -4 & 1 & 0\\ 0 & 0 & 1 \end{bmatrix}$, $E_{31} = \begin{bmatrix} 1 & 0 & 0 \\ 0 & 1 & 0 \\ 2 & 0 & 1 \end{bmatrix}$, $E_{32} = \begin{bmatrix} 1 & 0 & 0 \\ 0 & 1 & 0 \\ 0 & -2 & 1 \end{bmatrix}$
9. $A\begin{bmatrix} 1 & 1 \\ 1 & 1 \end{bmatrix} = \begin{bmatrix} a+b & a+b \\ c+d & c+d \end{bmatrix} := \begin{bmatrix} 1 & 1 \\ 1 & 1 \end{bmatrix}A = \begin{bmatrix} a+c & b+d \\ a+c & b+d \end{bmatrix}$. Therefore, $A\in\{\begin{bmatrix} a & b \\ c & d \end{bmatrix}\big\vert\ b=c, a=d\}$
