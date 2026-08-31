class Solution {
    public int maxSubarraySumCircular(int[] nums) {
        if(nums == null || nums.length == 0) return 0;
        int totalSum = 0,currentMax = 0,currentMin = 0,maxSum = nums[0],minSum = nums[0];

        for(int i = 0;i < nums.length;i++){
            totalSum += nums[i];

            currentMax = Math.max(nums[i], currentMax + nums[i]);
            maxSum = Math.max(maxSum, currentMax);

            currentMin = Math.min(nums[i], currentMin + nums[i]);
            minSum = Math.min(minSum, currentMin);
        }
        if(maxSum < 0) return maxSum;
        
        return Math.max(maxSum, totalSum - minSum);
    }
}