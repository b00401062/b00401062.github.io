package leetcode

fun moveZeroes(nums: IntArray): Unit {
    var non_zero_count = 0
    for (num in nums) {
        if (num == 0) continue
        nums[non_zero_count] = num
        non_zero_count += 1
    }
    for (idx in non_zero_count until nums.size) {
        nums[idx] = 0
    }
}
