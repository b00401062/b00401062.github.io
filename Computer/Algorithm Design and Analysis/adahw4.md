## Homework 4

### Problem 5
1. {3,2,1,6,4,5} &rarr; {3,2,1,6,5,4} &rarr; {3,2,4,1,5,6} &rarr; {3,2,4,1,6,5}
2. __Pseudocode__($s$):
    1. $n$ := $|s|$.
    2. $l$ := the largest index such that $s_l < s_{l+1}$.
    3. $r$ := the largest index such that $s_l < s_r$.
    4. Swap $s_l$ and $s_r$.
    5. __For__ $i = 0 ... ⌊(n−l)/2⌋$: Swap $s_{l+1+i}$ and $s_{n-i}$.
    6. __Return__ $s$.
3. Aggregate method.
    - __Claim 1__: The sequence from $s_{l+1}$ to $s_n$ is in decreasing order and represents a sequence that finishes permutation. __Proof__: $l$ is the largest index such that $s_l < s_{l+1}$, so $s_{l+1}$ to $s_n$ is in decreasing order. A decreasing sequence up to $s_n$ means that no more permutation is allowed from $s_{l+1}$ to $s_n$; otherwise, the lexicographical order is violated.
    - __Claim 2__: $s_r$ is the next number to be in the $l$-th index where $l < r ≤ n$. __Proof__: $s_l < s_{l+1}$, so the largest index $r$ such that $s_l < s_r$ is at least $i+1$, i.e., $l < r ≤ n$. The next number to be in the $l$-th index should be larger than $s_l$ but the smallest from $s_{l+1}$ to $s_n$; otherwise, the lexicographical order is violated.
    - __Claim 3__: After Step 4 swaps $s_l$ and $s_r$, the decreasing property from $s_{l+1}$ to $s_n$ is still preserved. After Step 5, the sequence from $s_{l+1}$ to $s_n$ turns to an increasing sequence. __Proof__: $s_{r-1} > s_r > s_l > s_{r+1}$, so replacing $s_r$ with $s_l$ preserves the decreasing order. Step 5 reverse the sequence from $s_{l+1}$ to $s_n$, hence, make a decreasing sequence be increasing.
    - __Claim 4__: A change of $s_k$ occurs every $(n-k)!$ operations of $f(s)$. __Proof__: $s_k$ is changed if and only if $k ≥ l$. And $k ≥ l$ if and only if the sequence from $s_{l+1}$ to $s_n$ finishes permutation, which occurs every $(n-k)!$ operations of $f(s)$. Hence, in a total of $n!$ operations, a change of $s_k$ occurs $n!/(n-k)!$ times.
    - __Conclusion__: Suppose there are a total of $N$ operations on $f(s)$. The total cost is $\sum_{k=1}^n N/(n-k)!$ ≤ $N \sum_{k=0}^\infty 1/k!$ = $eN$. Hence, the amortized cost is $eN/N$ = $e$ = $O(1)$.

### Problem 6
1.
    - Problem description:
        - __Vertex Cover__: {$⟨G,k⟩$: Graph $G$ has a vertex cover of size $k$}
        - __Halting Problem__: {$⟨M,w⟩$: Turing machine $M$ halts on input word $w$}
    - __Claim 1__: __Vertex Cover__ is a known NP-complete problem.
    - __Claim 2__: There is a reduction from an instance of $⟨G,k⟩$ for __Vertex Cover__ to an instance of $⟨M,w⟩$ for __Halting Problem__.
        1. __Vertex Cover__ is a known NP-complete problem, so there is a non-deterministic Turing machine $V$ that solves __Vertex Cover__.
        2. Define Turing machine $H$ as follows: On input $⟨V,⟨G,k⟩⟩$: Run $V$ on $⟨G,k⟩$. Return if $V$ accepts. Loop if $V$ rejects.
        3. The input word for __Halting Problem__ is constructed as $⟨H,⟨V,⟨G,k⟩⟩⟩$. __Halting Problem__ returns __true__ if $H$ halts on $⟨V,⟨G,k⟩⟩$, otherwise, returns __false__.
    - __Claim 3__: $G$ has a vertex cover of size $k$ iff $H$ halts on $⟨V,⟨G,k⟩⟩$.
        - &rArr;: Suppose $G$ has a vertex cover of size $k$. Then, $V$ accepts $⟨G,k⟩$. Then, $H$ halts on $⟨V,⟨G,k⟩⟩$.
        - &lArr;: Suppose $H$ halts on $⟨V,⟨G,k⟩⟩$. Then, $V$ accepts $⟨G,k⟩$.  Then, $G$ has a vertex cover of size $k$.
    - __Claim 4__: The machine description of $V$ and $H$ can be constructed in constant time, regardless of $G$ and $k$. Hence, there is polynomial time reduction from $⟨G,k⟩$ to $⟨M,w⟩=⟨H,⟨V,⟨G,k⟩⟩⟩$.
    - __Conclusion__: __Halting Problem__ is NP-hard.
