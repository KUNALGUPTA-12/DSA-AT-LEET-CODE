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
    public ListNode reverseEvenLengthGroups(ListNode head) {
        if (head == null || head.next == null) return head;

        // 1. Dummy Node lagayi
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode before = dummy;

        int groupLen = 1; // Sequence: 1, 2, 3, 4...

        while (before.next != null) {
            // 2. Asli dabbo ki ginti karo jo bache hain
            ListNode check = before;
            int actualLen = 0;
            
            for (int i = 0; i < groupLen; i++) {
                if (check.next != null) {
                    check = check.next;
                    actualLen++;
                } else {
                    break;
                }
            }

            // 3. Agar length Even hai to reverse karo
            if (actualLen % 2 == 0) {
                ListNode curr = before.next;
                ListNode prev = null;
                ListNode tail = curr;

                for (int i = 0; i < actualLen; i++) {
                    ListNode next = curr.next;
                    curr.next = prev;
                    prev = curr;
                    curr = next;
                }

                before.next = prev;
                tail.next = curr;
                before = tail; // Dhakka maara
            } 
            // 4. Agar Odd hai to bina chhede pointer aage badhao
            else {
                before = check;
            }

            groupLen++; // Agle group ki size badhayi
        }

        return dummy.next;
    }
}