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
    public ListNode removeZeroSumSublists(ListNode head) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        
        HashMap<Integer, ListNode> prefixMap = new HashMap<>();
        int prefixSum = 0;
        
        // Pass 1: Har prefixSum ka aakhiri node map mein save karo
        ListNode curr = dummy;
        while (curr != null) {
            prefixSum += curr.val;
            prefixMap.put(prefixSum, curr);
            curr = curr.next;
        }
        
        // Pass 2: Dobara shuru se chalo aur zero-sum wale dabbe kaat do
        prefixSum = 0;
        curr = dummy;
        while (curr != null) {
            prefixSum += curr.val;
            curr.next = prefixMap.get(prefixSum).next;
            curr = curr.next;
        }
        
        return dummy.next;
    }
}