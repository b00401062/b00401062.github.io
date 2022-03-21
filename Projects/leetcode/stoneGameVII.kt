package leetcode

object StoneGameVII {
    fun stoneGameVII(stones: IntArray): Int {
        val n = stones.size
        val cache = Array(n + 1) { IntArray(n + 1) }
        var len = 2 + n % 2
        while (len <= n) {
            var lt = 0
            var rt = lt + len
            while (rt <= n) {
                cache[lt][rt] = Math.max(
                    Math.min(
                        stones[lt + 1] + cache[lt + 2][rt],
                        stones[rt - 1] + cache[lt + 1][rt - 1]
                    ),
                    Math.min(
                        stones[lt] + cache[lt + 1][rt - 1],
                        stones[rt - 2] + cache[lt][rt - 2]
                    )
                )
                lt++
                rt++
            }
            len += 2
        }
        return cache[0][n]
    }
}