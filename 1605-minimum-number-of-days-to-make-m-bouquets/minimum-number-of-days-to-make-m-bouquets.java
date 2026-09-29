class Solution {
     // Helper Checker Function: Yeh check karta hai ki kya 'day' tak wait karne par 'm' bouquets ban payenge?
    private boolean isPossible(int[] bloomDay, int m, int k, int day) {
        int totalBouquets = 0; // Kitne guldaste ban chuke hain
        int consecutiveFlowers = 0; // Lagatar khile hue phoolon ki chain count
        
        for (int flowerDay : bloomDay) {
            // Agar yeh phool hamare guessed 'day' tak ya usse pehle khil chuka hai
            if (flowerDay <= day) {
                consecutiveFlowers++; // Chain mein ek aur phool jud gaya
                
                // Jaise hi lagatar 'k' phool khil gaye, ek guldasta bana lo!
                if (consecutiveFlowers == k) {
                    totalBouquets++;
                    consecutiveFlowers = 0; // Naye guldaste ke liye chain phir se 0 se shuru
                }
            } else {
                // Agar beech mein koi phool nahi khila, toh lagatar wali chain toot gayi!
                consecutiveFlowers = 0; 
            }
        }
        
        // Kya banaye gaye guldaste target 'm' ke barabar ya usse zyada hain?
        return totalBouquets >= m;
    }

    public int minDays(int[] bloomDay, int m, int k) {
        // Base Condition: Agar total phool hi kam pad rahe hain, toh guldaste banana impossible hai
        // (long long) cast ya typecast isliye taaki m * k integer overflow na kare
        if ((long) m * k > bloomDay.length) {
            return -1;
        }
        
        int low = 1;
        int high = 0;
        
        // Max element nikalne ke liye loop chalaya
        for (int day : bloomDay) {
            high = Math.max(high, day);
        }
        
        int ans = -1;
        
        // Binary Search on Days
        while (low <= high) {
            int mid = low + (high - low) / 2; // Beech ka ek din guess kiya
            
            if (isPossible(bloomDay, m, k, mid)) {
                ans = mid;       // Ans save kiya
                high = mid - 1;  // Kam din check karne left side jao
            } else {
                low = mid + 1;   // Zyada wait karne ke liye right side jao
            }
        }
        
        return ans;
    }
}