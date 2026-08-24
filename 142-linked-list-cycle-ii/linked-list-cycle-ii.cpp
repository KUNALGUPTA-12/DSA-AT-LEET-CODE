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
    ListNode *detectCycle(ListNode *head) {
        if(head  == nullptr || head->next == nullptr) return nullptr;
        // ListNode *slow = head,*fast = head;
        // bool hasCycle = false;
        // while(fast != nullptr && fast->next != nullptr){
        //     slow = slow->next;
        //     fast = fast->next->next;
            
        //     if(fast == slow){
        //         hasCycle = true;
        //         break;
        //     }
        // }
        // if(hasCycle == false) return nullptr;
        
        // // slow head ko speed same karo
        // slow = head;
        // while(slow != fast){
        //     slow = slow->next;
        //     fast = fast->next;
        // }
        // return slow;

        // 2 nd code if(head  == nullptr || head->next == nullptr) return nullptr;
        ListNode *slow = head,*fast = head;
        while(fast != nullptr && fast->next != nullptr){
            slow = slow->next;
            fast = fast->next->next;
            
            if(fast == slow){

                fast = head;
                while(slow != fast){
                    slow = slow->next;
                    fast = fast->next;
                }
                return fast;
            }
        }
        return nullptr;
    }
};