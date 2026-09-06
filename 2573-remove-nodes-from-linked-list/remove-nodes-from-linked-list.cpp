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
    ListNode* removeNodes(ListNode* head) {
         stack<ListNode*> st; // Nodes ke pointers ko store karne ke liye stack
        ListNode* curr = head;
        
        // Step 1: Saare nodes ko stack mein push kar do (Left to Right)
        while (curr != NULL) {
            st.push(curr);
            curr = curr->next;
        }
        
        // Step 2: Piche se nodes ko nikalna shuru karo
        ListNode* newHead = st.top(); // Sabse aakhiri waala node hamesha safe rahega
        st.pop();
        int maxVal = newHead->val; // Max value abhi sabse aakhiri node ki hai
        
        while (!st.empty()) {
            ListNode* node = st.top();
            st.pop();
            
            // Agar current node ki value pichle sabse bade node se choti hai, toh isko delete karo
            if (node->val < maxVal) {
                // Delete karne ke liye isko skip kar denge (kuch nahi karenge)
            } 
            // Agar current node bada ya barabar hai, toh isko naye list ke aage jod do
            else {
                node->next = newHead; 
                newHead = node; // Naya head ab yeh node ban gaya
                maxVal = node->val; // Max value ko update kar diya
            }
        }
        
        return newHead;
    }
};