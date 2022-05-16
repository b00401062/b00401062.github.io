package leetcode

import java.util.*

private class Bar(val i: Int, val height: Int)

private fun insert(stack: Stack<Bar>, i: Int, height: Int, maxArea: Int): Int {
    var maxArea = maxArea
    var startIndex = i
    while (stack.peek().height >= height) {
        val bar = stack.pop()
        startIndex = bar.i
        maxArea = Math.max(maxArea, bar.height * (i - startIndex))
    }
    stack.push(Bar(startIndex, height))
    return maxArea
}

fun largestRectangleArea(heights: IntArray): Int {
    val stack = Stack<Bar>()
    stack.push(Bar(-1, -1))
    var maxArea = 0
    for (i in heights.indices) {
        maxArea = insert(stack, i, heights[i], maxArea)
    }
    maxArea = insert(stack, heights.size, 0, maxArea)
    return maxArea
}
