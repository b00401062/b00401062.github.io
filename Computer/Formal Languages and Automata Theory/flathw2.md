## Homework 2

1. 
    1. True.
    $S→aSbS→aaSbSbS→aaaSbSbSbS→aaabSbSbS→aaabbSbS→aaabbbS→aaabbb$. (Figure 1)
    2. False. $aabbb$, a prefix of $aabbb$, has more $b$’s than $a$’s.
    3. False. $abb$, a prefix of $abba$, has more $b$’s than $a$’s.
    4. True. 
    $S→aSbS→aaSbSbS→aabSbS→aabbS→aabbaSbS→aabbaaSbSbS→aabbaaaSbSbSbS$
    $→aabbaaabSbSbS→aabbaaabbSbS→aabbaaabbbS→aabbaaabbb$. (Figure 2)
    5. False. $b$, a prefix of $baababba$, has more $b$’s than $a$’s.
2. 
    1. $Σ=\{a,b\}$, $V=\{S\}$, $S$ is the start variable, $R$:
        - $S→a|aS|aSb$
    2. $Σ=\{a,b\}$, $V=\{S\}$, $S$ is the start variable, $R$:
        - $S→b|Sb|aSb$
    3. $Σ=\{a,b\}$, $V=\{S\}$, $S$ is the start variable, $R$:
        - $S→aaSb|ϵ$
    4. $Σ=\{a,b,$\$$\}$, $V=\{S,X\}$, $S$ is the start variable, $R$:
        - $S→X$\$
        - $X→aXa|bXb|$\$
    5. $L_5=L_1 ∪ L_2 ∪ \{Σ^∗baΣ^∗\}$. $Σ=\{a,b\}$, $V=\{S,S_1,S_2,S_3,X\}$, $S$ is the start variable, $R$:
        - $S→S_1|S_2|S_3$
        - $S_1→a|aS_1|aS_1b$
        - $S_2→b|S_2b|aS_2b$
        - $S_3→XbaX$
        - $X→XX|a|b|ϵ$
