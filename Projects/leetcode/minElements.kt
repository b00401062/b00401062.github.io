package leetcode

fun minElements(nums: IntArray, limit: Int, goal: Int): Int {
    var sum: Long = 0
    for (num in nums) {
        sum += num.toLong()
    }
    val deficit = goal - sum
    return Math.abs(deficit / limit).toInt() + if (deficit % limit == 0L) 0 else 1
}
