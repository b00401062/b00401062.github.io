package leetcode

val map = mapOf(
    '2' to "abc",
    '3' to "def",
    '4' to "ghi",
    '5' to "jkl",
    '6' to "mno",
    '7' to "pqrs",
    '8' to "tuv",
    '9' to "wxyz"
)

fun letterCombinations(digits: String): List<String> {
    if (digits.isEmpty()) return emptyList()
    val suffixes = letterCombinations(digits.substring(1))
    if (suffixes.isEmpty())
        return map[digits[0]]!!.map(Char::toString)
    val list = mutableListOf<String>()
    for (c in map[digits[0]]!!)
        for (suffix in suffixes)
            list.add(c.toString() + suffix)
    return list
}
