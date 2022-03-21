package leetcode

import java.util.HashSet

fun maximumUniqueSubarray(nums: IntArray): Int {
    var maxScore = 0
    var curScore = 0
    var head = 0
    val set: MutableSet<Int> = HashSet()
    for (tail in nums.indices) {
        val num = nums[tail]
        if (set.contains(num)) {
            maxScore = Math.max(maxScore, curScore)
            while (nums[head] != num) {
                val removedNum = nums[head++]
                set.remove(removedNum)
                curScore -= removedNum
            }
            head++
        } else {
            set.add(num)
            curScore += num
        }
    }
    maxScore = Math.max(maxScore, curScore)
    return maxScore
}
