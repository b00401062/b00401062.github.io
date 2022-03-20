package leetcode

fun nextPermutation(nums: IntArray): Unit {
    var l = nums.lastIndex - 1
    while (l >= 0 && nums[l] >= nums[l + 1])
        l--
    if (l == -1) {
        nums.reverse()
        return
    }
    var r = l + 1
    while (r < nums.size && nums[l] < nums[r])
        r++
    r--
    nums[l] = nums[r].also { nums[r] = nums[l] }
    r = nums.lastIndex
    l++
    while (l < r) {
        nums[l] = nums[r].also { nums[r] = nums[l] }
        l++
        r--
    }
}
