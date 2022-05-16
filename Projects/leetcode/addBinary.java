package leetcode

import kotlin.math.max

fun addBinary(a: String, b: String): String {
    val res = StringBuilder()
    var carry = 0
    val maxlen = max(a.length, b.length)
    val a = String(CharArray(maxlen - a.length) { '0' }) + a
    val b = String(CharArray(maxlen - b.length) { '0' }) + b
    assert(a.length == b.length)
    for ((ca, cb) in (a zip b).reversed()) {
        val da = ca - '0'
        val db = cb - '0'
        val sum = (da + db + carry).toString(2)
        carry = sum.length - 1
        res.append(sum.last())
    }
    if (carry == 1) {
        res.append('1')
    }
    return res.reverse().toString()
}
