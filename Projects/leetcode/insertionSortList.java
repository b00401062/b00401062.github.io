package leetcode;

class LeetCode {
    public ListNode insertionSortList(ListNode head) {
        if (head == null) return head;
        ListNode dummyHead = new ListNode(0, head);
        ListNode tail = head;
        while (tail.next != null) {
            ListNode target = tail.next;
            if (tail.val <= target.val) {
                tail = target;
                continue;
            }
            tail.next = target.next;
            ListNode curr = dummyHead;
            while (curr != tail && target.val > curr.next.val) {
                curr = curr.next;
            }
            target.next = curr.next;
            curr.next = target;
        }
        return dummyHead.next;
    }
}
