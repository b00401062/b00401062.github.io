package leetcode

import java.util.*

fun find132pattern(nums: IntArray): Boolean {
    val n = nums.size
    val stack = Stack<Range>()
    stack.push(Range(Int.MAX_VALUE, Int.MAX_VALUE))
    for (num in nums) {
        val min = Math.min(num, stack.peek().min)
        while (stack.peek().max <= num) {
            stack.pop()
        }
        val range = stack.peek()
        if (num <= range.min) {
            stack.push(Range(min, num))
        } else if (range.min < num && num < range.max) {
            return true
        }
    }
    return false
}

private class Range(val min: Int, val max: Int)
