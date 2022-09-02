package leetcode

fun myPow(x: Double, n: Int): Double {
    return when (n) {
        0 -> 1.0
        1 -> x
        -1 -> 1 / x
        else -> {
            val half = myPow(x, n / 2)
            myPow(x, n % 2) * half * half
        }
    }
}
