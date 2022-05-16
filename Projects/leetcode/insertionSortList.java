package leetcode

fun insertionSortList(head: ListNode?): ListNode? {
    if (head == null) return head
    val dummyHead = ListNode(0, head)
    var tail = head
    while (tail!!.next != null) {
        val target = tail.next
        if (tail.`val` <= target!!.`val`) {
            tail = target
            continue
        }
        tail.next = target.next
        var curr: ListNode? = dummyHead
        while (curr !== tail && target.`val` > curr!!.next!!.`val`) {
            curr = curr.next
        }
        target.next = curr.next
        curr.next = target
    }
    return dummyHead.next
}
