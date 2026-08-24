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
    public ListNode deleteDuplicates(ListNode head) {
        // agar list mai single element hai yah khali hai
        if(head == null || head.next == null ){
            return head;
        }
        ListNode curr = head;
        while(curr != null && curr.next != null){
            // agar node ki value same hai agla node se
            if(curr.val==curr.next.val){
                curr.next=curr.next.next; //duplites hai
            }
            else{
                curr = curr.next;
            }
        }
        return head;
    }
}