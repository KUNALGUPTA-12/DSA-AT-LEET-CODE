class Solution {
   // Helper Checker Function: Yeh check karta hai ki diye gaye 'givenTime' mein kitni trips ho pa rahi hain
    private boolean isPossible(int[] time, long totalTrips, long givenTime) {
        long actualTrips = 0;
        
        for (int t : time) {
            // givenTime mein yeh bus kitni trips poori karegi = givenTime / ek trip ka time
            actualTrips += (givenTime / t);
            
            // Agar beech loop mein hi trips target ko par kar jayein, toh true return kardo
            if (actualTrips >= totalTrips) {
                return true;
            }
        }
        return actualTrips >= totalTrips;
    }

    public long minimumTime(int[] time, int totalTrips) {
        long low = 1;
        long minTime = time[0];
        
        // Sabse tez bus (minimum time wali) dhoondne ke liye loop
        for (int t : time) {
            minTime = Math.min(minTime, t);
        }
        
        // high = sabse tez bus ka time * totalTrips
        long high = minTime * totalTrips;
        long ans = high;
        
        // Binary Search on Time
        while (low <= high) {
            long mid = low + (high - low) / 2; // Beech ka time guess kiya
            
            if (isPossible(time, totalTrips, mid)) {
                ans = mid;       // Ans save kiya
                high = mid - 1;  // Kam time check karne left side jao
            } else {
                low = mid + 1;   // Time badhane ke liye right side jao
            }
        }
        return ans;
        
    }
}