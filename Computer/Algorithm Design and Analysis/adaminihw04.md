## Mini Homework 4

1.
| |A|B|C|A|D|B|
|-|-|-|-|-|-|-|
|C|0|0|1|1|1|1|
|A|1|1|1|2|2|2|
|B|1|2|2|2|2|3|
|D|1|2|2|2|3|3|
|A|1|2|2|3|3|3|
|B|1|2|2|3|3|4|

2. Given two string $X$ and $Y$, the recursion is expressed as $$M_{i,j} = \begin{cases} 1 + M_{i-1,j-1} \text{ if } X_i=Y_j \\ \max\{M_{i-1,j-1}, M_{i-1,j}, M_{i,j-1} \} \text{ if } X_i\ne Y_j \end{cases}$$On finishing filling in the table, backtracking is performed from the bottom-right corner until hitting the left margin or top margin. The procedure is as follows (The resulting subsequence is CADB):
    - If $X_i=Y_j$: go upper left and print the character.
    - Otherwise:
        - If $M_{i,j}=M_{i-1,j}$: go upper left.
        - Else if $M_{i,j}=M_{i-1,j}$: go up.
        - Else if $M_{i,j}=M_{i,j-1}$: go left.

| |A|B|C|A|D|B|
|-|-|-|-|-|-|-|
|C|||↖||||
|A||||↖|||
|B||||&uarr;|||
|D|||||↖||
|A|||||&uarr;||
|B||||||↖|
