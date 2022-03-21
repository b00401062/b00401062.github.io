package leetcode

fun invertTree(root: TreeNode?): TreeNode? {
    if (root == null) {
        return root
    }
    val tmp = root.left
    root.left = root.right
    root.right = tmp
    if (root.left != null) {
        invertTree(root.left)
    }
    if (root.right != null) {
        invertTree(root.right)
    }
    return root
}
