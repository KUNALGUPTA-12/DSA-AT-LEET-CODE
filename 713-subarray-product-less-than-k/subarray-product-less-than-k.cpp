class Solution {
public:
    int numSubarrayProductLessThanK(vector<int>& nums, int k) {
        // code with simple 

        if (k <= 1)return 0;
        int n = nums.size(),ans_count = 0,left = 0,current_product = 1;
        for(int r = 0;r < n;r++){
            current_product *= nums[r];
            
            while(current_product >= k){
                current_product /= nums[left++];
            }
            ans_count += (r-left+1);
        }
        return ans_count;

        // by hash map 

        //  if (k <= 1)return 0;
        // int n = nums.size(),ans_count = 0,left = 0,current_product = 1;
        // std::unordered_map<int,int> window_map;
        // for(int r = 0;r < n;r++){
        //     window_map[r] = nums[r];
        //     current_product *= window_map[r];

        //     while(current_product >= k){
        //         current_product /= window_map[left++];
        //     }
        //     ans_count += (r-left+1);
        // }
        // return ans_count;
    }
};