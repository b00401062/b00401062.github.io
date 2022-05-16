package leetcode

fun check(nums: IntArray): Boolean {
    var isFlipped = false
    for (i in 1 until nums.size) {
        isFlipped = if (nums[i - 1] <= nums[i]) continue else if (isFlipped) return false else true
    }
    return nums[0] >= nums[nums.size - 1]
}
