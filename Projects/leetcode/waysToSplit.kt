package leetcode

private const val MODULO = 1000000007

fun waysToSplit(nums: IntArray): Int {
    val n = nums.size
    var count = 0
    for (i in 1 until n) nums[i] += nums[i - 1]
    var i = 0
    var minJ = 1
    var maxJ = 1
    while (i < n - 2) {
        minJ = Math.max(minJ, i + 1)
        while (minJ < n - 1 && nums[minJ] < nums[i] * 2) ++minJ
        maxJ = Math.max(maxJ, minJ)
        while (maxJ < n - 1 && nums[maxJ] - nums[i] <= nums[n - 1] - nums[maxJ]) ++maxJ
        count = (count + maxJ - minJ) % MODULO
        ++i
    }
    return count
}
