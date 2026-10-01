class Solution {
public:
    double findMaxAverage(vector<int>& nums, int k) {
           double current_sum = 0;
        
        // 1. Pehle k elements ka sum nikaal lo
        for (int i = 0; i < k; i++) {
            current_sum += nums[i];
        }
        
        double max_sum = current_sum;
        
        // 2. Window ko aage slide karo
        for (int i = k; i < nums.size(); i++) {
            // Naya element add karo, purana minus karo
            current_sum += nums[i] - nums[i - k];
            max_sum = max(max_sum, current_sum);
        }
        
        // 3. Average return karo
        return max_sum / k;
    }
};