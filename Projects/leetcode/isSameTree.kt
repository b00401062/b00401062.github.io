package leetcode

fun isSameTree(p: TreeNode?, q: TreeNode?): Boolean {
    return when {
        p == null && q == null -> true
        (p == null) xor (q == null) || p!!.`val` != q!!.`val` -> false
        else -> isSameTree(p.left, q.left) && isSameTree(p.right, q.right)
    }
}
