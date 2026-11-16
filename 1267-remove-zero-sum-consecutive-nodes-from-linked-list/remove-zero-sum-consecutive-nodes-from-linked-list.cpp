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
    ListNode* removeZeroSumSublists(ListNode* head) {
         ListNode* dummy = new ListNode(0);
        dummy->next = head;
        
        unordered_map<int, ListNode*> prefixMap;
        int prefixSum = 0;
        
        // Pass 1: Har prefixSum ka aakhiri node map mein save karo
        ListNode* curr = dummy;
        while (curr != nullptr) {
            prefixSum += curr->val;
            prefixMap[prefixSum] = curr;
            curr = curr->next;
        }
        
        // Pass 2: Dobara shuru se chalo aur zero-sum wale dabbe kaat do
        prefixSum = 0;
        curr = dummy;
        while (curr != nullptr) {
            prefixSum += curr->val;
            curr->next = prefixMap[prefixSum]->next;
            curr = curr->next;
        }
        
        return dummy->next;
    }
};