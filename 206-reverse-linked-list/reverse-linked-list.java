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
    public ListNode reverseList(ListNode head) {
        ListNode prev = null; // 1. Pehle node ke piche koi nahi hai, isliye null
        ListNode curr = head; // 2. Kaam pehle node (head) se shuru karenge
        ListNode next = null; // 3. Agle node ka rasta yaad rakhne ke liye khali dibba
        
        while (curr != null) {
            next = curr.next; // (A) Agle node ko sambhal kar rakh liya
            curr.next = prev; // (B) Arrow ko piche ghuma diya (Pehle step me null se jurega, fir pichle node se)
            prev = curr;      // (C) Ab 'curr' agle node ke liye 'pichla' (prev) ban gaya
            curr = next;      // (D) Hum agle node par chal diye kaam karne
        }
        
        return prev; // Jab sab ulte ho jayenge, toh aakhri node (prev) hamara naya head ban jayega
    }
}