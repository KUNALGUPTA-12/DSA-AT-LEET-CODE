class Solution {
public:
    long long countSubarrays(vector<int>& nums, int minK, int maxK) {
        long long ans = 0;
        
        // Pointers ko track karne ke liye variables
        int badIdx = -1;  // Range se bahar wale element ka index
        int minIdx = -1;  // minK ka sabse aakhri index
        int maxIdx = -1;  // maxK ka sabse aakhri index
        
        for (int i = 0; i < nums.size(); ++i) {
            // 1. Agar element out of bound hai, toh badIdx update karo
            if (nums[i] < minK || nums[i] > maxK) {
                badIdx = i;
            }
            
            // 2. Agar element minK ke barabar hai
            if (nums[i] == minK) {
                minIdx = i;
            }
            
            // 3. Agar element maxK ke barabar hai
            if (nums[i] == maxK) {
                maxIdx = i;
            }
            
            // 4. Valid starting points gino aur answer mein add karo
            // Dono indices me se jo pehle aaya hai, wahan se lekar badIdx ke beech ke points valid hain
            int validSubarraysCount = min(minIdx, maxIdx) - badIdx;
            
            if (validSubarraysCount > 0) {
                ans += validSubarraysCount;
            }
        }
        
        return ans;

    }
};