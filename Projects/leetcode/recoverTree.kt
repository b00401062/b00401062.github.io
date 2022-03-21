package leetcode

private fun swapVal(n1: TreeNode?, n2: TreeNode?) {
    val `val` = n1!!.`val`
    n1.`val` = n2!!.`val`
    n2.`val` = `val`
}

fun recoverTree(root: TreeNode?) {
    var preNode: TreeNode? = TreeNode(Int.MIN_VALUE)
    var curNode = root
    var pairIsFound = false
    val candNodes: MutableList<TreeNode?> = ArrayList()
    while (curNode != null) {
        if (curNode.left == null) {
            pairIsFound = true
        } else {
            var tmpNode = curNode.left
            while (tmpNode!!.right != null && tmpNode.right !== curNode) {
                tmpNode = tmpNode.right
            }
            if (tmpNode.right !== curNode) {
                tmpNode.right = curNode
                curNode = curNode.left
                pairIsFound = false
            } else {
                tmpNode.right = null
                pairIsFound = true
            }
        }
        if (pairIsFound) {
            if (curNode!!.`val` < preNode!!.`val`) {
                candNodes.add(preNode)
                candNodes.add(curNode)
            }
            preNode = curNode
            curNode = curNode.right
        }
    }
    swapVal(candNodes[0], candNodes[candNodes.size - 1])
}
