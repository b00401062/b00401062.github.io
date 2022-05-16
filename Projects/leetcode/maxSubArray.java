package leetcode

fun maxSubArray(nums: IntArray): Int {
    var maxSum = Int.MIN_VALUE
    var curSum = 0
    for (num in nums) {
        curSum = if (curSum >= 0) curSum + num else num
        maxSum = Math.max(curSum, maxSum)
    }
    return maxSum
}
