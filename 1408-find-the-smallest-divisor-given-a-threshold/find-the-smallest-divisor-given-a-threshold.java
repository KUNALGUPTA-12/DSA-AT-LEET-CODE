class Solution {
    // Helper Checker Function: Check karta hai ki kya 'divisor' se sum <= threshold hai
    private boolean isPossible(int[] nums, int threshold, int divisor) {
        int sum = 0;
        for (int num : nums) {
            // Integer ceiling division ka formula: (num + divisor - 1) / divisor
            sum += (num + divisor - 1) / divisor;
        }
        return sum <= threshold;
    }

    public int smallestDivisor(int[] nums, int threshold) {
        int low = 1;
        int high = 0;
        
        for (int num : nums) {
            high = Math.max(high, num); // Max element nikala
        }
        
        int ans = high;
        
        while (low <= high) {
            int mid = low + (high - low) / 2; // Beech ka divisor guess kiya
            
            if (isPossible(nums, threshold, mid)) {
                ans = mid;       // Ans save kiya
                high = mid - 1;  // Left side jao chota dhoondne
            } else {
                low = mid + 1;   // Right side jao divisor badhane
            }
        }
        return ans;
    }
}