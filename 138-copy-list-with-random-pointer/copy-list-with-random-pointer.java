/*
// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
*/

class Solution {
    public Node copyRandomList(Node head) {
         if (head == null) return null;

        // Step 1: Har original node ke piche uska copy node lagao
        Node curr = head;
        while (curr != null) {
            Node copyNode = new Node(curr.val);
            copyNode.next = curr.next;
            curr.next = copyNode;
            curr = copyNode.next;
        }

        // Step 2: Copy nodes ke random pointers set karo
        curr = head;
        while (curr != null) {
            if (curr.random != null) {
                curr.next.random = curr.random.next;
            }
            curr = curr.next.next;
        }

        // Step 3: Original aur Copy list ko alag-alag karo
        curr = head;
        Node dummy = new Node(-1);
        Node copyCurr = dummy;

        while (curr != null) {
            copyCurr.next = curr.next;
            curr.next = curr.next.next;
            
            copyCurr = copyCurr.next;
            curr = curr.next;
        }

        return dummy.next;
    }
}