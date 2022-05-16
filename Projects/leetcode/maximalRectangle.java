package leetcode

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
