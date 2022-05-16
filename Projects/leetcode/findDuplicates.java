package leetcode

fun findDuplicates(nums: IntArray): List<Int> {
    val duplicates: MutableList<Int> = ArrayList()
    for (i in nums.indices) {
        val num = Math.abs(nums[i]) - 1
        if (nums[num] < 0) duplicates.add(num + 1) else nums[num] *= -1
    }
    return duplicates
}
