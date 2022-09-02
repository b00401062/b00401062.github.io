package leetcode;

import java.util.HashMap;

class LRUCache {
    private static class ListNode {
        int key;
        int value;
        ListNode prev;
        ListNode next;

        ListNode(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }

    private static class List {
        private final ListNode head;
        private final ListNode tail;

        List() {
            this.head = new ListNode(-1, -1);
            this.tail = new ListNode(-1, -1);
            this.head.next = this.tail;
            this.tail.prev = this.head;
        }

        public void remove(ListNode node) {
            node.prev.next = node.next;
            node.next.prev = node.prev;
        }

        public void push(ListNode node) {
            node.prev = this.head;
            node.next = this.head.next;
            this.head.next.prev = node;
            this.head.next = node;
        }

        public ListNode pop() {
            final ListNode node = this.tail.prev;
            remove(node);
            return node;
        }
    }

    private final int capacity;
    private final HashMap<Integer, ListNode> cache;
    private final List list;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        this.cache = new HashMap<>(capacity);
        this.list = new List();
    }

    public int get(int key) {
        final ListNode node = this.cache.get(key);
        if (node == null) return -1;
        final int value = node.value;
        this.list.remove(node);
        this.list.push(node);
        return value;
    }

    public void put(int key, int value) {
        if (this.cache.containsKey(key)) {
            this.get(key);
            this.cache.get(key).value = value;
            return;
        }
        final ListNode node = new ListNode(key, value);
        this.cache.put(key, node);
        this.list.push(node);
        if (this.cache.size() <= this.capacity) return;
        this.cache.remove(this.list.pop().key);
    }
}
