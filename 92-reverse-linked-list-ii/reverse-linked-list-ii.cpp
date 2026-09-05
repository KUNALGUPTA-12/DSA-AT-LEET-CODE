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
    ListNode* reverseBetween(ListNode* head, int left, int right) {
         if (!head || left == right) return head;

        // 1. Ek nakli dabba (Dummy Node) pointer banaya aur head ke pehle joda
        ListNode* dummy = new ListNode(0);
        dummy->next = head;

        ListNode* before = dummy;

        // 2. before pointer ko 'left - 1' tak ek-ek kadam aage badhaya
        for (int i = 1; i < left; i++) {
            before = before->next;
        }

        ListNode* curr = before->next;
        ListNode* prev = nullptr;

        // 3. right - left + 1 waale formula se pure dabbe reverse kiye
        for (int i = 0; i < right - left + 1; i++) {
            ListNode* next = curr->next;
            curr->next = prev;
            prev = curr;
            curr = next;
        }

        // 4. Toote hue dono connections ko wapas joda
        before->next->next = curr; // Dabba 2 ko bache hue aage ke dabbe (5) se joda
        before->next = prev;       // Dabba 1 ko ulte hisse ke naye head (4) se joda

        // Asli head nikal kar safe rakha taaki dummy delete kar sakein
        ListNode* newHead = dummy->next;
        delete dummy; // Faltu nakli dabbe ko memory se saaf kiya
        
        return newHead;
    }
};