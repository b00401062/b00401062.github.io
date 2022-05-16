package leetcode

fun factorial(n: Int): Int {
    return if (n == 1) 1 else n * factorial(n - 1)
}

fun getPermutation(n: Int, k: Int): String {
    var n = n
    var k = k
    if (n == 1) {
        return "1"
    }
    val flag = BooleanArray(n)
    val res = StringBuilder()
    val len = n
    while (n >= 1) {
        val num = factorial(n)
        var pos = (k - 1) / (num / n)
        for (i in 0 until len) {
            if (flag[i]) continue
            pos--
            if (pos < 0) {
                flag[i] = true
                res.append((i + 1).toString())
                break
            }
        }
        k = (k - 1) % (num / n) + 1
        n--
    }
    return res.toString()
}
