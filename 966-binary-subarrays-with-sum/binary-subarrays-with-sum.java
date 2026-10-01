class Solution {
    // Helper function: Yeh un subarrays ko count karta hai jinka sum <= goal ho
    private int atMost(int[] nums, int goal) {
        if (goal < 0) return 0;
        
        int left = 0;
        int currentSum = 0;
        int count = 0;
        
        for (int right = 0; right < nums.length; right++) {
            currentSum += nums[right]; // Window me naya element add karo
            
            // Agar sum goal se bada ho jaye (jaise 3 ho jaye), toh left pointer ko aage badao
            while (currentSum > goal) {
                currentSum -= nums[left];
                left++;
            }
            
            // Valid window ke saare subarrays ko count me add karo
            count += (right - left + 1);
        }
        return count;
    }

    public int numSubarraysWithSum(int[] nums, int goal) {
        // Exactly(goal) = AtMost(goal) - AtMost(goal - 1)
        return atMost(nums, goal) - atMost(nums, goal - 1);
    }
}