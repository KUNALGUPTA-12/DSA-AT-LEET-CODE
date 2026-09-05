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
    ListNode* reverseKGroup(ListNode* head, int k) {
           // Agar list khali ho ya k = 1 ho (1-1 dabbe ka group), to badalna hi nahi hai
        if (!head || k == 1) return head;

        // 1. Ek nakli dabba (Dummy Node) banaya aur head ke pehle joda
        ListNode* dummy = new ListNode(0);
        dummy->next = head;

        ListNode* before = dummy;

        // Yeh loop baar-baar repeat karega chahe kitni bhi lambi ginti (1,2,3,4,5,6,7...) ho
        while (true) {
            
            // 2. Check karo ki kya aage poore 'k' dabbe hain ya nahi
            ListNode* check = before;
            for (int i = 0; i < k; i++) {
                check = check->next;
                
                // !check ka matlab: Dabbe kam pad gaye! Poori bani hui train return kar do
                if (!check) { 
                    ListNode* newHead = dummy->next;
                    delete dummy; // Faltu dummy memory ko saaf kiya
                    return newHead; // Pura code yahin se safely khatam!
                }
            }

            // 3. Agar 'k' dabbe poore hain, to unhe aapki standard approach se reverse karo
            ListNode* curr = before->next;
            ListNode* prev = nullptr;
            ListNode* tail = curr; // Yeh group ka pehla dabba hai, jo baad mein pooch (tail) banega

            for (int i = 0; i < k; i++) {
                ListNode* next = curr->next;
                curr->next = prev;
                prev = curr;
                curr = next;
            }

            // 4. Toote hue dono connections ko wapas joda
            before->next = prev; // Pichle hisse ko ulte hisse ke naye head se joda
            tail->next = curr;   // Ulte hisse ki tail ko aage bache hue dabbo se joda

            // 5. before ko dhakka maar kar naye group ke theek pehle (tail) par set kiya taaki loop repeat ho sake
            before = tail;
        }
    }
};