package leetcode

private fun size(head: ListNode): Int {
    var size = 0
    var ptr: ListNode? = head
    while (ptr != null) {
        size++
        ptr = ptr.next
    }
    return size
}

private fun get(head: ListNode?, n: Int): ListNode? {
    var head = head
    var n = n
    while (n-- > 0) {
        head = head!!.next
    }
    return head
}

private fun merge(tail: ListNode?, lNode: ListNode?, mNode: ListNode?, rNode: ListNode?): ListNode? {
    var tail = tail
    var lPtr = lNode
    var rPtr = mNode
    while (lPtr !== mNode || rPtr !== rNode) {
        if (rPtr === rNode || lPtr !== mNode && lPtr!!.`val` <= rPtr!!.`val`) {
            tail!!.next = lPtr
            lPtr = lPtr!!.next
        } else {
            tail!!.next = rPtr
            rPtr = rPtr!!.next
        }
        tail = tail.next
        tail!!.next = null
    }
    tail!!.next = rNode
    return tail
}

fun sortList(head: ListNode): ListNode? {
    val size = size(head)
    val dummyHead = ListNode(0, head)
    var width = 1
    while (width < size) {
        var tail: ListNode? = dummyHead
        var l = 0
        while (l < size) {
            val m = Math.min(l + width, size)
            val r = Math.min(l + 2 * width, size)
            val lNode = tail!!.next
            val mNode = `get`(lNode, m - l)
            val rNode = `get`(mNode, r - m)
            tail = merge(tail, lNode, mNode, rNode)
            l += 2 * width
        }
        width *= 2
    }
    return dummyHead.next
}
