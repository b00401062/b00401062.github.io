package leetcode;

class SortedListToBST {
    private static ListNode findMiddle(ListNode head, ListNode tail) {
        if (head == tail) return null;
        final ListNode dummyHead = new ListNode(0, head);
        ListNode slow = dummyHead, fast = dummyHead;
        while (fast != tail) {
            slow = slow.next;
            fast = fast.next;
            if (fast != tail) fast = fast.next;
        }
        return slow;
    }

    private static TreeNode construct(ListNode head, ListNode tail) {
        final ListNode mid = findMiddle(head, tail);
        return (
            mid == null ? null :
            new TreeNode(mid.val, construct(head, mid), construct(mid.next, tail))
        );
    }

    public static TreeNode sortedListToBST(ListNode head) {
        return construct(head, null);
    }
}
