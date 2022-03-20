package leetcode

fun romanToInt(s: String): Int {
    val map = mapOf(
        "I" to 1,
        "IV" to 4,
        "V" to 5,
        "IX" to 9,
        "X" to 10,
        "XL" to 40,
        "L" to 50,
        "XC" to 90,
        "C" to 100,
        "CD" to 400,
        "D" to 500,
        "CM" to 900,
        "M" to 1000
    )
    var i = 0
    var num = 0
    while (i < s.length) {
        if (i < s.lastIndex && s.substring(i, i + 2) in map.keys) {
            num += map[s.substring(i, i + 2)]!!
            i += 2
        } else {
            num += map[s.substring(i, i + 1)]!!
            i++
        }
    }
    return num
}
