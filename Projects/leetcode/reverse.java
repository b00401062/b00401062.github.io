package leetcode

fun reverse(x: Int): Int {
    var x = x
    var y = 0
    while (x != 0) {
        val pop = x % 10
        x /= 10
        if (
            y > Int.MAX_VALUE / 10
            || y == Int.MAX_VALUE / 10 && pop > 7
            || y < Int.MIN_VALUE / 10
            || y == Int.MIN_VALUE / 10 && pop < -8
        ) return 0
        y = y * 10 + pop
    }
    return y
}
