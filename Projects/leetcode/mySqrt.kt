package leetcode

private fun myRecursiveSqrt(guess: Long, x: Int): Long {
    return if (guess * guess <= x && x < (guess + 1) * (guess + 1)) guess else myRecursiveSqrt(
        (guess + x / guess) / 2,
        x
    )
}

fun mySqrt(x: Int): Int {
    return if (x == 0) 0 else if (x == 1) 1 else myRecursiveSqrt((x / 2).toLong(), x).toInt()
}
