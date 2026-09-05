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
    ListNode* reverseEvenLengthGroups(ListNode* head) {
         if (!head || !head->next) return head;

        // 1. Dummy Node pointer lagaya safety ke liye
        ListNode* dummy = new ListNode(0);
        dummy->next = head;
        ListNode* before = dummy;

        int groupLen = 1; // Shuruat 1st group se hogi (1, 2, 3, 4...)

        while (before->next) {
            // 2. Jaasoos se gino ki is group mein ASLIYAT mein kitne dabbe bache hain
            ListNode* check = before;
            int actualLen = 0;
            
            for (int i = 0; i < groupLen; i++) {
                if (check->next) {
                    check = check->next;
                    actualLen++;
                } else {
                    break; // Agar train beech mein hi khatam ho gayi
                }
            }

            // 3. AGAR ASLI LENGTH EVEN HAI -> TOH REVERSE KARO!
            if (actualLen % 2 == 0) {
                ListNode* curr = before->next;
                ListNode* prev = nullptr;
                ListNode* tail = curr; // Yeh dabba baad mein tail banega

                for (int i = 0; i < actualLen; i++) {
                    ListNode* next = curr->next;
                    curr->next = prev;
                    prev = curr;
                    curr = next;
                }

                // Connections wapas jode
                before->next = prev;
                tail->next = curr;

                // before ko dhakka maar kar tail par khiskaya
                before = tail;
            } 
            // 4. AGAR ASLI LENGTH ODD HAI -> TOH BINA CHHEDE AAGE BADHO!
            else {
                // before ko bina reverse kiye direct is group ke aakhiri dabbe par le jao
                before = check; 
            }

            // Agle round ke liye group ki size 1 badha do (1 -> 2 -> 3 -> 4...)
            groupLen++;
        }

        ListNode* newHead = dummy->next;
        delete dummy;
        return newHead;
    }
};