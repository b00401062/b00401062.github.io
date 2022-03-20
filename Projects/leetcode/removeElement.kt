package leetcode

fun removeElement(nums: IntArray, `val`: Int): Int {
    var count = 0
    for (num in nums)
        if (num != `val`)
            nums[count++] = num
    return count
}
