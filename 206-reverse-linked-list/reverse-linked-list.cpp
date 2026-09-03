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
    ListNode* reverseList(ListNode* head) {
         ListNode* prev = NULL; // 1. Pehle node ke piche koi nahi hai, isliye NULL
        ListNode* curr = head; // 2. Kaam pehle node (head) se shuru karenge
        ListNode* next = NULL; // 3. Agle node ka rasta yaad rakhne ke liye khali dibba
        
        while (curr != NULL) {
            next = curr->next; // (A) Agle node ko sambhal kar rakh liya
            curr->next = prev; // (B) Arrow ko piche ghuma diya (Pehle step me NULL se jurega, fir pichle node se)
            prev = curr;       // (C) Ab 'curr' agle node ke liye 'pichla' (prev) ban gaya
            curr = next;       // (D) Hum agle node par chal diye kaam karne
        }
        
        return prev; // Jab sab ulte ho jayenge, toh aakhri node (prev) hamara naya head ban jayega
    }
    
};