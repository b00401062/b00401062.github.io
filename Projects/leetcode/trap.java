package leetcode

import kotlin.math.max
import kotlin.math.min

fun trap(height: IntArray): Int {
    var amount = 0
    val ltMax = IntArray(height.size)
    val rtMax = IntArray(height.size)
    (1 until height.size).forEach {
        ltMax[it] = max(ltMax[it - 1], height[it - 1])
        rtMax[height.lastIndex - it] = max(rtMax[height.size - it], height[height.size - it])
    }
    height.indices.forEach {
        val minMax = min(ltMax[it], rtMax[it])
        val diff = minMax - height[it]
        amount += if (diff > 0) diff else 0
    }
    return amount
}
