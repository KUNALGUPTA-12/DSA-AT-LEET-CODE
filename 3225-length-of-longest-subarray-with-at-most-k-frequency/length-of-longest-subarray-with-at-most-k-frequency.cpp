class Solution {
public:
    int maxSubarrayLength(vector<int>& nums, int k) {
        unordered_map<int, int> freq_map; // Memory me elements ki ginti rakhne ke liye
        int left = 0;
        int max_length = 0;
        
        for (int right = 0; right < nums.size(); right++) {
            freq_map[nums[right]]++; // Naye element ki ginti map me badhao
            
            // Agar kisi element ki ginti k se zyada ho jaye, toh left se window choti karo
            while (freq_map[nums[right]] > k) {
                freq_map[nums[left]]--; // Piche wale element ki ginti kam karo
                left++; // Left pointer ko aage badhao
            }
            
            // Har baar sabse lambi valid window ka size save karo
            max_length = max(max_length, right - left + 1);
        }
        
        return max_length;
    }
};