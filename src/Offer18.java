/**
 * Definition for singly-linked list.
 * public class ListNode {
 * int val;
 * ListNode next;
 * ListNode(int x) { val = x; }
 * }
 */
public class Offer18 {
    public ListNode deleteNode(ListNode head, int val) {
        if (head == null) return null;
        if (head.val == val) return head.next;
        ListNode current = head, pre = head;
        while (current != null) {
            if (current.val == val) {
                pre.next = current.next;
                return head;
            }
            pre = current;
            current = current.next;
        }
        return null;
    }
}