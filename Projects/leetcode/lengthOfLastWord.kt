package leetcode

fun lengthOfLastWord(s: String): Int {
    var isalpha = false
    var lt = -1
    var rt = -1
    for (i in s.lastIndex downTo 0) {
        if (s[i] != ' ' && !isalpha) {
            rt = i
            isalpha = true
        } else if (s[i] == ' ' && isalpha) {
            lt = i
            break
        }
    }
    return rt - lt
}
