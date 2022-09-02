package leetcode;

class LeetCode {
    private static int size(ListNode head) {
        int size = 0;
        for (ListNode ptr = head; ptr != null; ptr = ptr.next) size++;
        return size;
    }

    private static ListNode get(ListNode head, int n) {
        while (n-- > 0) {
            head = head.next;
        }
        return head;
    }

    private static ListNode merge(ListNode tail, ListNode lNode, ListNode mNode, ListNode rNode) {
        ListNode lPtr = lNode;
        ListNode rPtr = mNode;
        while (lPtr != mNode || rPtr != rNode) {
            if (rPtr == rNode || (lPtr != mNode && lPtr.val <= rPtr.val)) {
                tail.next = lPtr;
                lPtr = lPtr.next;
            } else {
                tail.next = rPtr;
                rPtr = rPtr.next;
            }
            tail = tail.next;
            tail.next = null;
        }
        tail.next = rNode;
        return tail;
    }

    public static ListNode sortList(ListNode head) {
        final int size = size(head);
        final ListNode dummyHead = new ListNode(0, head);
        for (int width = 1; width < size; width *= 2) {
            ListNode tail = dummyHead;
            for (int l = 0; l < size; l += 2 * width) {
                final int m = Math.min(l + width, size);
                final int r = Math.min(l + 2 * width, size);
                final ListNode lNode = tail.next;
                final ListNode mNode = get(lNode, m - l);
                final ListNode rNode = get(mNode, r - m);
                tail = merge(tail, lNode, mNode, rNode);
            }
        }
        return dummyHead.next;
    }
}
