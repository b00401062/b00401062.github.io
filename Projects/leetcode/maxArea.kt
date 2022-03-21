package leetcode

import kotlin.math.max
import kotlin.math.min

fun maxArea(height: IntArray): Int {
    var l = 0
    var r = height.lastIndex
    var a = (r - l) * min(height[l], height[r])
    while (l < r) {
        when {
            height[l] < height[r] -> l++
            else -> r--
        }
        a = max(a, (r - l) * min(height[l], height[r]))
    }
    return a
}
