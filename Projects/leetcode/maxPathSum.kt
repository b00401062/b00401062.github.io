package leetcode

private fun traverse(root: TreeNode?, max: Maximum): Int {
    if (root == null) return 0
    val maxLt = Math.max(0, traverse(root.left, max))
    val maxRt = Math.max(0, traverse(root.right, max))
    max.compareAndSet(root.`val` + maxLt + maxRt)
    return root.`val` + Math.max(maxLt, maxRt)
}

fun maxPathSum(root: TreeNode?): Int {
    val max = Maximum()
    traverse(root, max)
    return max.value
}

private class Maximum {
    var value = Int.MIN_VALUE
    fun compareAndSet(value: Int) {
        this.value = Math.max(this.value, value)
    }
}
