package leetcode

fun numberOfMatches(n: Int): Int {
    var n = n
    var number = 0
    while (n != 1) {
        number += n / 2
        n = (n - 1) / 2 + 1
    }
    return number
}
