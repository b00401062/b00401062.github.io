package leetcode

import java.util.*

fun mostCompetitive(nums: IntArray, k: Int): IntArray {
    val stack = Stack<Int>()
    for (i in nums.indices) {
        val num = nums[i]
        while (!stack.isEmpty() && stack.peek() > num && k - stack.size < nums.size - i) {
            stack.pop()
        }
        if (stack.size < k) {
            stack.push(num)
        }
    }
    return stack.stream().mapToInt { obj: Int -> obj }.toArray()
}
