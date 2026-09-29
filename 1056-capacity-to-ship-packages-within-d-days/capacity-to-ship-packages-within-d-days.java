class Solution {
     private boolean isPossible(int[] weights, int days, int capacity) {
        int daysCount = 1;
        int currentWeight = 0;
        
        for (int weight : weights) {
            if (currentWeight + weight > capacity) {
                daysCount++;
                currentWeight = weight;
            } else {
                currentWeight += weight;
            }
        }
        return daysCount <= days;
    }

    public int shipWithinDays(int[] weights, int days) {
        int low = 0;
        int high = 0;
        
        for (int weight : weights) {
            low = Math.max(low, weight);
            high += weight;
        }
        
        int ans = high;
        
        while (low <= high) {
            int mid = low + (high - low) / 2;
            
            if (isPossible(weights, days, mid)) {
                ans = mid;
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return ans;
        
    }
}