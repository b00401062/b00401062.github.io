package leetcode

import kotlin.math.min

fun coinChange(coins: IntArray, amount: Int): Int {
    val cache = IntArray(amount + 1) { Int.MAX_VALUE }
    cache[0] = 0
    for (coin in coins) {
        for (i in coin..amount) {
            if (cache[i - coin] == Int.MAX_VALUE) continue
            cache[i] = min(cache[i - coin] + 1, cache[i])
        }
    }
    return if (cache[amount] == Int.MAX_VALUE) -1 else cache[amount]
}
