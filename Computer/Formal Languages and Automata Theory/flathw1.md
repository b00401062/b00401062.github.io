## Homework 1

1.
    a. ![](Formal%20Languages%20and%20Automata%20Theory/flathw1-1-a.png)
    b. ![](Formal%20Languages%20and%20Automata%20Theory/flathw1-1-b.png)
    c. ![](Formal%20Languages%20and%20Automata%20Theory/flathw1-1-c.png)
    d. ![](Formal%20Languages%20and%20Automata%20Theory/flathw1-1-d.png)
    e. ![](Formal%20Languages%20and%20Automata%20Theory/flathw1-1-e.png)
2.
    a. $b^*ab^*ab^*$
    b. $b\Sigma^*a$
    c. $\Sigma^*bba\Sigma^*$
    d. $b^*a^*$
    e. $b^*a^* \cup \Sigma^*ba$

3.
    a. $a^*ba^*$
    b. $(a \cup ba^*b)^*$
    c. $(\Sigma^2)^*$
    d. Suppose $L$ is regular and $A = \langle \Sigma, Q, q_0, F, \delta \rangle$ is its DFA. Consider a word $a^mba^n \in L$, where $m,n\in\mathbb{N}$, $m\le n$, and $m>|Q|$. Then, $a^m$ can be divided into three parts $a^m = a^ua^va^w$, and $m = u + v + w$ s.t. $a^u(a^v)^ka^wba^n \in L$ for every nonnegative integer $k ≥ 0$. However, there is a contradiction because $a^u(a^v)^ka^wba^n \not\in L$ when $u+kv+w>n$, or $k>(n-u-w)/v$. Therefore, $L$ is not regular.
    e. Suppose $L$ is regular and $A = \langle \Sigma, Q, q_0, F, \delta \rangle$ is its DFA. Consider a word $a^k$, where $k$ is a prime number, and $k>|Q|$. Then, $a^k$ can be divided into three parts $a^k = a^ua^va^w$, and $k = u + v + w$ s.t. $a^u(a^v)^na^w \in L$ for every nonnegative integer $n ≥ 0$. However, there is a contradiction because $a^u(a^v)^na^w \not\in L$ when $n = k+1$, $u+vn+w = (v+1)k$, which is not a prime number. Therefore, $L$ is not regular.
4.
    a.
    (1) _Reflexivity_. For every $w∈Σ^∗$, $uw∈L$ if and only if $uw∈L$ always holds. Therefore, $u∼_L u$ holds.
    (2) _Symmetry_. Suppose $u∼_L v$ holds. Then, for every $w∈Σ^∗$, $uw∈L$ if and only if $vw∈L$, and vice versa, $vw∈L$ if and only if $uw∈L$. Therefore, $v∼_L u$ holds.
    (3) _Transitivity_. Suppose $t∼_L u$ and $u∼_L v$. Then, for every $w∈Σ^∗$, $tw∈L$ if and only if $vw∈L$ and $uw∈L$ if and only if $vw∈L$ together imply $tw∈L$ if and only if $vw∈L$. Therefore, $t∼_L v$ holds.
    To sum up, $∼_L$ is an equivalence relation.
    b. $L$ is a regular language if and only if $\#(∼_L)$ is finite.
    &rArr;. Suppose $L$ is regular. Let $A=\langle \Sigma, Q, q_0, F, \delta \rangle$ be its DFA, where $|Q| = k$. If $\#(∼_L) > k$, and there must exist two words $u$ and $v$ in two different equivalence classes, s.t. the run of $A$ on $u$ and the run of $A$ on $v$ end in the same state. Then, $\forall w\in\Sigma^*$, $uw\in L$ if and only if $vw\in L$, which is a contradiction to that $u$ and $v$ are from two different equivalence classes. Therefore, $\#(∼_L) \le k$, which is finite.
    &lArr;. Suppose $\#(∼_L) = k$, which is finite. And the equivalence classes are $L_1,L_2,...,L_k$, s.t. $\bigcup_i L_i = \Sigma^*$ and $L_i\cap L_j=\emptyset$ for $1 \le i\ne j \le k$. Then, a DFA $A=\langle \Sigma, Q, q_0, F, \delta \rangle$ can be constructed accordingly s.t. $L$ is recognized by $A$.
    - $Q=\{q_1,q_2,...,q_k\}$ s.t. $q_i$ corresponds to $L_i$, for $1 \le i \le k$.
    - $q_0 = q_i$ s.t. $\epsilon\in L_i$.
    - $F=\{q_i|L_i\subseteq L\}$.
    - $\delta(q_i,a)=q_j$ s.t. $\forall w\in L_i$, $wa\in L_j$.

    Given a word $w = a_1a_2...a_n \in L$, and the run of $A$ on $w$ is $p_0a_1p_1...a_np_n$. Since $w\in L_i$ if and only if the run of $A$ on $w$ ends at $q_i$, therefore, $w\in L_{p_n}$ (which is one of the equivalence classes). Altogether, $w\in L_{p_n}$ and $w\in L$ implies $L_{p_n}\subseteq L$ and $p_n\in F$. Any word $w\in L$ is accepted by $A$, and $L$ is recognized by $A$.
