## Homework 4

1. REACH ∈ NLog-complete, i.e., REACH ∈ NLog and for every $L$ ∈ NLog, $L ≤_{\log}$ REACH. Also, NLog = coNLog.
    - REACH ∈ NLog = coNLog. Hence, REACH ∈ coNLog.
    - For every $L$ ∈ NLog = coNLog, $L ≤_{\log}$ REACH. Hence, for every $L$ ∈ coNLog, $L ≤_{\log}$ REACH.
    - __Conclusion__: REACH ∈ coNLog-complete.
2. 
    1. Let $L_1,L_2$ ∈ NP. Then, for $i=1,2$, there exists an NTM $M_i$ that decides $L_i$ in polynomial time. An NTM $M$ that decides $L_1∪L_2$ is constructed as follows: "On input $w$: Run $M_1$ and $M_2$ on $w$. Accept if $M_1$ accepts or $M_2$ accepts. Reject, otherwise." Since, $M_1$ and $M_2$ decides in polynomial time, $M$ also decides in polynomial time. __Conclusion__: $L_1∪L_2$ ∈ NP.
    2. Let $L_1,L_2$ ∈ NP. Then, for $i=1,2$, there exists an NTM $M_i$ that decides $L_i$ in polynomial time. An NTM $M$ that decides $L_1∩L_2$ is constructed as follows: "On input $w$: Run $M_1$ and $M_2$ on $w$. Accept if $M_1$ accepts and $M_2$ accepts. Reject, otherwise." Since, $M_1$ and $M_2$ decides in polynomial time, $M$ also decides in polynomial time. __Conclusion__: $L_1∩L_2$ ∈ NP.
3. 
    1. Let $L_1,L_2$ ∈ coNP. Then, for $i=1,2$, there exists an NTM $M_i$ that decides $Σ^*-L_i$ in polynomial time. An NTM $M$ that decides $Σ^*-L_1∪L_2$ = $(Σ^*-L_1)∩(Σ^*-L_2)$ is constructed as follows: "On input $w$: Run $M_1$ and $M_2$ on $w$. Accept if $M_1$ accepts and $M_2$ accepts. Reject, otherwise." Since, $M_1$ and $M_2$ decides in polynomial time, $M$ also decides in polynomial time. Hence, $Σ^*-L_1∪L_2$ ∈ NP. __Conclusion__: $L_1∪L_2$ ∈ coNP.
    2. Let $L_1,L_2$ ∈ coNP. Then, for $i=1,2$, there exists an NTM $M_i$ that decides $Σ^*-L_i$ in polynomial time. An NTM $M$ that decides $Σ^*-L_1∩L_2$ = $(Σ^*-L_1)∪(Σ^*-L_2)$ is constructed as follows: "On input $w$: Run $M_1$ and $M_2$ on $w$. Accept if $M_1$ accepts or $M_2$ accepts. Reject, otherwise." Since, $M_1$ and $M_2$ decides in polynomial time, $M$ also decides in polynomial time. Hence, $Σ^*-L_1∩L_2$ ∈ NP. __Conclusion__: $L_1∩L_2$ ∈ coNP.
4. 
    - Suppose SAT ∈ coNP. Then, $Σ^*$− SAT ∈ NP. Since SAT is NP-hard, $Σ^*$− SAT $≤_p$ SAT.
    - __Claim 1__: If $A ≤_p B$, then $Σ^*-A ≤_p Σ^*-B$. __Proof__: If $A ≤_p B$, then there exists a function $f$ such that $w \in A$ iff $f(w) \in B$. Hence, $w \not\in A$ iff $f(w) \not\in B$, i.e., $w \in Σ^*-A$ iff $f(w) \in Σ^*-B$. Hence, $Σ^*-A ≤_p Σ^*-B$.
    - By __Claim 1__ and $Σ^*$− SAT $≤_p$ SAT, we have SAT $≤_p$ $Σ^*$− SAT. Hence, $Σ^*$− SAT is NP-hard, i.e., for every $L$ ∈ NP, $L$ $≤_p$ $Σ^*$− SAT. By __Claim 1__ again, we have $Σ^*−L$ $≤_p$ SAT. Since SAT ∈ NP, $Σ^*−L$ ∈ NP, i.e., $L$ ∈ coNP. Hence, NP ⊆ coNP. __Conclusion__: If SAT ∈ coNP, then NP ⊆ coNP.
    - Suppose NP ⊆ coNP. Let $L$ ∈ coNP. By definition, $Σ^*−L$ ∈ NP ⊆ coNP. Hence, $Σ^*−L$ ∈ coNP and $L$ ∈ NP. Hence, coNP ⊆ NP. Hence, NP = coNP. __Conclusion__: If NP ⊆ coNP, then NP = coNP.
