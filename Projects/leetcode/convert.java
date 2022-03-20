package leetcode

fun convert(s: String, numRows: Int): String {
    if (numRows == 1)
        return s
    val y = CharArray(s.length)
    var i = 0
    for (r in 0 until numRows) {
        val jumps = arrayOf((numRows - r - 1) * 2, r * 2)
        var p = r
        var j = 0
        while (p < s.length) {
            y[i++] = s[p]
            if (jumps[j] == 0)
                j = 1 - j
            p += jumps[j]
            j = 1 - j
        }
    }
    return String(y)
}
