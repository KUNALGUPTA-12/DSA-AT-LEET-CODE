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
    public boolean isPalindrome(ListNode head) {
          // Java mein '!head' nahi likh sakte, isliye 'head == null' use hota hai
        // Agar list khali hai ya 1 element hai, to woh palindrome hai
        if (head == null || head.next == null) return true;
        
        // STEP 1: Middle element dhundna (Slow-Fast Pointers)
        ListNode slow = head;
        ListNode fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;         // 1 step aage
            fast = fast.next.next;     // 2 step aage
        }
        
        // STEP 2: Second half ko reverse karna
        ListNode prev = null; // Java mein 'null' hamesha small letters mein hota hai
        ListNode curr = slow;
        while (curr != null) {
            ListNode nextNode = curr.next; // Agla node safe rakha
            curr.next = prev;               // Arrow ko piche moda
            prev = curr;                     // prev ko aage badhaya
            curr = nextNode;                 // curr ko aage badhaya
        }
        
        // STEP 3: Pehle half aur dusre reversed half ko compare karna
        ListNode firstHalf = head;
        ListNode secondHalf = prev; 
        while (secondHalf != null) {
            if (firstHalf.val != secondHalf.val) {
                return false; // Agar data match nahi hua, to false
            }
            firstHalf = firstHalf.next;
            secondHalf = secondHalf.next;
        }
        
        return true; // Agar saare element match ho gaye
    }
}