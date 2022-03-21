package leetcode

import java.util.Stack

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

private fun largestRectangleArea(heights: IntArray): Int {
    val stack = Stack<Bar>()
    stack.push(Bar(-1, -1))
    var maxArea = 0
    for (i in heights.indices) {
        maxArea = insert(stack, i, heights[i], maxArea)
    }
    maxArea = insert(stack, heights.size, 0, maxArea)
    return maxArea
}

fun maximalRectangle(matrix: Array<CharArray>): Int {
    val I = matrix.size
    if (I == 0) return 0
    val J = matrix[0].size
    val heights = IntArray(J)
    var maxArea = 0
    for (i in 0 until I) {
        val row = matrix[i]
        for (j in 0 until J) {
            heights[j] = if (row[j] == '0') 0 else heights[j] + 1
        }
        maxArea = Math.max(maxArea, largestRectangleArea(heights))
    }
    return maxArea
}

private class Bar internal constructor(val i: Int, val height: Int)
