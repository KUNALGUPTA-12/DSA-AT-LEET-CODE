class Solution {
public:
    int maxProduct(vector<int>& nums) {
        if(nums.empty()) return 0;

        int max_pro = nums[0],min_pro = nums[0],n = nums.size(),ans = nums[0];

        for(size_t i = 1;i < n;i++){//Maine size_t isiliye likha kyunki C++ mein nums.size() ek unsigned data type return karta hai (jo kabhi negative nahi ho sakta), jise size_t kehte hain
            // agar elment negative hai toh
            if(nums[i] < 0){
                swap(max_pro, min_pro);
            }
            max_pro = max(nums[i], max_pro*nums[i]);
            min_pro = min(nums[i], min_pro*nums[i]);

            ans = max(ans, max_pro);
        }
        return ans;
        // if (nums.empty()) return 0;

        // int max_prod = nums[0];
        // int min_prod = nums[0];
        // int ans = nums[0];

        // for (size_t i = 1; i < nums.size(); i++) {
        //     // Agar negative number hai toh swap identity
        //     if (nums[i] < 0) {
        //         swap(max_prod, min_prod);
        //     }

        //     max_prod = max(nums[i], max_prod * nums[i]);
        //     min_prod = min(nums[i], min_prod * nums[i]);

        //     ans = max(ans, max_prod);
        // }

        // return ans;
    }
};