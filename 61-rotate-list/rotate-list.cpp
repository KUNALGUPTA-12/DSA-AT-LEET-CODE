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
    ListNode* rotateRight(ListNode* head, int k) {
         // Edge Case: Agar list khali ho, 1 dabba ho, ya ghumana hi na ho
        if (!head || !head->next || k == 0) return head;

        // 1. tail ko head par rakha aur length 1 se shuru ki
        ListNode* tail = head;
        int length = 1;
        
        // Loop khatam hone par length store hogi (jaise 5) aur tail last par aa jayega!
        while (tail->next) {
            tail = tail->next;
            length++;
        }

        // 2. Faltu rotations se bachne ke liye k ko chota kiya (Maths Logic)
        k = k % length;
        if (k == 0) return head; 

        // 3. Last dabbe par khade tail ko head se jod kar Circular (Gol) banaya
        tail->next = head;

        // 4. Piche se k dabbe chorne ke liye, aage se (length - k) kadam chalo
        // Jaise 5 - 2 = 3. Yeh loop newTail ko direct Dabba 3 par rokk dega.
        ListNode* newTail = head;
        for (int i = 1; i < length - k; i++) {
            newTail = newTail->next;
        }

        // 5. Humein pata hai naya head newTail ke theek aage (yani 4) hai!
        ListNode* newHead = newTail->next;
        newTail->next = nullptr; // Train ka circle beech se tod kar seedha kiya

        // Computer ko bata diya ki Dabba 4 hi hamara asli answer hai
        return newHead;
    }
};