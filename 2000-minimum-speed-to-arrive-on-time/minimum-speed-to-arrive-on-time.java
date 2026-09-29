class Solution {
   // Helper Checker Function: Check karta hai ki kya di gayi speed se time par pahunch sakte hain?
    private boolean isPossible(int[] dist, double hour, int speed) {
        double totalTime = 0.0;
        int n = dist.length;
        
        for (int i = 0; i < n; i++) {
            double timeTaken = (double) dist[i] / speed;
            
            // Agar yeh aakhri train nahi hai, toh time ko round-up (ceil) karna padega
            if (i < n - 1) {
                totalTime += Math.ceil(timeTaken);
            } else {
                // Aakhri train ke liye normal float time hi add hoga
                totalTime += timeTaken;
            }
        }
        return totalTime <= hour;
    }

    public int minSpeedOnTime(int[] dist, double hour) {
        int n = dist.length;
        
        // Base Case: Agar total time n-1 se kam hai, toh n-1 trains ka waiting time hi poora nahi ho payega
        if (hour <= n - 1) {
            return -1;
        }
        
        int low = 1;
        int high = 10000000; // 10^7
        int ans = -1;
        
        while (low <= high) {
            int mid = low + (high - low) / 2; // Beech ki speed guess ki
            
            if (isPossible(dist, hour, mid)) {
                ans = mid;       // Ans save kiya
                high = mid - 1;  // Choti speed dhoondne left side jao
            } else {
                low = mid + 1;   // Speed badhane right side jao
            }
        }
        return ans;
    }
}