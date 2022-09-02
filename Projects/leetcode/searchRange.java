package leetcode

private fun searchLtMargin(nums: IntArray, target: Int): Int {
    if (nums.isEmpty())
        return -1
    var lt = -1
    var rt = nums.size
    while (lt + 1 < rt) {
        val mid = (lt + rt) / 2
        if (nums[mid] >= target)
            rt = mid
        else
            lt = mid
    }
    return if (rt < nums.size && nums[rt] == target) rt else -1
}

private fun searchRtMargin(nums: IntArray, target: Int): Int {
    if (nums.isEmpty())
        return -1
    var lt = -1
    var rt = nums.size
    while (lt + 1 < rt) {
        val mid = (lt + rt) / 2
        if (nums[mid] <= target)
            lt = mid
        else
            rt = mid
    }
    return if (lt >= 0 && nums[lt] == target) lt else -1
}

fun searchRange(nums: IntArray, target: Int): IntArray {
    return intArrayOf(
        searchLtMargin(nums, target),
        searchRtMargin(nums, target)
    )
}
