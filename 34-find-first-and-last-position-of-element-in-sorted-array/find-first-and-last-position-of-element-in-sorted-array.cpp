class Solution {
public:
    vector<int> searchRange(vector<int>& nums, int target) {
         vector<int> result = {-1, -1};
        
        // 1. First Position dhoondho (isFirst = true)
        result[0] = findPosition(nums, target, true);
        
        // 2. Last Position dhoondho (isFirst = false)
        result[1] = findPosition(nums, target, false);
        
        return result;
    }

private:
    int findPosition(vector<int>& nums, int target, bool isFirst) {
        int low = 0;
        int high = nums.size() - 1;
        int ans = -1;
        
        while (low <= high) {
            int mid = low + (high - low) / 2;
            
            if (nums[mid] == target) {
                ans = mid; // Index ko save karlo
                if (isFirst) {
                    high = mid - 1; // Pehla dhoondhne ke liye left jao
                } else {
                    low = mid + 1;  // Aakhiri dhoondhne ke liye right jao
                }
            } 
            else if (nums[mid] < target) {
                low = mid + 1; // Agar mid chota hai, to right jao
            } 
            else {
                high = mid - 1; // Agar mid bada hai, to left jao
            }
        }
        return ans;
    }
};