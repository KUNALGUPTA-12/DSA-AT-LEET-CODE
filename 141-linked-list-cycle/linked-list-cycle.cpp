/**
 * Definition for singly-linked list.
 * struct ListNode {
 *     int val;
 *     ListNode *next;
 *     ListNode(int x) : val(x), next(NULL) {}
 * };
 */
class Solution {
public:
    bool hasCycle(ListNode *head) {
        // loop yah ya cycle invlove the linked list 
        if(head == nullptr || head->next == nullptr) return false;

        ListNode *slow = head,*fast = head;
        // fast ko tab chalaon tab tak vo lats mai na ajaya
        while(fast != nullptr && fast->next != nullptr){
            slow = slow->next;// isko 1 kadam badao
            fast = fast->next->next;//isko 2 kadam badao
            // agar dono miljaya even in a loop or a cycle
            if(fast == slow){
                return true;
            }
        }
        return false;
    }
};