public class Offer25 {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (l1 == null) return l2;
        if (l2 == null) return l1;

        ListNode fakeHead = new ListNode(0);
        ListNode rear = fakeHead;
        while (l1 != null && l2 != null) {
            if (l1.val < l2.val) {
                rear.next = l1;
                rear = rear.next;
                l1 = l1.next;
            } else {
                rear.next = l2;
                rear = rear.next;
                l2 = l2.next;
            }
        }
        rear.next = (l1==null)? l2:l1;
        return fakeHead.next;
    }
}
