class Solution {
public:
    int longestOnes(vector<int>& nums, int k) {
        // 1 code 

        // int n = nums.size(),zero_count = 0,left = 0,max_len = 0;
        // for(int r = 0;r < n;r++){
        //     // agar window mai phela akshar hi zero hai toh ise count mai badao
        //     if(nums[r] == 0) zero_count++;
        //     while(zero_count > k){
        //         if(nums[left++] == 0){
        //             zero_count--;
        //         }
        //     }
        //     max_len = std::max(max_len,r-left+1);
        // }
        // return max_len;

        // code 2 without while loop 

        
        // int n = nums.size(),zero_count = 0,left = 0;
        // for(int r = 0;r < n;r++){
        //     // agar phlea elment zero hai toh count ko badao
        //     if(nums[r] == 0)zero_count ++;
        //     // agar k ki limit croos hui toh loop nahi chelga
        //     if(zero_count > k){
        //         if(nums[left++] == 0) zero_count--;
        //     }
        // }
        // return n - left;

        // code third using frequency method


        int n = nums.size(),freq[2] = {0},left = 0,max_len = 0;
        for(int r = 0;r < n;r++){
            // agar phela zero hai
            freq[nums[r]]++;//if(freq[nums[r]]++ == 0);
            while(freq[0] > k){
               freq[nums[left++]]--;// if(freq[nums[left++]]-- == 0);
            }
            max_len = std::max(max_len,r-left+1);
        }
        return max_len;
    }
};