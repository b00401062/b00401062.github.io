package leetcode

fun reformatNumber(number: String): String {
    val chars = number.replace("-".toRegex(), "").replace(" ".toRegex(), "").toCharArray()
    val n = chars.size
    val sb = StringBuilder()
    var i = 0
    while (i < n) {
        sb.append(chars, i, Math.min(3, n - i))
        sb.append("-")
        i += 3
    }
    sb.deleteCharAt(sb.length - 1)
    if (n % 3 == 1) {
        sb.delete(sb.length - 5, sb.length)
        sb.append(chars, n - 4, 2)
        sb.append("-")
        sb.append(chars, n - 2, 2)
    }
    return sb.toString()
}
