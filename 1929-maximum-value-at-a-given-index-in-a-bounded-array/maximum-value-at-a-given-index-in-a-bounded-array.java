class Solution {
    // Helper function: Yeh di gayi peak value (target) ke liye total array ka minimum sum nikalta hai
    private long getSum(long elements, long value) {
        long sum = 0;
        
        if (value >= elements) {
            long fullSum = (value * (value + 1)) / 2;
            long remainingSum = ((value - elements) * (value - elements + 1)) / 2;
            sum = fullSum - remainingSum;
        } else {
            long fullSum = (value * (value + 1)) / 2;
            long ones = elements - value;
            sum = fullSum + ones;
        }
        return sum;
    }

    private boolean isPossible(int n, int index, int maxSum, int target) {
        long leftElements = index;
        long rightElements = n - index - 1;
        
        long leftSum = getSum(leftElements, target - 1);
        long rightSum = getSum(rightElements, target - 1);
        
        long totalSum = leftSum + target + rightSum;
        
        return totalSum <= maxSum;
    }

    public int maxValue(int n, int index, int maxSum) {
        int low = 1;
        int high = maxSum;
        int ans = 1;
        
        while (low <= high) {
            int mid = low + (high - low) / 2; // Beech ki peak value guess ki
            
            if (isPossible(n, index, maxSum, mid)) {
                ans = mid;       // Ans save kiya
                low = mid + 1;   // Badi value dhoondne right side jao
            } else {
                high = mid - 1;  // Choti value dhoondne left side jao
            }
        }
        return ans;
        
    }
}