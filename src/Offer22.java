public class Offer22 {
//    public ListNode getKthFromEnd(ListNode head, int k) throws Exception {
//        if (k <= 0)
//            throw new Exception("InvalidInputElement!");
//        ListNode fast = head, slow = head;
//        while (fast != null && k > 1) {
//            fast = fast.next;
//            k--;
//        }
//        if (k != 1)
//            throw new Exception("K is too large");
//
//        while (fast != null) {
//            fast = fast.next;
//            slow = slow.next;
//        }
//        return slow;
//    }

    public ListNode getKthFromEnd(ListNode head, int k) {
        if (head == null) return null;
        if (k <= 0) return null;
        ListNode fast = new ListNode(0);
        fast.next = head;
        ListNode slow = fast;

//        fast和slow指针之间相差k-1个节点
        for (int i = 0; i < k - 1; i++) {
            fast = fast.next;
            if (fast == null) return null;
        }

        while (fast.next != null) {
            fast = fast.next;
            slow = slow.next;
        }
        return slow;
    }
}
