package leetcode

fun findDisappearedNumbers(nums: IntArray): List<Int> {
    val disappearedNumbers: MutableList<Int> = ArrayList()
    for (num in nums) {
        val i = Math.abs(num) - 1
        if (nums[i] > 0) nums[i] *= -1
    }
    for (i in nums.indices) {
        if (nums[i] < 0) continue
        disappearedNumbers.add(i + 1)
    }
    return disappearedNumbers
}
