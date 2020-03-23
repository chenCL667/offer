/**
 * Definition for singly-linked list.
 * public class ListNode {
 * int val;
 * ListNode next;
 * ListNode(int x) { val = x; }
 * }
 */
class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
    }
}

class Offer06 {
    public int[] reversePrint(ListNode head) {
        ListNode current = head;
        int length = 0;
        while (current != null) {
            length++;
            current = current.next;
        }
        int[] res = new int[length];
        current = head;
        while (current != null) {
            res[--length] = current.val;
            current = current.next;
        }
        return res;
    }
}