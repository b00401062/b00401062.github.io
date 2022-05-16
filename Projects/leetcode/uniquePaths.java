package leetcode

import kotlin.math.min

private fun choose(n: Int, k: Int): Int {
    var res = 1L
    for (i in 0 until k) {
        res = res * (n - i) / (i + 1)
    }
    return res.toInt()
}

fun uniquePaths(m: Int, n: Int): Int {
    return choose(m + n - 2, min(m - 1, n - 1))
}
