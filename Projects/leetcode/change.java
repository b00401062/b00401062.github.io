package leetcode

fun change(amount: Int, coins: IntArray): Int {
    val cache = IntArray(amount + 1)
    cache[0] = 1
    for (coin in coins) {
        for (i in coin..amount) {
            cache[i] += cache[i - coin]
        }
    }
    return cache[amount]
}
