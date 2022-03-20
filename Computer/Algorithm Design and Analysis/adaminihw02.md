## Mini Homework 2

At the $k$-th level of the recursion tree, there are $4^k$ nodes of size $n^{1/2^k}$. The number of level $K$ can be obtained from $n^{1/2^K} = c \implies K = \lg\lg n-\lg\lg c = O(\lg\lg n)$. Therefore, the total cost is upper bounded by $\sum_{k=0}^{\lg\lg n} 4^k\log n^{1/2^k} = \sum_{k=0}^{\lg\lg n} 2^k\log n = 2(\lg n - 1)\log n = O(\log^2 n)$.