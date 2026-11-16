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
    ListNode* sortList(ListNode* head) {
          // Agar list khali hai ya sirf 1 element hai
        if (head == NULL || head->next == NULL) {
            return head;
        }

        vector<int> arr;
        ListNode* temp = head;

        // 1. Saari values vector mein nikaalein
        while (temp != NULL) {
            arr.push_back(temp->val);
            temp = temp->next;
        }

        // 2. Vector ko sort karein
        sort(arr.begin(), arr.end());

        // 3. Sorted values wapas list mein daalein
        temp = head;
        for (int x : arr) {
            temp->val = x;
            temp = temp->next;
        }

        return head;
    }
};