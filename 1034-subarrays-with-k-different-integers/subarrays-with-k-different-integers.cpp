class Solution {
private:
    // Helper function: Jo 'At Most K' unique elements wale subarrays ginta hai
    int subarraysWithAtMostK(vector<int>& nums, int k) {
        unordered_map<int, int> countMap; // Element ki frequency track karne ke liye
        int left = 0;
        int ans = 0;
        
        for (int right = 0; right < nums.size(); ++right) {
            // 1. Right element ko window mein shamil karo
            countMap[nums[right]]++;
            
            // 2. Agar unique elements K se zyada ho gaye, toh left se window choti karo
            while (countMap.size() > k) {
                countMap[nums[left]]--;
                if (countMap[nums[left]] == 0) {
                    countMap.erase(nums[left]); // Agar count 0 ho jaye, toh map se hata do
                }
                left++; // Left pointer ko aage badhao
            }
            
            // 3. Current right pointer par khatam hone wale saare valid subarrays ki ginti
            ans += (right - left + 1);
        }
        return ans;
    }

public:
    int subarraysWithKDistinct(vector<int>& nums, int k) {
        // Formula: Exact K = AtMost(K) - AtMost(K - 1)
        return subarraysWithAtMostK(nums, k) - subarraysWithAtMostK(nums, k - 1);
    }
}; // <- Yeh class ka bracket band hona zaroori tha