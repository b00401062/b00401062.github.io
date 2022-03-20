package leetcode

fun searchInsert(nums: IntArray, target: Int): Int {
    if (nums.isEmpty())
        return 0
    else if (nums.size == 1)
        return if (target <= nums[0]) 0 else 1
    val mid = nums.size / 2
    if (target < nums[mid])
        return searchInsert(nums.sliceArray(0 until mid), target)
    else if (target == nums[mid])
        return mid
    else
        return mid + searchInsert(nums.sliceArray(mid until nums.size), target)
}
