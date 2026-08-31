class Solution {
public:
    int maxAbsoluteSum(vector<int>& nums) {
        if (nums.empty()) return 0;

        int current_profit = nums[0];
        int max_profit = nums[0];

        int current_loss = nums[0];
        int max_loss = nums[0];

        for (size_t i = 1; i < nums.size(); i++) {
            // Munafe ka hisab (Normal Kadane)
            current_profit = max(nums[i], current_profit + nums[i]);
            max_profit = max(max_profit, current_profit);

            // Nuksaan ka hisab (Inverted Kadane)
            current_loss = min(nums[i], current_loss + nums[i]);
            max_loss = min(max_loss, current_loss);
        }

        return max(abs(max_profit), abs(max_loss));
    }
};