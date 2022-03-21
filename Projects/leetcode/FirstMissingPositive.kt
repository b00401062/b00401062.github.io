package leetcode

fun firstMissingPositive(nums: IntArray): Int {
    val n = nums.size
    for (i in 0 until n) {
        if (nums[i] <= 0) {
            nums[i] = Int.MAX_VALUE
        }
    }
    for (num in nums) {
        val pos = Math.abs(num) - 1
        if (pos >= n) continue
        if (nums[pos] > 0) {
            nums[pos] = -nums[pos]
        }
    }
    for (i in 0 until n) {
        if (nums[i] > 0) {
            return i + 1
        }
    }
    return n + 1
}
