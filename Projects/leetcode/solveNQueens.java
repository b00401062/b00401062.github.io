package leetcode

private fun putNQueens(
    N: Int,
    n: Int,
    cols: BooleanArray,
    dia1: BooleanArray,
    dia2: BooleanArray,
    sol: MutableList<Int>,
    sols: MutableList<List<String>>
) {
    if (n == N) {
        sols.add(sol.map {
            val row = CharArray(n) { '.' }
            row[it] = 'Q'
            row.joinToString("")
        })
        return
    }
    for (i in 0 until N) {
        if (cols[i] || dia1[n + i] || dia2[N + n - i - 1]) continue
        cols[i] = true
        dia1[n + i] = true
        dia2[N + n - i - 1] = true
        sol.add(i)
        putNQueens(N, n + 1, cols, dia1, dia2, sol, sols)
        cols[i] = false
        dia1[n + i] = false
        dia2[N + n - i - 1] = false
        sol.removeAt(n)
    }
}

fun solveNQueens(n: Int): List<List<String>> {
    if (n < 1) {
        return emptyList()
    }
    val cols = BooleanArray(n) { false }
    val dia1 = BooleanArray(2 * n - 1) { false }
    val dia2 = BooleanArray(2 * n - 1) { false }
    val sol: MutableList<Int> = mutableListOf()
    val sols: MutableList<List<String>> = mutableListOf()
    putNQueens(n, 0, cols, dia1, dia2, sol, sols)
    return sols
}