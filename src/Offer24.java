public class Offer24 {
    public ListNode reverseList(ListNode head) {
//        解法1：
//        采用迭代的方法实现
//        if (head == null) return null;
//        if (head.next == null) return head;
//
//        ListNode currentNode = head.next;
//        head.next = null;
//        ListNode nextNode = currentNode;
//
//        while (currentNode != null) {
//            nextNode = currentNode.next;
//            currentNode.next = head;
//            head = currentNode;
//            currentNode = nextNode;
//        }
//        return head;

//        解法2：
//        采用递归的方式实现
        if (head == null) return null;
        if (head.next == null) return head;

        ListNode reverseHead = reverseList(head.next);
        head.next.next = head;
        head.next = null;
        return reverseHead;
    }
}
