/**
 * Definition for singly-linked list.
 * struct ListNode {
 *     int val;
 *     ListNode *next;
 *     ListNode() : val(0), next(nullptr) {}
 *     ListNode(int x) : val(x), next(nullptr) {}
 *     ListNode(int x, ListNode *next) : val(x), next(next) {}
 * };
 */
class Solution {
public:
    void reorderList(ListNode* head) {
        // Base Case: Agar list khali hai ya 1 node hai, to kuch nahi karna
        if (!head || !head->next) return;
        
        // ==========================================
        // STEP 1: Middle element dhundna aur todna
        // ==========================================
        ListNode* slow = head;
        ListNode* fast = head;
        while (fast && fast->next) {
            slow = slow->next;
            fast = fast->next->next;
        }
        
        // List ko do hisson (halves) mein todna
        ListNode* secondHalf = slow->next; // slow->next se second half shuru hua
        slow->next = nullptr;              // Pehli list ko beech mein hi kaat diya
        
        // ==========================================
        // STEP 2: Second half ko Reverse karna
        // ==========================================
        ListNode* prev = nullptr;
        ListNode* curr = secondHalf;
        while (curr) {
            ListNode* nextNode = curr->next; // Agla node safe kiya
            curr->next = prev;               // Arrow piche moda
            prev = curr;                     // prev ko aage khiskaya
            curr = nextNode;                 // curr ko aage khiskaya
        }
        
        // ==========================================
        // STEP 3: Zig-zag Merge karna (Alternate Join)
        // ==========================================
        ListNode* p1 = head; // Pehli list ka shuruat (e.g., 1 -> 2 -> 3)
        ListNode* p2 = prev; // Reversed list ka shuruat (e.g., 5 -> 4)
        
        while (p2) {
            ListNode* tmp1 = p1->next; // Backup liya taaki rasta na kho jaye
            ListNode* tmp2 = p2->next; // Backup liya taaki rasta na kho jaye
            
            p1->next = p2;             // p1 (1) ko p2 (5) se joda
            p2->next = tmp1;           // p2 (5) ko tmp1 (2) se joda
            
            p1 = tmp1;                 // p1 ko agle node par badhaya
            p2 = tmp2;                 // p2 ko agle node par badhaya
        }
    }
};