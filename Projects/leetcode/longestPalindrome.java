package leetcode

private fun check(s: String, l: Int, r: Int): String {
    var l = l
    var r = r
    while (l >= 0 && r < s.length && s[l] == s[r]) {
        l--
        r++
    }
    return s.substring(l + 1, r)
}

fun longestPalindrome(s: String): String {
    var palindrome = ""
    for (i in s.indices) {
        val candidates = arrayOf(
            palindrome,
            check(s, i - 1, i + 1),
            check(s, i, i + 1)
        )
        palindrome = candidates.maxByOrNull(String::length)!!
    }
    return palindrome
}
