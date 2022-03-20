package leetcode

import kotlin.math.min
import kotlin.math.max

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
