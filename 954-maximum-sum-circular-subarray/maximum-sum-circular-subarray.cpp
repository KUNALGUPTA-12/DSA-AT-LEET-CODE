class Solution {
public:
    int maxSubarraySumCircular(vector<int>& nums) {
     if(nums.empty()) return 0;
     int total_sum = 0;
     int current_max = 0;
     int current_min = 0;
     int max_sum = nums[0];
     int min_sum = nums[0];
    //  yah islye kiya ku ki loop 0 se start hoga na k 1 se 

    for(size_t i = 0;i < nums.size();i++){
        total_sum += nums[i];

        // normal kadane(bada sum nikale ke liye)
        current_max = max(nums[i], current_max + nums[i]);
        max_sum = max(max_sum, current_max);

        // inverted kadane (chote sum)
        current_min = min(nums[i], current_min + nums[i]);
        min_sum = min(min_sum, current_min);
    }
    // egde case for negative numbers 
    if(max_sum < 0) return max_sum;

    // sedha ans nikha circular ka 
    return max(max_sum, total_sum - min_sum);
    }
};