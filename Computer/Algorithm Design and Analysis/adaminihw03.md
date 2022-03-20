## Mini Homework 3

This is a D&C algorithm. In terms of the recursion tree:
- The number of levels: The `f` is recursively called until `l>r`. The number of levels is exactly $\lg N$ since the range of `r-l` is halved for each level downward.
- The amount of work at each level: The amount of work is independent of $l$ and $r$. The `for` loop at line 5 goes from `bl` to `br` and randomly assigns a value to `bmid` as a cut point. However, the loops at the same level, altogether, essentially loops through $[1,M]$ exactly one. Therefore, the amount of work at each level is exactly $M$.

To sum up, the time complexity is the number of levels &times; the amount of work at each level = $M\lg N$