2.
    1. Each solution is expressed as a set of position of light bulbs.
        - Solutions to puzzle $A$: {$A_{2,1}$}, {$A_{2,4}$}
        - Solutions to puzzle $B$: {$B_{2,3},B_{2,6},B_{5,2},B_{6,4},B_{6,7},B_{4,7}$}, {$B_{2,4},B_{2,7},B_{3,2},B_{6,3},B_{6,6},B_{4,7}$}
    2.
        - Solutions to puzzle $C$: $(a,b,c)$ = $(0,0,1)$, $(0,1,1)$, $(1,1,0)$, $(1,0,1)$.
        - Solutions to puzzle $D$: $(a,b,c)$ = $(0,0,1)$, $(1,1,0)$.
    3. There has to be a light bulb in $z$ in order for $z$ to light up. But the black cell right of $z$ is 0.
    4. Reference: Brandon McPhail. Light Up is NP-complete.
        - __Claim 1__: The circuit satisfiability problem (Circuit-SAT) is a known NP-complete problem.
        - __Claim 2__: There is a reduction from Circuit-SAT to the puzzle.
            - Every circuit has an equivalent circuit with only NOR or NAND gates. The transformation can be done in polynomial time and is beyond the scope of this proof. The construction here focuses on the NOR gate.
            - Inputs and outputs of a gate corresponds to a formula. The NOR gate is reduced to the corresponding puzzle as below. Connecting the output of the OR gate/puzzle and the input of the NOT gate/puzzle results in a full NOR gate/puzzle.
                |OR gate/puzzle|NOT gate/puzzle|
                |:------------:|:-------------:|
                |![][3]|![][1]|
                <br>
            - Branches and crosses in a circuit remain to be handled. Branches are given as below. Crosses can be taken care of by 3 branches and 3 XOR gate/puzzle. XOR gate/puzzle is also given as below.
                |Branch|XOR gate/puzzle|
                |:----:|:-------------:|
                |![][2]|![][4]|
                ![](https://github.com/b00401062/b00401062.github.io/raw/master/Computer/Algorithm%20Design%20and%20Analysis/fig5.png =x100)
        - __Claim 3__: A circuit is satisfiable iff the puzzle is solvable.
            - &rArr;: Suppose a circuit is satisfiable, there is an assignment of variables such that the last output evaluates to true. No contradiction of assignments occurs along the gates. Hence, there is always a way to put a light bulb on a row/column of white cells. The puzzle is solvable.
            - &lArr;: Suppose the puzzle is solvable, there is no contradiction of assignments occurs along the white cells. Hence, there is an assignment of variables such that the last output evaluates to true. The circuit is satisfiable.
        - __Claim 4__: The reduction is done in polynomial-time since every gate and branch/cross of a circuit reduces to a fixed number of puzzle grids.
        - __Conclusion__: The decision problem of Light-Up is NP-hard.

[1]: https://github.com/b00401062/b00401062.github.io/raw/master/Computer/Algorithm%20Design%20and%20Analysis/fig1.png
[2]: https://github.com/b00401062/b00401062.github.io/raw/master/Computer/Algorithm%20Design%20and%20Analysis/fig2.png
[3]: https://github.com/b00401062/b00401062.github.io/raw/master/Computer/Algorithm%20Design%20and%20Analysis/fig3.png
[4]: https://github.com/b00401062/b00401062.github.io/raw/master/Computer/Algorithm%20Design%20and%20Analysis/fig4.png
[5]: https://github.com/b00401062/b00401062.github.io/raw/master/Computer/Algorithm%20Design%20and%20Analysis/fig5.png
