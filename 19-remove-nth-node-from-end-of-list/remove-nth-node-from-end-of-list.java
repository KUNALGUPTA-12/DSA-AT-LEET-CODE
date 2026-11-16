/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        
        ListNode fast = dummy;
        ListNode slow = dummy;
        
        // Fast ko 'n' kadam aage bhejo
        for (int i = 0; i < n; i++) {
            fast = fast.next;
        }
        
        // Jab tak fast last node par na pahunche, dono ko saath chalao
        while (fast.next != null) {
            fast = fast.next;
            slow = slow.next;
        }
        
        // Node ko bypass (delete) karo
        slow.next = slow.next.next;
        
        return dummy.next;
    }
}