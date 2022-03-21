package leetcode

import java.lang.StringBuilder

fun getSmallestString(n: Int, k: Int): String {
    var k = k
    val sb = StringBuilder()
    for (i in n - 1 downTo 0) {
        val c = Math.min(26, k - i)
        k -= c
        sb.append(('a'.code + c - 1).toChar())
    }
    return sb.reverse().toString()
}
