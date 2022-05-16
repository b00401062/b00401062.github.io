package leetcode

private fun construct(nums: IntArray, lt: Int, rt: Int): TreeNode? {
    val md = (lt + rt) / 2
    return if (lt >= rt) null else TreeNode(
        nums[md],
        construct(nums, lt, md),
        construct(nums, md + 1, rt)
    )
}

fun sortedArrayToBST(nums: IntArray): TreeNode? {
    return construct(nums, 0, nums.size)
}
