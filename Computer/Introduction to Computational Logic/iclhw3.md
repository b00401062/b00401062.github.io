## Homework 3
B00401062 羅文斌

1. $\boxed{
    \underline{1\ ∃x ∃y (S(x,y) ∨ S(y,x))} \qquad \text{premise} \\
    \boxed{
        2\ x_0 \\
        \underline{3\ ∃y (S(x_0,y) ∨ S(y,x_0))} \qquad \text{assumption} \\
        \boxed{
            4\ y_0 \\
            \underline{5\ S(x_0,y_0) ∨ S(y_0,x_0)} \qquad \text{assumption} \\
            \boxed{
                \underline{6\ S(x_0,y_0)} \qquad \text{assumption} \\
                7\ ∃y S(x_0,y) \qquad ∃y\text{i}:6 \\
                8\ ∃x ∃y S(x,y) \qquad ∃x\text{i}:7
            } \\
            \boxed{
                \underline{9\ S(y_0,x_0)} \qquad \text{assumption} \\
                10\ ∃y S(y_0,y) \qquad ∃y\text{i}:9 \\
                11\ ∃x ∃y S(x,y) \qquad ∃x\text{i}:10
            } \\
            12\ ∃x ∃y S(x,y) \qquad \lor\text{e}:5,6-8,9-11
        } \\
        13\ ∃x ∃y S(x,y) \qquad ∃y\text{e}:3,4-12
    } \\
    14\ ∃x ∃y S(x,y) \qquad ∃x\text{e}:1,2-13
    }$

2. $\boxed{
    1\ ∀x∀y∀z(S(x,y)∧S(y,z)⟹S(x,z)) \qquad \text{premise} \\
    \underline{2\ ∀x¬S(x,x)} \qquad \text{premise} \\
    \boxed{
        3\ x_0 \\
        4\ ∀y∀z(S(x_0,y)∧S(y,z)⟹S(x_0,z)) \qquad ∀x\text{e}:1 \\
        \underline{5\ ¬S(x_0,x_0)} \qquad ∀x\text{e}:2 \\
        \boxed{
            6\ y_0 \\
            7\ ∀z(S(x_0,y_0)∧S(y_0,z)⟹S(x_0,z)) \qquad ∀y\text{e}:4 \\
            \underline{8\ S(x_0,y_0)∧S(y_0,x_0)⟹S(x_0,x_0)} \qquad ∀z\text{e}:7 \\
            9\ ¬(S(x_0,y_0)∧S(y_0,x_0)) \qquad \text{MT}:8,5 \\
            \boxed{
                \underline{10\ S(x_0,y_0)} \qquad \text{assumption} \\
                \boxed{
                    \underline{11\ S(y_0,x_0)} \qquad \text{assumption} \\
                    12\ S(x_0,y_0)∧S(y_0,x_0) \qquad ∧\text{i}:10,11 \\
                    13\ ⊥ \qquad ⊥\text{i}:12,9
                } \\
                14\ ¬S(y_0,x_0) \qquad ¬\text{i}:11-13
            } \\
            15\ S(x_0,y_0)⟹¬S(y_0,x_0) \qquad ⟹\text{i}:10-14
        } \\
        16\ ∀y(S(x_0,y)⟹¬S(y,x_0)) \qquad ∀y\text{i}:6-15
    } \\
    17\ ∀x∀y(S(x,y)⟹¬S(y,x)) \qquad ∀x\text{i}:3-16
    }$

3. $\boxed{
    1\ ∃x∃y(S(x,y) ∨ S(y,x)) \qquad \text{premise} \\
    \underline{2\ ¬∃xS(x,x)} \qquad \text{premise} \\
    \boxed{
        3\ x_0 \\
        \underline{4\ ∃y(S(x_0,y) ∨ S(y,x_0))} \qquad \text{assumption} \\
        \boxed{
            5\ y_0 \\
            \underline{6\ S(x_0,y_0) ∨ S(y_0,x_0)} \qquad \text{assumption} \\
            \boxed{
                \underline{7\ x_0 = y_0} \qquad \text{assumption} \\
                \boxed{
                    \underline{8\ S(x_0,y_0)} \qquad \text{assumption} \\
                    9\ S(y_0,y_0) \qquad =\text{e}:7,8 \\
                    10\ ∃xS(x,x) \qquad ∃x\text{i}:9 \\
                    11\ ⊥ \qquad ⊥\text{i}:10,2
                } \\
                \boxed{
                    \underline{12\ S(y_0,x_0)} \qquad \text{assumption} \\
                    13\ S(y_0,y_0) \qquad =\text{e}:7,12 \\
                    14\ ∃xS(x,x) \qquad ∃x\text{i}:13 \\
                    15\ ⊥ \qquad ⊥\text{i}:14,2
                } \\
                16\ ⊥ \qquad ∨\text{e}:6,8-11,12-15
            } \\
            17\ ¬(x_0 = y_0) \qquad ¬\text{i}:7 \\
            18\ ∃y¬(x_0 = y) \qquad ∃y\text{i}:17 \\
            19\ ∃x∃y¬(x = y) \qquad ∃x\text{i}:18
        } \\
        20\ ∃x∃y¬(x = y) \qquad ∃y\text{e}:4,5-19
    } \\
    21\ ∃x∃y¬(x = y) \qquad ∃x\text{e}:1,3-20
    }$

4. Consider $∀x(P(x) ∨ Q(x)) ⊨ ∀xP(x) ∨ ∀xQ(x)$. Let $M$ be a model where $A=\{a,b\}$, $P^M=\{a\}$, and $Q^M=\{b\}$. Since $a\in P^M$ and $b\in Q^M$, $M  ⊨ ∀x(P(x) ∨ Q(x))$. Since $b\not\in P^M$ and $a\not\in Q^M$, $M \not⊨ ∀x(P(x) ∨ Q(x))$. Hence, $∀x(P(x) ∨ Q(x)) \not⊨ ∀xP(x) ∨ ∀xQ(x)$. The soundness theorem says if $∀x(P(x) ∨ Q(x)) ⊢ ∀xP(x) ∨ ∀xQ(x)$ is valid, then $∀x(P(x) ∨ Q(x)) ⊨ ∀xP(x) ∨ ∀xQ(x)$ holds. Since $M \not⊨ ∀x(P(x) ∨ Q(x))$, $∀x(P(x) ∨ Q(x)) \not⊢ ∀xP(x) ∨ ∀xQ(x)$.
5. Let $M$ be a model that $M ⊨ ∀x¬φ$. Assume $M \not⊨ \lnot∃xφ$. There exists an element $a$ in the universe of $M$ s.t. $φ$ computes to T. But since $M ⊨ ∀x¬φ$, $¬φ$ computes to T, or $φ$ computes to F, regardless of $a$. This is a contradiction. Hence, $M ⊨ \lnot∃xφ$.
