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
    ListNode* removeNthFromEnd(ListNode* head, int n) {
        ListNode* dummy = new ListNode(-1);
        dummy->next = head;

        ListNode* fast = dummy;
        ListNode* slow = dummy;
        // fast ko n kadam aga bado

        for(int i = 0;i < n;i++){
            fast = fast->next;
        }

        // last node tak chalo fast puchegya jaldi but slow raha jayaga 

        while(fast->next != nullptr){
            fast = fast->next;
            slow = slow->next;
        }

        // node ko bypass karke hatao

        slow->next = slow->next->next;

        return dummy->next;
    }
};