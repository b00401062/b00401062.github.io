package leetcode

fun lengthOfLongestSubstring(s: String): Int {
    var length = 0
    var substring = ""
    for (c in s) {
        substring = substring.substring(substring.indexOf(c) + 1) + c
        length = Math.max(length, substring.length)
    }
    return length
}
