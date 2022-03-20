## Homework 1

1.
$\boxed{
    \underline{1\ q \implies r \qquad \text{premise}} \\
    \boxed{
        \underline{2\ p \implies q \qquad \text{assumption}} \\
        \boxed{
            \underline{3\ p \qquad \text{assumption}} \\
            4\ q \qquad \implies\text{e}:3,2 \\
            5\ r \qquad \implies\text{e}:4,1
        } \\
        6\ p \implies r \qquad \implies\text{i}:3-5
    } \\
    7\ (p \implies q)\implies(p \implies r) \qquad \implies\text{i}:2-6
}$

2.
$\boxed{
    \boxed{
        \underline{1\ \lnot p \qquad \text{assumption}} \\
        \boxed{
            \underline{2\ p \qquad \text{assumption}} \\
            \boxed{
                \underline{3\ p \qquad \text{assumption}} \\
                4\ \bot \qquad \lnot\text{e}:3,1 \\
                5\ q \qquad \bot\text{e}:4
            } \\
            6\ p \implies q \qquad \implies\text{i}:3-5
        } \\
        7\ p \implies(p \implies q) \qquad \implies\text{i}:2-6
    } \\
    8\ \lnot p\implies(p \implies(p \implies q)) \qquad \implies\text{i}:1-7
}$

3.
$\boxed{
    \underline{1\ p \implies q \qquad \text{premise}} \\
    \boxed{
        2\ \lnot(\lnot p \lor q) \qquad \text{assumption} \\
        \boxed{
            \underline{3\ \lnot p \qquad \text{assumption}} \\
            4\ \lnot p \lor q \qquad \lor\text{i}_1:3 \\
            5\ \bot \qquad \lnot\text{e}:4,2
        } \\
        6\ p \qquad \text{RAA}:3-5 \\
        \boxed{
            \underline{7\ q \qquad \text{assumption}} \\
            8\ \lnot p \lor q \qquad \lor\text{i}_2:7 \\
            9\ \bot \qquad \lnot{e}:8,2
        } \\
        10\ \lnot q \qquad \lnot\text{i}:7-9 \\
        11\ q \qquad \implies\text{e}:6,1 \\
        12\ \bot \qquad \lnot\text{e}:11,10
    } \\
    13\ \lnot p \lor q \qquad \text{RAA}:2-12
}$

4.
$\boxed{
    \underline{1\ (s \implies p) \lor (t \implies q) \qquad \text{premise}} \\
    \boxed{
        \underline{2\ s \implies p \qquad \text{assumption}} \\
        3\ s \lor \lnot s \qquad \text{LEM} \\
        \boxed{
            \underline{4\ s \qquad \text{assumption}} \\
            5\ p \qquad \implies\text{e}:4,2 \\
            6\ \lnot s \lor p \qquad \lor\text{i}_2:5
        } \\
        \boxed{
            \underline{7\ \lnot s \qquad \text{assumption}} \\
            8\ \lnot s \lor p \qquad \lor\text{i}_1:7
        } \\
        9\ \lnot s \lor p \qquad \lor\text{e}:3,4-6,7-8 \\
        \boxed{
            \underline{10\ \lnot s \qquad \text{assumption}} \\
            \boxed{
                \underline{11\ s \qquad \text{assumption}} \\
                12\ \bot \qquad \lnot\text{e}:11,10 \\
                13\ q \qquad \bot\text{e}:12
            } \\
            14\ s \implies q \qquad \implies\text{i}:11-13 \\
            15\ (s \implies q) \lor (t \implies p) \qquad \lor\text{i}_1:14
        } \\
        \boxed{
            \underline{16\ p \qquad \text{assumption}} \\
            \boxed{
                \underline{17\ t \qquad \text{assumption}} \\
                18\ p
            } \\
            19\ t \implies p \qquad \implies\text{i}:17-18 \\
            20\ (s \implies q) \lor (t \implies p) \qquad \lor\text{i}_2:19
        } \\
        21\ (s \implies q) \lor (t \implies p) \qquad \lor\text{e}:9,10-15,16-20
    }
    \boxed{
        \underline{22\ t \implies q \qquad \text{assumption}} \\
        23\ t \lor \lnot t \qquad \text{LEM} \\
        \boxed{
            \underline{24\ t \qquad \text{assumption}} \\
            25\ q \qquad \implies\text{e}:24,22 \\
            26\ \lnot t \lor q \qquad \lor\text{i}_2:25
        } \\
        \boxed{
            \underline{27\ \lnot t \qquad \text{assumption}} \\
            28\ \lnot t \lor q \qquad \lor\text{i}_1:27
        } \\
        29\ \lnot t \lor q \qquad \lor\text{e}:23,24-26,27-28 \\
        \boxed{
            \underline{30\ \lnot t \qquad \text{assumption}} \\
            \boxed{
                \underline{31\ t \qquad \text{assumption}} \\
                32\ \bot \qquad \lnot\text{e}:31,30 \\
                33\ p \qquad \bot\text{e}:32
            } \\
            34\ t \implies p \qquad \implies\text{i}:31-33 \\
            35\ (s \implies q) \lor (t \implies p) \qquad \lor\text{i}_2:34
        } \\
        \boxed{
            \underline{36\ q \qquad \text{assumption}} \\
            \boxed{
                \underline{37\ s \qquad \text{assumption}} \\
                38\ q
            } \\
            39\ s \implies q \qquad \implies\text{i}:37-38 \\
            40\ (s \implies q) \lor (t \implies p) \qquad \lor\text{i}_1:39
        } \\
        41\ (s \implies q) \lor (t \implies p) \qquad \lor\text{e}:29,30-35,36-40
    } \\
    42\ (s \implies q) \lor (t \implies p) \qquad \lor\text{e}:1,2-21,22-41
}$

5.
$\boxed{
    1\ (p \land q) \implies r \qquad \text{premise} \\
    2\ r \implies s \qquad \text{premise} \\
    \underline{3\ q \land \lnot s \qquad \text{premise}} \\
    4\ \lnot s \qquad \land\text{e}_2:3 \\
    5\ \lnot r \qquad \text{MT}:2,4 \\
    6\ \lnot(p \land q) \qquad \text{MT}:1,5 \\
    \boxed{
        \underline{7\ p \qquad \text{assumption}} \\
        8\ q \qquad \land\text{e}_1:3 \\
        9\ p \land q \qquad \land\text{i}:7,8 \\
        10\ \bot \qquad \lnot\text{e}:9,6
    } \\
    11\ \lnot p \qquad \lnot\text{i}:7-10
}$
