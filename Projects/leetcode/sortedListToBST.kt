package leetcode

private fun findMiddle(head: ListNode?, tail: ListNode?): ListNode? {
    if (head === tail) return null
    val dummyHead = ListNode(0, head)
    var slow: ListNode? = dummyHead
    var fast: ListNode? = dummyHead
    while (fast !== tail) {
        slow = slow!!.next
        fast = fast!!.next
        if (fast !== tail) fast = fast!!.next
    }
    return slow
}

private fun construct(head: ListNode?, tail: ListNode?): TreeNode? {
    val mid = findMiddle(head, tail)
    return if (mid == null) null else TreeNode(mid.`val`, construct(head, mid), construct(mid.next, tail))
}

fun sortedListToBST(head: ListNode?): TreeNode? {
    return construct(head, null)
}
