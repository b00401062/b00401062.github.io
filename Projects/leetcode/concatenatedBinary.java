package leetcode

private const val MODULO = 1000000007

private fun leftShift(n: Int, bitShift: Int): Int {
    var n = n
    for (i in 0 until bitShift) {
        n = (n shl 1) % MODULO
    }
    return n
}

fun concatenatedBinary(n: Int): Int {
    var numerator = 0
    for (i in 1..n) {
        val bitShift = (Math.log(i.toDouble()) / Math.log(2.0)).toInt() + 1
        numerator = (leftShift(numerator, bitShift) + i) % MODULO
    }
    return numerator
}
