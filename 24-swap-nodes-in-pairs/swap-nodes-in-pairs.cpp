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
    ListNode* swapPairs(ListNode* head) {
        // Agar list khali ho ya sirf 1 hi dabba ho
        if (!head || !head->next) return head;

        // 1. Nakli dabba (Dummy) banaya aur head ke pehle joda
        ListNode* dummy = new ListNode(0);
        dummy->next = head;

        // prev haath abhi dummy par khada hai
        ListNode* prev = dummy;

        // 2. Loop tab tak chalega jab tak aage poore 2 dabbe hain
        while (prev->next && prev->next->next) {
            ListNode* first = prev->next;       // Pehla dabba (jaise 1)
            ListNode* second = prev->next->next; // Dusra dabba (jaise 2)

            // 3. Teen arrows ka khel (Swap karna)
            first->next = second->next; 
            second->next = first;       
            prev->next = second;        

            // 4. (Apne aap nahi hota!) Humne prev ko dhakka maar kar first par khiskaya
            prev = first; 
        }

        ListNode* newHead = dummy->next;
        delete dummy; // Memory saaf ki
        
        return newHead;
    }
};