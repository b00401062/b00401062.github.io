package leetcode

fun minPathSum(grid: Array<IntArray>): Int {
    val nrow = grid.size
    val ncol = grid[0].size
    val dp = Array(nrow + 1) { IntArray(ncol + 1) }
    for (i in 2..nrow) {
        dp[i][0] = Int.MAX_VALUE
    }
    for (j in 2..ncol) {
        dp[0][j] = Int.MAX_VALUE
    }
    for (i in 0 until nrow) {
        for (j in 0 until ncol) {
            dp[i + 1][j + 1] = Math.min(dp[i][j + 1], dp[i + 1][j]) + grid[i][j]
        }
    }
    return dp[nrow][ncol]
}
