package leetcode

fun canPartition(nums: IntArray): Boolean {
    val sum = nums.sum()
    if (sum % 2 == 1) return false
    val target = sum / 2
    val cache = BooleanArray(target + 1)
    cache[0] = true
    for (i in 1..nums.size) {
        val num = nums[i - 1]
        for (j in target downTo num) {
            cache[j] = cache[j] || cache[j - num]
        }
    }
    return cache[target]
}
