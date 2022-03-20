package leetcode

fun uniquePathsWithObstacles(obstacleGrid: Array<IntArray>): Int {
    val nrow = obstacleGrid.size
    val ncol = obstacleGrid[0].size
    val dp = Array<IntArray>(nrow + 1) { IntArray(ncol + 1) }
    dp[0][1] = 1
    for (i in 0 until nrow) {
        for (j in 0 until ncol) {
            dp[i + 1][j + 1] = when (obstacleGrid[i][j]) {
                0 -> dp[i][j + 1] + dp[i + 1][j]
                1 -> 0
                else -> throw IllegalArgumentException()
            }
        }
    }
    return dp.last().last()
}
