package leetcode

fun rotateRight(head: ListNode?, k: Int): ListNode? {
    if (head == null || head.next == null) return head
    var n = 0
    var ptr = head
    var tail: ListNode? = null
    while (ptr != null) {
        n += 1
        if (ptr.next == null) tail = ptr
        ptr = ptr.next
    }
    if (k % n == 0) return head
    ptr = head
    repeat(n - k % n - 1) {
        ptr = ptr?.next
    }
    val newTail = ptr
    val newHead = ptr?.next
    newTail?.next = null
    tail?.next = head
    return newHead
}
