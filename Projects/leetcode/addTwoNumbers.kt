package leetcode

private fun carry(l: ListNode) {
    if (l.`val` < 10)
        return
    l.`val` %= 10
    if (l.next == null)
        l.next = ListNode(1)
    else {
        l.next!!.`val`++
        carry(l.next!!)
    }
}

fun addTwoNumbers(l1: ListNode?, l2: ListNode?): ListNode? {
    if (l1 == null)
        return l2
    if (l2 == null)
        return l1
    val l = ListNode(l1.`val` + l2.`val`)
    l.next = addTwoNumbers(l1.next, l2.next)
    carry(l)
    return l
}
