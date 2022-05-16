package leetcode

fun maximumScore(a: Int, b: Int, c: Int): Int {
    val min = Math.min(Math.min(a, b), c)
    val max = Math.max(Math.max(a, b), c)
    val mid = a xor b xor c xor min xor max
    return Math.min(max, min + mid) + Math.max(min + mid - max, 0) / 2
}
