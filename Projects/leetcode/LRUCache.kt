package leetcode

internal class LRUCache(private val capacity: Int) {
    private class ListNode(var key: Int, var value: Int) {
        var prev: ListNode? = null
        var next: ListNode? = null
    }

    private class List() {
        private val head: ListNode = ListNode(-1, -1)
        private val tail: ListNode = ListNode(-1, -1)

        init {
            head.next = tail
            tail.prev = head
        }

        fun remove(node: ListNode?) {
            node!!.prev!!.next = node.next
            node.next!!.prev = node.prev
        }

        fun push(node: ListNode) {
            node.prev = head
            node.next = head.next
            head.next!!.prev = node
            head.next = node
        }

        fun pop(): ListNode? {
            val node = tail.prev
            remove(node)
            return node
        }
    }

    private val cache: HashMap<Int, ListNode> = HashMap(capacity)
    private val list: List = List()

    operator fun get(key: Int): Int {
        val node = this.cache[key] ?: return -1
        val value = node.value
        list.remove(node)
        list.push(node)
        return value
    }

    fun put(key: Int, value: Int) {
        if (this.cache.containsKey(key)) {
            this[key]
            this.cache[key]!!.value = value
            return
        }
        val node = ListNode(key, value)
        this.cache[key] = node
        list.push(node)
        if (this.cache.size <= capacity) return
        this.cache.remove(list.pop()!!.key)
    }
}