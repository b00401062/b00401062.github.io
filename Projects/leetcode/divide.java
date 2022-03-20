package leetcode

import kotlin.math.abs

fun divide(dividend: Int, divisor: Int): Int {
    if (dividend == Int.MIN_VALUE && divisor == -1)
        return Int.MAX_VALUE
    val sign = if ((dividend > 0) xor (divisor > 0)) -1 else 1
    var dvd = abs(dividend.toLong())
    val dvs = abs(divisor.toLong())
    var quotient = 0
    while (dvd >= dvs) {
        dvd -= dvs
        quotient++
    }
    return sign * quotient
}
