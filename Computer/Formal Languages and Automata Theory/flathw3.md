## Homework 3

1. 
    1. Reject. $q_0 ⊢ q_\text{rej}$
    2. Accept. $q_0011 ⊢ ⊲p_011 ⊢ ⊲0p_11 ⊢ ⊲01p_1 ⊢ ⊲01s1 ⊢ ⊲0s10 ⊢ ⊲s000 ⊢ t⊲100 ⊢ q_\text{acc}⊲100$
    3. Reject. $q_0100 ⊢ ⊲p_100 ⊢ ⊲1p_00 ⊢ ⊲10p_0 ⊢ ⊲10q_\text{rej}0$
    4. Accept. $q_0111 ⊢ ⊲p_111 ⊢ ⊲1p_11 ⊢ ⊲11p_1 ⊢ ⊲11s1 ⊢ ⊲1s10 ⊢ ⊲s100 ⊢ s⊲000 ⊢ ⊲r_1000$
        $⊢ ⊲1r_000 ⊢ ⊲10r_00 ⊢ ⊲100r_0 ⊢ ⊲10t00 ⊢ ⊲1t000 ⊢ ⊲t1000 ⊢ t⊲1000 ⊢ q_\text{acc}⊲1000$
2. Let $M_2$ be an NTM and have $Σ_2 = Σ ∪ Γ ∪ Q$. On input $w$:
    1. __If__ $w$ has any symbol other than $Σ_2$: Reject.
    2. __If__ $w$ has no state symbol or has more than one state symbol from $Q$: Reject.
    3. Move head position to the state symbol $w_i = q ∈ Q$.
    4. __If__ $q = q_0$: Accept.
    5. Consider a two-tuple $(q^+,w^+) ∈ Q × Γ$ and choose one of the three following steps nondeterministically :
        1. __If__ there is $(q^+,w^+)$ such that $δ(q^+,w^+) = (q,w_{i+1},\text{Stay})$: Overwrite $qw_{i+1}$ with $q^+w^+$. __Otherwise__: Reject
        2. __If__ there is $(q^+,w^+)$ such that $δ(q^+,w^+) = (q,w_{i+2},\text{Left})$: Overwrite $qw_{i+1}w_{i+2}$ with $w_{i+1}q^+w^+$. __Otherwise__: Reject.
        3. __If__ there is $(q^+,w^+)$ such that $δ(q^+,w^+) = (q,w_{i-1},\text{Right})$: Overwrite $w_{i-1}q$ with $q^+w^+$. __Otherwise__: Reject.
    6. __Repeat__ step 1-5 until accept or reject.
3. Consider a three-tape Turing machine.
    1. Put input $w$ on tape 1.
    2. Scan $w$ from left to right and put head position on the state symbol $w_i = q$.
    3. Copy the state symbol $w_i = q$ and the next input symbol $w_{i+1}$ to tape 2.
    4. Match $(q,w_{i+1})$ on tape 2 to the corresponding transition relation $δ(q,w_{i+1})=(q^+,w^+,d)$, where $d ∈ \{\text{Left,Right,Stay}\}$.
    5. Copy the instruction $(q^+,w^+,d)$ to tape 3.
    6. __If__ $d = \text{Stay}$: Overwrite $qw_{i+1}$ with $q^+w^+$.
    7. __Else if__ $d = \text{Left}$: Overwrite $w_{i-1}qw_{i+1}$ with $q^+w_{i-1}w^+$
    8. __Else if__ $d = \text{Right}$: Overwrite $qw_{i+1}$ with $w^+q^+$.
    9. __Return__ output on tape 1.
4. 
    - Let a decider for $L_\text{fin}$ be $R$ := On input $⌊M⌋$: Accept if $L(M)$ is finite. Reject if $L(M)$ is infinite.
    - Define $M'(M,w)$ := On input $x$: Accept if $M$ accepts $w$.
    - Construct a decider $S$ := On input $(M,w)$: Construct $M'(M,w)$. Run $R$ on $⌊M'⌋$. Accept if $H$ rejects. Reject if $R$ accepts.
    - Run $S$ on input $(M,w)$ and consider the following two cases:
        - $w ∈ L(M)$: $M'(M,w)$ accepts everything, i.e., $L(M')$ is infinite. Hence, $R$ rejects and  $S$ accepts.
        - $w \not∈ L(M)$: $M'(M,w)$ accepts nothing, i.e., $|$L(M')$| = 0$, which is finite. Hence, $R$ accepts and $S$ rejects.
    - Conclusion: If $R$ decides $L_\text{fin}$, then $S$ decides $A_\text{TM} = \{ (M,w) | w ∈ L(M) \}$. However, $A_\text{TM}$ is undecidable (as proved in class), so there is no such $R$ that decides $L_\text{fin}$. $L_\text{fin}$ is undecidable.
5. 
    - Let EQ$_\text{CFG,DFA} = \{ (G,A) | G \text{ is a CFG, } A \text{ is a DFA, } L(G) = L(A) \}$.
    - Let a decider for EQ$_\text{CFG,DFA}$ be $R$ := On input $(G,A)$: Accept if $L(G) = L(A)$. Reject if $L(G) ≠ L(A)$.
    - Construct a decider $S$ := On input $(G)$: Construct a DFA $A$ that accepts $Σ^*$. Run $R$ on $(G,A)$. Accept if $R$ accepts. Reject if $R$ rejects.
    - Run $S$ on input $G$ and consider the following two cases:
        - $L(G) = Σ^*$: $L(A) = Σ^*$. Hence, $R$ accepts $(G,A)$, and $S$ accepts.
        - $L(G) ≠ Σ^*$: $L(A) = Σ^*$. Hence, $R$ rejects $(G,A)$, and $S$ rejects.
    - Conclusion: If $R$ decides EQ$_\text{CFG,DFA}$, then $S$ decides ALL$_\text{CFG} = \{ G | G \text{ is a CFG, } L(G) = Σ^* \}$. However, ALL$_\text{CFG}$ is undecidable (as proved in class), so there is no such $R$ that decides EQ$_\text{CFG,DFA}$. EQ$_\text{CFG,DFA}$ is undecidable.
6. 
    - Let CFL$_\text{TM} = \{ ⌊M⌋ | L(M) \text{ is context free} \}$.
    - Let a decider for CFL$_\text{TM}$ be $R$ := On input $⌊M⌋$: Accept if $L(M)$ is context free. Reject if $L(M)$ is not.
    - Define $M'(M,w)$ := On input $x$: Accept if $x$ has the form $0^n1^n0^n$. Otherwise, run $M$ on $w$. Accept if $M$ accepts $w$.
    - Construct a decider $S$ := On input $(M,w)$: Construct $M'(M,w)$. Run $R$ on $⌊M'⌋$. Accept if $R$ accepts. Reject if $R$ rejects.
    - Run $S$ on input $(M,w)$ and consider the following two cases:
        - $w ∈ L(M)$: $M'(M,w)$ accepts everything, i.e., $L(M') = Σ^*$, which is context free. Hence, $R$ accepts, and $S$ accepts.
        - $w \not∈ L(M)$: $M'(M,w)$ accepts input of the form $0^n1^n0^n$, which is not context free. Hence, $R$ rejects, and $S$ rejects.
    - Conclusion: If $R$ decides CFL$_\text{TM}$, then $S$ decides $A_\text{TM} = \{ (M,w) | w ∈ L(M) \}$. However, $A_\text{TM}$ is undecidable (as proved in class), so there is no such $R$ that decides CFL$_\text{TM}$. CFL$_\text{TM}$ is undecidable.
