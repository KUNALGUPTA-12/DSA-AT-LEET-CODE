class Solution {
    public long maximumSubarraySum(int[] nums, int k) {
        HashMap<Integer, Integer> freq = new HashMap<>(); // Elements ki frequency track karne ke liye
        long currentSum = 0;
        long maxSum = 0;
        
        // 1. Pehli k size ki window ready karo
        for (int i = 0; i < k; i++) {
            currentSum += nums[i];
            freq.put(nums[i], freq.getOrDefault(nums[i], 0) + 1);
        }
        
        // Agar pehli window ke saare elements unique hain (yaani map ka size k hai)
        if (freq.size() == k) {
            maxSum = currentSum;
        }
        
        // 2. Window ko slide karo
        for (int right = k; right < nums.length; right++) {
            // Naya element enter hua
            currentSum += nums[right];
            freq.put(nums[right], freq.getOrDefault(nums[right], 0) + 1);
            
            // Purana element bahar nikla (index: right - k)
            int leftElement = nums[right - k];
            currentSum -= leftElement;
            freq.put(leftElement, freq.get(leftElement) - 1);
            
            // Agar purane element ki frequency 0 ho gayi, toh use map se poora delete karo
            if (freq.get(leftElement) == 0) {
                freq.remove(leftElement);
            }
            
            // Agar map ka size k ke barabar hai, matlab saare elements unique hain
            if (freq.size() == k) {
                maxSum = Math.max(maxSum, currentSum);
            }
        }
        
        return maxSum;
    }
}