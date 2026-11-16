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
    ListNode *getIntersectionNode(ListNode *headA, ListNode *headB) {
        // first simple code

        //  // Step 1: Dono lists ki lambai (length) ginte hain
        // int lenA = 0, lenB = 0;
        // ListNode* tempA = headA;
        // ListNode* tempB = headB;
        
        // while (tempA != NULL) {
        //     lenA++;
        //     tempA = tempA->next;
        // }
        // while (tempB != NULL) {
        //     lenB++;
        //     tempB = tempB->next;
        // }
        
        // // Step 2: Jo list lambi hai, usko extra kadam pehle hi aage badha do
        // while (lenA > lenB) {
        //     headA = headA->next;
        //     lenA--;
        // }
        // while (lenB > lenA) {
        //     headB = headB->next;
        //     lenB--;
        // }
        
        // // Step 3: Ab dono barabar doori par hain, ek saath aage badhao
        // while (headA != headB) {
        //     headA = headA->next;
        //     headB = headB->next;
        // }
        
        // // Jahan dono milenge (ya NULL), usko return kar do
        // return headA;

        // second code

         if (headA == NULL || headB == NULL) return NULL;
        
        ListNode* a = headA;
        ListNode* b = headB;
        
        // Jab tak dono pointers ek hi node par nahi mil jaate
        while (a != b) {
            // Agar 'a' khatam ho jaye toh usko headB par bhej do, warna aage badhao
            a = (a == NULL) ? headB : a->next;
            
            // Agar 'b' khatam ho jaye toh usko headA par bhej do, warna aage badhao
            b = (b == NULL) ? headA : b->next;
        }
        
        // Yahan ya toh intersection node return hoga, ya phir NULL
        return a;

    }
};