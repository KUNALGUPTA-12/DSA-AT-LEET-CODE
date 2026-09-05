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
    public ListNode rotateRight(ListNode head, int k) {
         // Edge Case: Agar list khali ho ya 1 hi dabba ho
        if (head == null || head.next == null || k == 0) return head;

        // 1. Shuruat ki
        ListNode tail = head;
        int length = 1;
        
        // Loop khatam hone par tail last par aa jayega aur length store ho jayegi
        while (tail.next != null) {
            tail = tail.next;
            length++;
        }

        // 2. k % length math se k ko handle kiya
        k = k % length;
        if (k == 0) return head;

        // 3. Last dabbe ko head se jod kar circle banaya
        tail.next = head;

        // 4. (length - k) kadam chalkar naye tail (Dabba 3) par pahunche
        ListNode newTail = head;
        for (int i = 1; i < length - k; i++) {
            newTail = newTail.next;
        }

        // 5. Naya head (Dabba 4) nikala aur circle ko break kiya
        ListNode newHead = newTail.next;
        newTail.next = null;

        return newHead;
    }
}