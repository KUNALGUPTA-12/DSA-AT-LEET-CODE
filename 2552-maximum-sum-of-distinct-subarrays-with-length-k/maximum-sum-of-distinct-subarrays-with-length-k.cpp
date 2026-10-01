class Solution {
public:
    long long maximumSubarraySum(vector<int>& nums, int k) {
         std::unordered_map<int, int> freq; // Elements ki frequency track karne ke liye
        long long current_sum = 0;
        long long max_sum = 0;
        
        // 1. Pehli k size ki window ready karo
        for (int i = 0; i < k; i++) {
            current_sum += nums[i];
            freq[nums[i]]++;
        }
        
        // Agar pehli window ke saare elements unique hain (yaani map ka size k hai)
        if (freq.size() == k) {
            max_sum = current_sum;
        }
        
        // 2. Window ko slide karo
        for (int right = k; right < nums.size(); right++) {
            // Naya element enter hua
            current_sum += nums[right];
            freq[nums[right]]++;
            
            // Purana element bahar nikla (index: right - k)
            int left_element = nums[right - k];
            current_sum -= left_element;
            freq[left_element]--;
            
            // Agar purane element ki frequency 0 ho gayi, toh use map se poora delete karo
            if (freq[left_element] == 0) {
                freq.erase(left_element);
            }
            
            // Agar map ka size k ke barabar hai, matlab saare elements unique hain
            if (freq.size() == k) {
                max_sum = std::max(max_sum, current_sum);
            }
        }
        
        return max_sum;
    }
};