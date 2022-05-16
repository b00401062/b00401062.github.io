package leetcode

fun jump(nums: IntArray): Int {
    val n = nums.size
    if (n == 1) return 0
    var currJump = 0
    var nextMaxReach = 0
    var currMaxReach = 0
    for (i in 0 until n) {
        nextMaxReach = Math.max(nextMaxReach, i + nums[i])
        if (nextMaxReach >= n - 1) break
        if (i == currMaxReach) {
            currJump++
            currMaxReach = nextMaxReach
        }
    }
    return currJump + 1
}
