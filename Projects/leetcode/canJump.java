package leetcode

import kotlin.math.max

fun canJump(nums: IntArray): Boolean {
    var maxIndex: Int = 0
    for (curIndex in nums.indices) {
        if (curIndex > maxIndex) return false
        maxIndex = max(maxIndex, curIndex + nums[curIndex])
    }
    return true
}
