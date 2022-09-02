package leetcode

import kotlin.math.min

fun rotate(matrix: Array<IntArray>): Unit {
    val n = matrix.size
    for (i in 0 until n - 1) {
        for (j in 0..min(i, n - i - 2)) {
            val lt = matrix[i][j]
            val ur = matrix[j][n - i - 1]
            val rt = matrix[n - i - 1][n - j - 1]
            val lr = matrix[n - j - 1][i]
            matrix[i][j] = lr
            matrix[j][n - i - 1] = lt
            matrix[n - i - 1][n - j - 1] = ur
            matrix[n - j - 1][i] = rt
        }
    }
}
