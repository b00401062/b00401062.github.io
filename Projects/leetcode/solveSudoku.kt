package leetcode

private fun solve(
    board: Array<CharArray>,
    col: Array<BooleanArray>,
    row: Array<BooleanArray>,
    box: Array<BooleanArray>,
    n: Int
): Boolean {
    val i = n / 9
    val j = n % 9
    if (n == 81)
        return true
    if (board[i][j] != '.')
        return solve(board, col, row, box, n + 1)
    val boxIndex = i / 3 * 3 + j / 3
    val candidates = (0..8).filter { !(col[j][it] || row[i][it] || box[boxIndex][it]) }
    for (candidate in candidates) {
        board[i][j] = '1' + candidate
        col[j][candidate] = true
        row[i][candidate] = true
        box[boxIndex][candidate] = true
        if (solve(board, col, row, box, n + 1))
            return true
        board[i][j] = '.'
        col[j][candidate] = false
        row[i][candidate] = false
        box[boxIndex][candidate] = false
    }
    return false
}

fun solveSudoku(board: Array<CharArray>): Unit {
    val col = Array(9) { BooleanArray(9) }
    val row = Array(9) { BooleanArray(9) }
    val box = Array(9) { BooleanArray(9) }
    for (i in 0 until 9) {
        for (j in 0 until 9) {
            if (board[i][j] != '.') {
                val num = board[i][j] - '1'
                val boxIndex = i / 3 * 3 + j / 3
                col[j][num] = true
                row[i][num] = true
                box[boxIndex][num] = true
            }
        }
    }
    solve(board, col, row, box, 0)
}
