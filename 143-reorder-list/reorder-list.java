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
    public void reorderList(ListNode head) {
         // Java strict hai, isliye 'head == null' use karenge
        if (head == null || head.next == null) return;
        
        // ==========================================
        // STEP 1: Middle element dhundna aur todna
        // ==========================================
        ListNode slow = head;
        ListNode fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        
        // List ko do hisson (halves) mein todna
        ListNode secondHalf = slow.next;
        slow.next = null; // Pehli list ka end yahi hai
        
        // ==========================================
        // STEP 2: Second half ko Reverse karna
        // ==========================================
        ListNode prev = null;
        ListNode curr = secondHalf;
        while (curr != null) {
            ListNode nextNode = curr.next; // Backup liya
            curr.next = prev;               // Reverse kiya
            prev = curr;
            curr = nextNode;
        }
        
        // ==========================================
        // STEP 3: Zig-zag Merge karna
        // ==========================================
        ListNode p1 = head;
        ListNode p2 = prev;
        
        while (p2 != null) {
            ListNode tmp1 = p1.next; // Backup 1
            ListNode tmp2 = p2.next; // Backup 2
            
            p1.next = p2;             // Connect p1 to p2
            p2.next = tmp1;           // Connect p2 to p1's next
            
            p1 = tmp1;                 // Move p1 forward
            p2 = tmp2;                 // Move p2 forward
        }
    }
}