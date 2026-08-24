/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public ListNode detectCycle(ListNode head) {
        if(head == null || head.next == null)return null;
        // ListNode slow = head,fast = head;
        // Boolean hasCycle = false;
        // while(fast != null && fast.next!= null){
        //     slow = slow.next;
        //     fast = fast.next.next;

        //     if(fast == slow){
        //         hasCycle = true;
        //         break;
        //     }
        // }
        // if(hasCycle == false) return null;

        // slow = head;
        // while(slow != fast){
        //     slow = slow.next;
        //     fast = fast.next;
        // }
        // // return slow;
        // return fast;

        // 2nd code
        ListNode slow = head,fast = head;
        while(fast != null && fast.next!= null){
            slow = slow.next;
            fast = fast.next.next;

            if(fast == slow){
                 fast = head;
                 while(slow != fast){
                    slow = slow.next;
                    fast = fast.next;
                 }
                 return fast;
            }
        }
        return null;
    }
}