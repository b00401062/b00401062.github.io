package leetcode

fun createTargetArray(nums: IntArray, index: IntArray): IntArray {
    val res = mutableListOf<Int>()
    for (i in nums.indices) {
        res.add(index[i], nums[i])
    }
    return res.stream().mapToInt { obj: Int -> obj }.toArray()
}
