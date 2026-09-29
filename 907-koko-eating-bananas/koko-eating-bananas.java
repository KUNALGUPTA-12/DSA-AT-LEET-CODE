class Solution {
       // Helper Checker Function: Check karta hai ki kya 'speed' se 'h' ghante ke andar saare kele khatam ho payenge?
    private boolean isPossible(int[] piles, int h, int speed) {
        long totalHours = 0;
        
        for (int pile : piles) {
            // Integer Ceiling Division Formula: (A + B - 1) / B
            totalHours += (long)(pile + speed - 1) / speed;
            
            if (totalHours > h) {
                return false;
            }
        }
        return totalHours <= h;
    }

    public int minEatingSpeed(int[] piles, int h) {
        int low = 1;
        int high = 0;
        
        // Loop se max element nikalenge
        for (int pile : piles) {
            high = Math.max(high, pile);
        }
        
        int ans = high;
        
        // Binary Search on Speed
        while (low <= high) {
            int mid = low + (high - low) / 2; // Beech ki speed guess ki
            
            if (isPossible(piles, h, mid)) {
                ans = mid;       // Ans save kiya
                high = mid - 1;  // Choti speed dhoondne left side jao
            } else {
                low = mid + 1;   // Speed badhane right side jao
            }
        }
        return ans;
    }
}