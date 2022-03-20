package leetcode

fun removeNthFromEnd(head: ListNode?, n: Int): ListNode? {
    var curr: ListNode? = head
    val list = mutableListOf<ListNode>()
    while (curr != null) {
        list.add(curr)
        curr = curr.next
    }
    if (list.size == n)
        return head?.next
    list[list.size - n - 1].next = list[list.size - n].next
    return head
}
