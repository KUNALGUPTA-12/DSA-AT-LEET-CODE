class Solution {
    // Helper Checker Function: Check karta hai ki kya 'maxSumLimit' ke sath 'k' ya usse kam subarrays banenge?
    private boolean isPossible(int[] nums, int k, int maxSumLimit) {
        int subarrayCount = 1; // Kam se kam 1 subarray toh shuru karenge hi
        int currentSum = 0;
        
        for (int num : nums) {
            // Agar pehle se chal rahe sum mein naya element add karne par limit cross ho rahi hai
            if (currentSum + num > maxSumLimit) {
                subarrayCount++;      // Naya subarray shuru karo
                currentSum = num;     // Naye subarray ka initial sum
            } else {
                currentSum += num;    // Usi subarray mein add karte jao
            }
        }
        
        // Kya total bane subarrays allowed 'k' ke andar hain?
        return subarrayCount <= k;
    }

    public int splitArray(int[] nums, int k) {
        int low = 0;
        int high = 0;
        
        // Loop se max element aur total sum dono nikal lenge
        for (int num : nums) {
            low = Math.max(low, num);
            high += num;
        }
        
        int ans = high;
        
        // Binary Search on Subarray Sum
        while (low <= high) {
            int mid = low + (high - low) / 2; // Beech ka sum limit guess kiya
            
            if (isPossible(nums, k, mid)) {
                ans = mid;       // Ans save kiya
                high = mid - 1;  // Choti limit check karne left side jao
            } else {
                low = mid + 1;   // Limit badhane right side jao
            }
        }
        return ans;
    }
}