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
    public ListNode reverseBetween(ListNode head, int left, int right) {
        if (head == null || left == right) return head;

        // 1. Nakli dabba banaya aur head ke pehle joda
        ListNode dummy = new ListNode(0);
        dummy.next = head;

        ListNode before = dummy;

        // 2. before ko left se strict ek kadam piche tak le gaye
        for (int i = 1; i < left; i++) {
            before = before.next;
        }

        ListNode curr = before.next;
        ListNode prev = null; // Java mein nullptr ki jagah null hota hai

        // 3. right - left + 1 waale loop se beech ke dabbun ko ulta kiya
        for (int i = 0; i < right - left + 1; i++) {
            ListNode next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }

        // 4. Toote hue rasto ko wapas jod kar poori train sahi ki
        before.next.next = curr;
        before.next = prev;

        // Dummy ke aage jo asli naya head mila, use return kiya
        return dummy.next;
    }
}