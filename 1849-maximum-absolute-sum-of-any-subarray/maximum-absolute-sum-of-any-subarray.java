class Solution {
    public int maxAbsoluteSum(int[] nums) {
        if(nums == null || nums.length == 0)return 0;
        int currentProfit = nums[0];
        int maxProfit = nums[0];

        int currentLoss = nums[0];
        int maxLoss = nums[0];

        for(int i = 1;i < nums.length;i++){
            currentProfit = Math.max(nums[i],currentProfit + nums[i]);
            maxProfit = Math.max(maxProfit,currentProfit);

            currentLoss = Math.min(nums[i], currentLoss + nums[i]);
            maxLoss = Math.min(maxLoss, currentLoss);
        }
        return Math.max(Math.abs(maxProfit), Math.abs(maxLoss));
    }
}