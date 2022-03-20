## Mini Homework 7

1. 
    - Part A: `if determine(y, reverse(type)) = False: return False`
    - Part B: `return False`
    - Part C: `return True`
2. 
    - Correctness:
        - Part A: If type[y] is unknown, then y should be assigned the reverse of type[x] and then we check to see if the assignment is valid.
        - Part B: If at some time, type[y] is identical to type[x], then this violates that an edge should connect two students of different.
        - Part C: If it passes all of the test, then all of the assignments are correct.
    - Time complexity: The algorithm traverses the graph with DFS. Every edge and vertex is traversed exactly once.
