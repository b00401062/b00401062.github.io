## Mini Homework 1

$g(n) = \Theta(F(n))$ and $h(n) = O(F(n))$
$\implies$ $\exists\ k_1>0, k_2>0, n_1>0$ s.t. $k_1F(n) \le g(n) \le k_2F(n)$ $\forall\ n>n_1$ and $\exists\ k>0, n_2>0$ s.t. $h(n) \le kF(n)$ $\forall\ n>n_2$
$\implies$ $\exists\ k_1'=k_1, k_2'=k_2+k, n_0=\max\{n_1,n_2\}$ s.t. $k_1'F(n) \le g(n)+h(n) \le k_2'F(n)$ $\forall\ n>n_0$
