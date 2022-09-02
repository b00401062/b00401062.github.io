package leetcode

fun traverse(node: TreeNode?, root_sum: Int): Int {
    if (node == null) {
        return 0
    }
    val curr_sum = root_sum * 10 + node.`val`
    if (node.left == null && node.right == null) {
        return curr_sum
    }
    val left_sum = traverse(node.left, curr_sum)
    val right_sum = traverse(node.right, curr_sum)
    return left_sum + right_sum
}

fun sumNumbers(root: TreeNode?): Int {
    return traverse(root, 0)
}
