package leetcode

internal class MinDistance {
    private inner class Cache {
        var diag = 0
        var dist = 0
        fun update(diag: Int, dist: Int) {
            this.diag = diag
            this.dist = dist
        }
    }

    fun minDistance(word1: String, word2: String): Int {
        val dp = IntArray(word2.length + 1)
        for (j in 0..word2.length) {
            dp[j] = j
        }
        val cache: Cache = Cache()
        for (i in 0 until word1.length) {
            val c1 = word1[i]
            cache.update(dp[0], i + 1)
            dp[0] = cache.dist
            for (j in 0 until word2.length) {
                val c2 = word2[j]
                cache.update(
                    dp[j + 1],
                    Math.min(
                        cache.diag + if (c1 == c2) 0 else 1,
                        Math.min(dp[j], dp[j + 1]) + 1
                    )
                )
                dp[j + 1] = cache.dist
            }
        }
        return dp[word2.length]
    }
}