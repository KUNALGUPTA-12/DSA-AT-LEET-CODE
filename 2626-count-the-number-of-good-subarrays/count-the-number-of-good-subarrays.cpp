class Solution {
public:
    long long countGood(vector<int>& nums, int k) {
         std::unordered_map<int, int> freq; // Memory me elements ki frequency track karne ke liye
        int left = 0;
        long long current_pairs = 0; // Bade values ke liye long long zaroori hai
        long long ans = 0;
        int n = nums.size();
        
        for (int right = 0; right < n; right++) {
            // Rule: Naye element ke aane se kitne naye pairs bane = uski purani frequency
            current_pairs += freq[nums[right]];
            freq[nums[right]]++; // Frequency ko +1 karo
            
            // Jab tak pairs >= k hain, tab tak left se window choti karo
            while (current_pairs >= k) {
                // Counting Trick: right ke aage bache saare elements valid subarrays banayenge
                ans += (n - right);
                
                // Left pointer wale element ko window se bahar nikalo
                freq[nums[left]]--;
                // Uske jaane se jitne pairs kam hue, unhe minus karo
                current_pairs -= freq[nums[left]];
                
                left++; // Left pointer aage badhao
            }
        }
        
        return ans;
    }
};