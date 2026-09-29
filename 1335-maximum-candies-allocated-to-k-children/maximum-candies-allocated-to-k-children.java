class Solution {
     // Helper Checker Function: Check karta hai ki kya har bache ko 'candiesPerChild' dene par 'k' bacho ka kaam ho jayega?
    private boolean isPossible(int[] candies, long k, long candiesPerChild) {
        long childrenCount = 0;
        
        for (int pile : candies) {
            // Is pile se kitne bacho ko candies mil sakti hain
            childrenCount += (pile / candiesPerChild);
            
            // Agar beech loop mein hi bacho ki ginti target 'k' ko par kar jaye, toh true return kardo
            if (childrenCount >= k) {
                return true;
            }
        }
        return childrenCount >= k;
    }

    public int maximumCandies(int[] candies, long k) {
        long totalCandies = 0;
        int high = 0;
        
        // Loop se total sum aur max element dono ek sath nikal lenge
        for (int c : candies) {
            totalCandies += c;
            high = Math.max(high, c);
        }
        
        // Base Case: Agar total toffees hi bacho se kam hain, toh 0 return karo
        if (totalCandies < k) {
            return 0;
        }
        
        int low = 1;
        int ans = 0;
        
        // Binary Search on Candies count
        while (low <= high) {
            int mid = low + (high - low) / 2; // Beech ki candy size guess ki
            
            if (isPossible(candies, k, mid)) {
                ans = mid;       // Ans save kiya
                low = mid + 1;   // Badi candy size dhoondne right side jao
            } else {
                high = mid - 1;  // Candy size chota karne left side jao
            }
        }
        return ans;
    }
}