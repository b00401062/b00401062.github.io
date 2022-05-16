package leetcode

fun hasPathSum(root: TreeNode?, sum: Int): Boolean = when {
    root == null -> false
    root.left == null && root.right == null -> sum == root.`val`
    else -> (
            hasPathSum(root.left, sum - root.`val`) ||
                    hasPathSum(root.right, sum - root.`val`)
            )
}
