package leetcode

fun binarySearch(v: IntArray, k: Int): Int {
    var lt = 0
    var rt = v.size
    var md = (lt + rt) / 2
    while (lt < rt) {
        if (k < v[md]) rt = md else if (k == v[md]) return md else lt = md + 1
        md = (lt + rt) / 2
    }
    return -1 - md
}
