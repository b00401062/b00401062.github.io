package leetcode

fun multiply(num1: String, num2: String): String {
    if (num1 == "0" || num2 == "0") return "0"
    val product = IntArray(num1.length + num2.length - 1)
    num1.reversed().forEachIndexed { i1, c1 ->
        num2.reversed().forEachIndexed { i2, c2 ->
            product[i1 + i2] += (c1 - '0') * (c2 - '0')
        }
    }
    (0 until product.lastIndex).forEach {
        product[it + 1] += product[it] / 10
        product[it] %= 10
    }
    return product.reversed().joinToString("", transform = Int::toString).trimStart('0')
}
