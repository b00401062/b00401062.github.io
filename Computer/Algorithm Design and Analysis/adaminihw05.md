## Mini Homework 5

1. The recursion formula: $M_{i,w} = \begin{cases} 0 \text{ if } i=0 \text{ or } w=0 \\ M_{i-1,w} \text{ if } nw_i>w \text{ for } 1\le n\le n_i \\ \max_{0\le n\le n_i} nv_i+M_{i-1,w-nw_i} \text{ otherwise} \end{cases}$

|i\w|0|1|2|3|4|5|6|7|8|
|:-:|:-:|:-:|:-:|:-:|:-:|:-:|:-:|:-:|:-:|
| 1 |0|0|0|6|6|6|12|12|12|
| 2 |0|0|0|6|6|6|12|12|12|
| 3 |0|1|2|6|7|8|12|13|14|
| 4 |0|1|4|6|8|10|12|14|16|

2. Backtracking from $M_{i,w}$ until $w=0$:
    - If $M_{i,w} = M_{i-1,w}$, then goes to $M_{i-1,w}$.
    - Else for $n = 1,2,...,n_i$:
        - If $M_{i,w} = nv_i+M_{i-1,w-nw_i}$, then take $n$ items, goes to $M_{i-1,w-nw_i}$ and break.
    
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;The graphical representation of backtracking is as follows (each number denotes the step):

|i\w|0|1|2|3|4|5|6|7|8|Remark|
|:-:|:-:|:-:|:-:|:-:|:-:|:-:|:-:|:-:|:-:|-|
| 1 |4||||||3|||Take 2 items
| 2 |||||||2|||
| 3 |||||||1|||
| 4 |||||||||0|Take 1 item
