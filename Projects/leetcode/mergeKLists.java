package leetcode

private fun select(lists: Array<ListNode?>): Int {
    var argmin: Int = -1
    for (i in lists.indices)
        argmin = when {
            lists[i] == null -> argmin
            argmin == -1 -> i
            lists[argmin]!!.`val` < lists[i]!!.`val` -> argmin
            else -> i
        }
    return argmin
}

fun mergeKLists(lists: Array<ListNode?>): ListNode? {
    val head = ListNode(0)
    var tail = head
    var i: Int = select(lists)
    while (i != -1) {
        tail.next = ListNode(lists[i]!!.`val`)
        tail = tail.next!!
        lists[i] = lists[i]?.next
        i = select(lists)
    }
    return head.next
}
