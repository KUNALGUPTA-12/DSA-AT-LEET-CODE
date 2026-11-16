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
    public ListNode sortList(ListNode head) {
        // Agar list khali hai ya sirf 1 element hai
        if (head == null || head.next == null) {
            return head;
        }

        ArrayList<Integer> arr = new ArrayList<>();
        ListNode temp = head;

        // 1. Saari values ArrayList mein nikaalein
        while (temp != null) {
            arr.add(temp.val);
            temp = temp.next;
        }

        // 2. ArrayList ko sort karein
        Collections.sort(arr);// asia bhi likh skatha hai
        //arr.sort(null);

        // 3. Sorted values wapas list mein daalein
        temp = head;
        for (int x : arr) {
            temp.val = x;
            temp = temp.next;
        }

        return head;
    }
}