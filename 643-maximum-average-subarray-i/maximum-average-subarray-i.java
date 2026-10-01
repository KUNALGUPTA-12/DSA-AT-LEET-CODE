class Solution {
    public double findMaxAverage(int[] nums, int k) {
         double currentSum = 0;
        
        // 1. Pehle k elements ka sum nikaal lo
        for (int i = 0; i < k; i++) {
            currentSum += nums[i];
        }
        
        double maxSum = currentSum;
        
        // 2. Window ko aage slide karo
        for (int i = k; i < nums.length; i++) {
            // Naya element add karo, purana minus karo
            currentSum += nums[i] - nums[i - k];
            maxSum = Math.max(maxSum, currentSum);
        }
        
        // 3. Average return karo
        return maxSum / k;
    }
}