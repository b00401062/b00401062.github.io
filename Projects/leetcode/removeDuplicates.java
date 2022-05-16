package leetcode

fun removeDuplicates(nums: IntArray): Int {
    if (nums.isEmpty()) return 0
    var count = 1
    var log = nums[0]
    repeat(nums.size) {
        if (nums[it] != log) {
            log = nums[it]
            nums[count] = log
            count++
        }
    }
    return count
}
