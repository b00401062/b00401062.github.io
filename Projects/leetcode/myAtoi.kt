package leetcode

fun myAtoi(str: String): Int {
    val trimmed = str.trim()
    if (trimmed.isEmpty() || trimmed[0] !in "0123456789+-")
        return 0
    val sign = if (trimmed[0] == '-') -1 else 1
    var value = 0
    var valid = false
    for (i in trimmed.indices) {
        if (i == 0 && trimmed[0] in "+-")
            continue
        if (trimmed[i] !in "0123456789")
            break
        val digit = trimmed[i] - '0'
        if (
            value > Int.MAX_VALUE / 10
            || value == Int.MAX_VALUE / 10 && digit > 7
        ) return Int.MAX_VALUE
        if (
            value < Int.MIN_VALUE / 10
            || value == Int.MIN_VALUE / 10 && digit > 8
        ) return Int.MIN_VALUE
        value = value * 10 + digit * sign
        valid = true
    }
    return if (valid) value else 0
}
