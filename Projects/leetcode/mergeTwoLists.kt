package leetcode

fun mergeTwoLists(l1: ListNode?, l2: ListNode?): ListNode? {
    if (l1 == null) return l2
    if (l2 == null) return l1
    val head = ListNode(0)
    var tail = head
    var p1 = l1
    var p2 = l2
    while (p1 != null && p2 != null) {
        if (p1.`val` < p2.`val`) {
            tail.next = ListNode(p1.`val`)
            tail = tail.next!!
            p1 = p1.next
        } else {
            tail.next = ListNode(p2.`val`)
            tail = tail.next!!
            p2 = p2.next
        }
    }
    if (p1 == null) tail.next = p2
    else if (p2 == null) tail.next = p1
    return head.next
}
