package leetcode

import java.util.Arrays

internal class NumTrees {
    private var cache = intArrayOf(
        1,
        1,
        2,
        5,
        14,
        42,
        132,
        429,
        1430,
        4862,
        16796,
        58786,
        208012,
        742900,
        2674440,
        9694845,
        35357670
    )

    private fun numCacheTrees(n: Int): Int {
        assert(cache.size > n)
        if (cache[n] != 0) {
            return cache[n]
        }
        var sol = 0
        for (i in 1..n) {
            sol += numCacheTrees(i - 1) * numCacheTrees(n - i)
        }
        return sol
    }

    fun numTrees(n: Int): Int {
        if (n >= cache.size) {
            cache = Arrays.copyOf(cache, n + 1)
        }
        cache[0] = 1
        return numCacheTrees(n)
    }
}