3. 
    1. Suppose $L_1=\{a^kb^mc^n |k≤m≤n\}$ is context-free. $\exists p∈\mathbb{N}$, for every $w∈L_1$, if $|w|≥p$, then $w$ can be partitioned into five parts $w = sxyzt$, where $|xz|≥1$ and $|xyz|≤p$, s.t. $sx^iyz^it∈L_1$ $\forall i≥0$. Consider $w=a^kb^kc^k∈L_1$, where $k≥p$. There are five possible cases of $xyz$:
        - __Case 1__: $xyz=a^α$ for some $1≤α≤p$. Consider $i=2$.
        $sx^iyz^it=a^{k'}b^kc^k$ has $k'≥k+1>k$. So, $sx^iyz^it\not∈L_1$.
        - __Case 2__: $xyz=a^αb^β$ for some $1≤α+β≤p$. Consider $i=2$.
        $sx^iyz^it=a^{k'}b^{k''}c^k$ has either $k'≥k+1>k$ or $k''≥k+1>k$. So, $sx^iyz^it\not∈L_1$.
        - __Case 3__: $xyz=b^β$ for some $1≤β≤p$. Consider $i=2$.
        $sx^iyz^it=a^kb^{k'}c^k$ has $k'≥k+1>k$. So, $sx^iyz^it\not∈L_1$.
        - __Case 4__: $xyz=b^βc^γ$ for some $1≤β+γ≤p$. Consider $i=0$.
        $sx^iyz^it=a^kb^{k'}c^{k''}$ has either $k'<k$ or $k''<k$. So, $sx^iyz^it\not∈L_1$.
        - __Case 5__: $xyz=c^γ$ for some $1≤γ≤p$. Consider $i=0$.
        $sx^iyz^it=a^kb^kc^{k'}$ has $k'<k$. So, $sx^iyz^it\not∈L_1$.
    - __Conclusion__: This is a contradiction to the pumping lemma, so $L_1$ is not context-free.
    2. Suppose $L_2=\{a^n|n$ is a prime number$\}$ is context-free. $\exists p∈\mathbb{N}$, for every $w∈L_2$, if $|w|≥p$, then $w$ can be partitioned into five parts $w = sxyzt$, where $|xz|≥1$ and $|xyz|≤p$, s.t. $sx^iyz^it∈L_2$ $\forall i≥0$. Consider $w=a^n∈L_2$, where $n≥p+2$. Consider $i=|syt|$. Then, $|sx^iyz^it|$$=|syt|+|xz||syt|=(|xz|+1)|syt|$, which is not a prime number because $|xz|+1≥2$ and $|syt|≥2$.
    - __Conclusion__: This is a contradiction to the pumping lemma, so $L_2$ is not context-free.
4. 
    - &rArr; (only if):
        - __IH__: Every prefix of $w ∈ L(G)$ where $|w|≤n$ has at least as many $a$’s as $b$’s.
        - __Basis__: $w ∈ L(G)$ where $|w|=0$, i.e., $ϵ$, is always true for the hypothesis.
        - __IS__: __Assumption__: Given $w ∈ L(G)$ where $|w|=n+1$.<br>$w$ can be generated in either ways: (1) $aS$, where $S→^*w’ ∈ L(G)$ and $|w'|=n$, and (2) $aSbS$, where first $S→^*w_1 ∈ L(G)$, second $S→^*w_2 ∈ L(G)$, and $|w_1|+|w_2|=n-1$. Consider two cases.
            - __Case (1)__: Every prefix of $w$ has at least as many $a$’s as $b$’s, so every prefix of $aw'$ also has at least as many $a$’s as $b$’s.
            - __Case (2)__: Every prefix of $w_1$ and $w_2$ has at least as many $a$’s as $b$’s, so every prefix of $aw_1bw_2$, including $aw_1$, $aw_1b$ and $aw_1bw_2$ itself, has at least as many $a$’s as $b$’s.
        - __Conclusion__: The IH is true for $n+1$, and therefore, for all $n≥0$.
    - &lArr; (if):
        - __IH__: If every prefix of $w$ where $|w|≤n$ has at least as many $a$’s as $b$’s, then $w ∈ L(G)$.
        - __Basis__: $w$ where $|w|=0$, i.e., $ϵ$, has at least as many $a$’s as $b$’s and is in $L(G)$, because there is a derivation: $S→ϵ$.
        - __IS__: __Assumption__: Given $w$ where $|w|=n+1$ s.t. every prefix of $w$ has at least as many $a$’s as $b$’s.<br>There exists a partition of $w$ in either way: (1) $aw'$, where $|w'|=n$ and every prefix of $w'$ has at least as many $a$’s as $b$’s. (2) $aw_1bw_2$, where $|w_1|+|w_2|=n-1$ and every prefix of $w_1$ and $w_2$ has at least as many $a$’s as $b$’s. Otherwise, $w$ cannot be partitioned in either way. Also, $w$ can never start with $b$. So, $w=aw_1'bw_2'bw_3'$, s.t. $w_1',w_2'∈L(G)$ and both have as many $a$’s as $b$’s. However, $w$ has a prefix, $aw_1'bw_2'b$, that has more $b$'s than $a$'s, which is a contradiction to the assumption. Therefore, $|w|$ can always be partitioned in either way. Consider two cases.
            - __Case (1)__: $w' ∈ L(G)$, so there is a derivation: $S→aS→^*aw'=w ∈ L(G)$.
            - __Case (2)__: $w_1,w_2 ∈ L(G)$, so there is a derivation: $S→aSbS→^*aw_1bw_2=w ∈ L(G)$.
        - __Conclusion__: The IH is true for $n+1$, and therefore, for all $n≥0$.
5. Prove. Let $A_1=(Σ_1,Γ_1,Q_1,q_{1,0},F_1,δ_1)$ be a PDA that recognizes $L_1$ and $A_2=(Σ_2,Q_2,q_{2,0},F_2,δ_2)$ be  a DFA that recognizes $L_2$. A PDA $A=(Σ,Γ,Q,q_0,F,δ)$ that accepts $L_1∩L_2$ is constructed as follows: $Σ=Σ_1∩Σ_2$; $Γ=Γ_1$; $Q=Q_1×Q_2$; $q_0=(q_{1,0},q_{2,0})$; $F=F_1×F_2$; $$δ((s_1,s_2),x,a)=\{ ((s_1',s_2'),b) | (s_1',b)∈δ_1(s_1,x,a) ∧ s_2'=δ_2(s_2,x)\}$$ $L(A)=L_1∩L_2$ is proved by showing that for any $w∈Σ^*$, $(q_0,ε) \xrightarrow{w}_A^* ((s_1,s_2),σ)$ iff $(q_{1,0},ε) \xrightarrow{w}_{A_1}^* (s_1,σ)$ and $q_{2,0} \xrightarrow{w}_{A_2}^* s_2$.
    - $(q_0,ε) \xrightarrow{w}_A^* ((s_1,s_2),σ)$ &rArr; $(q_{1,0},ε) \xrightarrow{w}_{A_1}^* (s_1,σ)$ and $q_{2,0} \xrightarrow{w}_{A_2}^* s_2$:
        - __IH__: Suppose the formula is true for any $w$ of length $n$.
        - __Basis__: Given $w$ where $|w|=0$, i.e., $ϵ$. The run of $A$ on $ϵ$ is $(q_0,ε)$. The run of $A_1$ on $ϵ$ is $(q_{1,0},ε)$. The run of $A_2$ on $ϵ$ is $q_{2,0}$. Therefore, the IH is true for $n=0$.
        - __IS__: __Assumption__: Given $w$ where $|w|=n+1$ s.t. the run of $A$ on $w$ is $$(q_0,ε)→_A^* ((s_{1,n},s_{2,n}),σ_n) \xrightarrow{w_{n+1}}_A ((s_{1,n+1},s_{2,n+1}),σ_{n+1})$$ From the assumption, we know there exist $a,b∈Γ^*$ s.t. stack $σ_{n+1}$ is obtained from stack $σ_n$ by popping $a$ and pushing $b$ and $((s_{1,n+1},s_{2,n+1}),b)∈δ((s_{1,n},s_{2,n}),w_{n+1},a)$.
            - Consider the run of $A_1$ on $w$: $(q_{1,0},ε) →_{A_1}^* (s_{1,n},σ_n) \xrightarrow{w_{n+1}}_{A_1} (s_{1,n+1},σ_{n+1})$ because there exist $a,b∈Γ^*$ s.t. $(s_{1,n+1},b)∈δ_1(s_{1,n},w_{n+1},a)$ and stack $σ_{n+1}$ is obtained from stack $σ_n$ by popping $a$ and pushing $b$.
            - Consider the run of $A_2$ on $w$: $q_{2,0} →_{A_2}^* s_{2,n} \xrightarrow{w_{n+1}}_{A_2} s_{2,n+1}$ because $s_{2,n+1}=δ_2(s_{2,n},w_{n+1})$.
        - __Conclusion__: The IH is true for $n+1$, and therefore, for all $n≥0$.
    - $(q_0,ε) \xrightarrow{w}_A^* ((s_1,s_2),σ)$ &lArr; $(q_{1,0},ε) \xrightarrow{w}_{A_1}^* (s_1,σ)$ and $q_{2,0} \xrightarrow{w}_{A_2}^* s_2$:
        - __IH__: Suppose the formula is true for any $w$ of length $n$.
        - __Basis__: Given $w$ where $|w|=0$, i.e., $ϵ$. The run of $A_1$ on $Σ$ is $(q_{1,0},ε)$. The run of $A_2$ on $ϵ$ is $q_{2,0}$. The run of $A$ on $ϵ$ is $(q_0,ε)$. Therefore, the IH is true for $n=0$.
        - __IS__: __Assumption__: Given $w$ where $|w|=n+1$ s.t.<br>the run of $A_1$ on $w$ is $(q_{1,0},ε) →_{A_1}^* (s_{1,n},σ_n) \xrightarrow{w_{n+1}}_{A_1} (s_{1,n+1},σ_{n+1})$, and<br>the run of $A_2$ on $w$ is $q_{2,0} →_{A_2}^* s_{2,n} \xrightarrow{w_{n+1}}_{A_2} s_{2,n+1}$.<br>From the assumption, we know there exist $a,b∈Γ^*$ s.t. $(s_{1,n+1},b)∈δ_1(s_{1,n},w_{n+1},a)$ and stack $σ_{n+1}$ is obtained from stack $σ_n$ by popping $a$ and pushing $b$, and that $s_{2,n+1}=δ_2(s_{2,n},w_{n+1})$. Consider the run of $A$ on $w$: $$(q_0,ε)→_A^* ((s_{1,n},s_{2,n}),σ_n) \xrightarrow{w_{n+1}}_A ((s_{1,n+1},s_{2,n+1}),σ_{n+1})$$ because there exist $a,b∈Γ^*$ s.t. stack $σ_{n+1}$ is obtained from stack $σ_n$ by popping $a$ and pushing $b$ and $((s_{1,n+1},s_{2,n+1}),b)∈δ((s_{1,n},s_{2,n}),w_{n+1},a)$.
        - __Conclusion__: The IH is true for $n+1$, and therefore, for all $n≥0$.
    - __Conclusion__: $(s_1,s_2)∈F$ iff $s_1∈F_1$ and $s_2∈F_2$. For any $w∈Σ^*$, $w$ is accepted by $A$ iff $w$ is accepted by both $A_1$ and $A_2$. Therefore, $L_1∩L_2$ is context-free because it is recognized by some PDA.
- Figure 1.
```graphviz
graph hierarchy {
    size=3
    node [color=Black,shape=plaintext]
    edge [color=black,style=solid]
    S -- {a11[label="a"] S11[label="S"] b11[label="b"] S12[label="S"]}
    S11 -- {a21[label="a"] S21[label="S"] b21[label="b"] S22[label="S"]}
    S21 -- {a31[label="a"] S31[label="S"] b31[label="b"] S32[label="S"]}
    S12 -- {ε21[label="ε"]}
    S22 -- {ε31[label="ε"]}
    S31 -- {ε41[label="ε"]}
    S32 -- {ε42[label="ε"]}
}
```
- Figure 2.
```graphviz
graph hierarchy {
    size=4.5
    node [color=Black,shape=plaintext]
    edge [color=black,style=solid]
    S -- {a11[label="a"] S11[label="S"] b11[label="b"] S12[label="S"]}
    S11 -- {a21[label="a"] S21[label="S"] b21[label="b"] S22[label="S"]}
    S12 -- {a22[label="a"] S23[label="S"] b22[label="b"] S24[label="S"]}
    S23 -- {a31[label="a"] S31[label="S"] b31[label="b"] S32[label="S"]}
    S31 -- {a41[label="a"] S41[label="S"] b41[label="b"] S42[label="S"]}
    S21 -- {ε31[label="ε"]}
    S22 -- {ε32[label="ε"]}
    S24 -- {ε33[label="ε"]}
    S32 -- {ε41[label="ε"]}
    S41 -- {ε51[label="ε"]}
    S42 -- {ε52[label="ε"]}
}
```
