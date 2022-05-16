package leetcode

fun search(nums: IntArray, target: Int): Int {
    val p = nums.size / 2
    if (nums.size < 32)
        return nums.indexOf(target)
    else if (target == nums[0])
        return 0
    else if (target == nums[p])
        return p
    if ((target < nums[0]) xor (target < nums[p]) xor (nums[0] > nums[p])) {
        val i = search(nums.sliceArray(1 until p), target)
        return if (i == -1) -1 else 1 + i
    } else {
        val i = search(nums.sliceArray(p + 1 until nums.size), target)
        return if (i == -1) -1 else p + 1 + i
    }
}
