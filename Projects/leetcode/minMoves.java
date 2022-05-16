package leetcode

fun minMoves(nums: IntArray, limit: Int): Int {
    val n = nums.size
    val changes = IntArray(2 * limit + 2)
    for (i in 0 until n / 2) {
        val ltNum = nums[i]
        val rtNum = nums[n - i - 1]
        val maxNum = Math.max(ltNum, rtNum)
        val minNum = Math.min(ltNum, rtNum)
        changes[minNum + 1] -= 1
        changes[ltNum + rtNum] -= 1
        changes[ltNum + rtNum + 1] += 1
        changes[maxNum + limit + 1] += 1
    }
    var minMoves = n
    var numMoves = n
    for (i in 2..2 * limit) {
        numMoves += changes[i]
        minMoves = Math.min(minMoves, numMoves)
    }
    return minMoves
}
