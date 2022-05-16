package leetcode

fun isValidSudoku(board: Array<CharArray>): Boolean {
    val col = Array(9) { BooleanArray(9) }
    val row = Array(9) { BooleanArray(9) }
    val box = Array(9) { BooleanArray(9) }
    for (i in 0 until 9) {
        for (j in 0 until 9) {
            if (board[i][j] != '.') {
                val num = board[i][j] - '1'
                val boxIndex = i / 3 * 3 + j / 3
                if (col[j][num] || row[i][num] || box[boxIndex][num])
                    return false
                col[j][num] = true
                row[i][num] = true
                box[boxIndex][num] = true
            }
        }
    }
    return true
}
