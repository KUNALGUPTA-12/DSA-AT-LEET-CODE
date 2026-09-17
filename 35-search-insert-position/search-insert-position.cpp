class Solution {
public:
    int searchInsert(vector<int>& nums, int target) {
         int start_index = 0; // snake_case
        int end_index = nums.size() - 1; // snake_case
        
        while (start_index <= end_index) {
            // Integer overflow se bachne ke liye safe formula
            int mid_index = start_index + (end_index - start_index) / 2; // snake_case
            
            // Case 1: Target milne par index return karo
            if (nums[mid_index] == target) {
                return mid_index;
            }
            // Case 2: Agar target bada hai, toh right side jao
            else if (nums[mid_index] < target) {
                start_index = mid_index + 1;
            }
            // Case 3: Agar target chota hai, toh left side jao
            else {
                end_index = mid_index - 1;
            }
        }
        
        // Loop break hone par start_index par hi sahi insertion point hota hai
        return start_index;
    }
};