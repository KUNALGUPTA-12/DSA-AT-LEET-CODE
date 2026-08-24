class Solution {
    public int longestOnes(int[] nums, int k) {
        // code 1 
        // int[] freq = new int[2];
        // int n = nums.length,maxLen = 0,left = 0;
        // for(int r = 0;r < n;r++){
        //     freq[nums[r]]++;
        //     while(freq[0] > k){
        //         freq[nums[left++]]--;
        //     }maxLen = Math.max(maxLen,r-left+1);
        // }
        // return maxLen;
        // code 2 

        // int n = nums.length,maxLen = 0,left = 0,zeroCount = 0;
        // for(int r = 0;r < n;r++){
        //     if(nums[r] == 0)zeroCount++;
        //     while(zeroCount > k){
        //         if(nums[left++] == 0){
        //             zeroCount--;
                
        //         }
        //     }
        //     maxLen = Math.max(maxLen,r-left+1);
        // }
        // return maxLen;

        // /code 3 
        int n = nums.length,maxLen = 0,left = 0,zeroCount = 0;
        for(int r = 0;r < n;r++){
            if(nums[r] == 0)zeroCount++;
            if(zeroCount > k){
                if(nums[left++] == 0){
                    zeroCount --;
                }
            }
        }
        return n - left;
    }
}