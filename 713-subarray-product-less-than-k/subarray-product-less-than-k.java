class Solution {
    public int numSubarrayProductLessThanK(int[] nums, int k) {

        // // code 1 
        // if(k <= 1)return 0;
        // int n = nums.length,ansCount = 0,currentProduct = 1,left = 0;
        // for(int r = 0;r < n;r++){
        //     currentProduct *= nums[r];
        //     while(currentProduct >= k){
        //         currentProduct /= nums[left++];
        //     }
        //     ansCount += (r-left+1);
        // }
        // return ansCount;

        // code 2

         if(k <= 1)return 0;
        int n = nums.length,ansCount = 0,currentProduct = 1,left = 0;
        Map<Integer,Integer> windowMap = new HashMap<>();
        for(int r = 0;r < n;r++){
            windowMap.put(r,nums[r]);
            currentProduct *= windowMap.get(r);
            while(currentProduct >= k){
                currentProduct /= windowMap.get(left);
                windowMap.remove(left);
                left++;
            }
            ansCount += (r-left+1);
        }
        return ansCount;
    }
}