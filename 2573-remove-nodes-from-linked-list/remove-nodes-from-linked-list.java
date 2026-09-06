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
    public ListNode removeNodes(ListNode head) {
        Stack<ListNode> st = new Stack<>();
        ListNode curr = head;
        
        // Saare nodes ko stack mein daal do
        while (curr != null) {
            st.push(curr);
            curr = curr.next;
        }
        
        // Piche se check karna shuru karo
        ListNode newHead = st.pop(); // Sabse last node hamesha safe hai
        int maxVal = newHead.val;
        
        while (!st.isEmpty()) {
            ListNode node = st.pop();
            
            // Agar node chota hai toh use ignore karo (delete ho gaya)
            if (node.val < maxVal) {
                // Skip it
            } 
            // Agar node bada hai, toh use naye list ke aage (front) mein connect kar do
            else {
                node.next = newHead;
                newHead = node;
                maxVal = node.val; // Naya max set kiya
            }
        }
        
        return newHead;        
    }
}