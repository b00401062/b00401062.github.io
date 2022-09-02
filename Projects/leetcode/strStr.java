package leetcode

private fun compile(needle: String): IntArray {
    val table = IntArray(needle.length)
    table[0] = -1
    var k = -1
    for (i in 1 until needle.length) {
        while (k >= 0 && needle[k + 1] != needle[i])
            k = table[k]
        if (needle[k + 1] == needle[i])
            k++
        table[i] = k
    }
    return table
}

fun strStr(haystack: String, needle: String): Int {
    if (needle.isEmpty())
        return 0
    val table = compile(needle)
    var k = -1
    for (i in haystack.indices) {
        while (k >= 0 && needle[k + 1] != haystack[i])
            k = table[k]
        if (needle[k + 1] == haystack[i])
            k++
        if (k == needle.lastIndex)
            return i - k
    }
    return -1
}
