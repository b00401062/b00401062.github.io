package leetcode

fun generateMatrix(n: Int): Array<IntArray> {
    val a = Array(n) { IntArray(n) }
    var r = 0
    var c = 0
    val dr: IntArray = intArrayOf(0, 1, 0, -1)
    val dc: IntArray = intArrayOf(1, 0, -1, 0)
    var d = 0
    var k = 1
    for (i in 0 until n * n) {
        a[r][c] = k++
        val nr = r + dr[d]
        val nc = c + dc[d]
        if (nc >= 0 && nr >= 0 && nc < n && nr < n && a[nr][nc] == 0) {
            r = nr
            c = nc
        } else {
            d = (d + 1) % 4
            r += dr[d]
            c += dc[d]
        }
    }
    return a
}
