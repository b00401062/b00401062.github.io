package leetcode

import kotlin.math.abs

fun threeSumClosest(nums: IntArray, target: Int): Int {
    var delta = nums[0] + nums[1] + nums[2] - target
    nums.sort()
    for (i in 0 until nums.size - 2) {
        var l = i + 1
        var r = nums.lastIndex
        while (l < r) {
            val sum = nums[i] + nums[l] + nums[r]
            if (sum <= target - abs(delta))
                l++
            else if (sum >= target + abs(delta))
                r--
            else {
                delta = sum - target
                if (delta == 0) return target
            }
        }
    }
    return target + delta
}
