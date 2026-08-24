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
    ListNode* deleteDuplicates(ListNode* head) {
        // agar list khali hai toh rteun karo simple head if single elemnts thre
        if (head == nullptr || head->next == nullptr){
            return head;
        }
        // agar node khali hai or a simle elments ji same hai
        ListNode* curr = head;
        while(curr != nullptr && curr->next != nullptr){
            if(curr->val == curr->next->val){
                ListNode* duplicate = curr->next;
                curr->next = curr->next->next;
                delete duplicate; // remove memory free in c++
            }
            else{
                curr = curr->next;
            }
        }
        return head;
    }
};