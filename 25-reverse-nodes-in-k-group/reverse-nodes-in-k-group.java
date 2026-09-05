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
    public ListNode reverseKGroup(ListNode head, int k) {
        if (head == null || k == 1) return head;

        // 1. Nakli dabba (Dummy) banaya aur head ke pehle joda
        ListNode dummy = new ListNode(0);
        dummy.next = head;

        ListNode before = dummy;

        // Yeh loop baar-baar repeat karega chahe kitni bhi lambi ginti ho
        while (true) {
            
            // 2. Check karo ki aage 'k' dabbe bache hain ya nahi
            ListNode check = before;
            for (int i = 0; i < k; i++) {
                check = check.next;
                
                // Dabbe kam pad gaye, to bina chhede poori train return kar do
                if (check == null) {
                    return dummy.next; 
                }
            }

            // 3. Standard Reverse Loop
            ListNode curr = before.next;
            ListNode prev = null;
            ListNode tail = curr; // Yeh baad mein group ki pooch (tail) banega

            for (int i = 0; i < k; i++) {
                ListNode next = curr.next;
                curr.next = prev;
                prev = curr;
                curr = next;
            }

            // 4. Connections wapas jode
            before.next = prev;
            tail.next = curr;

            // 5. before ko agle group ke liye khiska kar tail par set kiya taaki loop repeat ho
            before = tail;
        }
    }
}