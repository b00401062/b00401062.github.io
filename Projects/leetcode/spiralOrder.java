package leetcode

fun spiralOrder(matrix: Array<IntArray>): List<Int> {
    val list: MutableList<Int> = mutableListOf()
    if (matrix.isEmpty()) {
        return list
    }
    var m: Int = matrix.size - 1
    var n: Int = matrix[0].size - 1
    var r: Int = 0
    var c: Int = 0
    while (r <= m && c <= n) {
        for (j in r..n) {
            list.add(matrix[r][j])
        }
        r++
        for (i in r..m) {
            list.add(matrix[i][n])
        }
        n--
        if (r <= m) {
            for (j in n downTo c) {
                list.add(matrix[m][j])
            }
            m--
        }
        if (c <= n) {
            for (i in m downTo r) {
                list.add(matrix[i][c])
            }
            c++
        }
    }
    return list
}