package leetcode

fun countAndSay(n: Int): String {
    var s = "1"
    repeat(n - 1) {
        val res = StringBuilder()
        var i = 0
        while (i < s.length) {
            var count = 1
            while (i + 1 < s.length && s[i] == s[i + 1]) {
                i++
                count++
            }
            res.append(count).append(s[i])
            i++
        }
        s = res.toString()
    }
    return s
}
