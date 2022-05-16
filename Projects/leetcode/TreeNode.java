package leetcode

class TreeNode {
    var `val` = 0
    var left: TreeNode? = null
    var right: TreeNode? = null

    constructor()
    constructor(`val`: Int) {
        this.`val` = `val`
    }

    constructor(`val`: Int, left: TreeNode?, right: TreeNode?) {
        this.`val` = `val`
        this.left = left
        this.right = right
    }
}