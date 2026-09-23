class Solution {
    public int findKthPositive(int[] arr, int k) {
        // Edge Case: Agar k zero ya negative hai toh positive missing number 0 hi hoga
        if (k <= 0) {
            return 0;
        }

        int low = 0;
        int high = arr.length - 1;

        while (low <= high) {
            int mid = low + (high - low) / 2;
            int missing = arr[mid] - (mid + 1);

            if (missing < k) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        
        return low + k;
    }
}