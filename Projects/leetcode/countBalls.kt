package leetcode

import java.util.HashMap
import java.util.function.IntUnaryOperator
import java.util.function.ToIntFunction

object CountBalls {
    fun countBalls(lowLimit: Int, highLimit: Int): Int {
        val counts: MutableMap<Int, Int> = HashMap()
        for (i in lowLimit..highLimit) {
            val sum = Integer.toString(i).chars().map { c: Int -> c - '0'.code }.sum()
            counts[sum] = counts.getOrDefault(sum, 0) + 1
        }
        return counts.values.stream().mapToInt { c: Int? -> c!! }.max().asInt
    }
}