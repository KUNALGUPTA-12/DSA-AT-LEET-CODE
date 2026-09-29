class Solution {
private:
    // Helper Checker Function: Yeh check karta hai ki kya 'day' tak wait karne par 'm' bouquets ban payenge?
    bool isPossible(vector<int>& bloomDay, int m, int k, int day) {
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

public:
    int minDays(vector<int>& bloomDay, int m, int k) {
        // Base Condition: Agar total phool hi kam pad rahe hain, toh guldaste banana impossible hai
        if ((long long)m * k > bloomDay.size()) {
            return -1;
        }
        
        // Range Setup: low = 1 din, high = jo phool sabse aakhri mein khilega (max element)
        int low = 1;
        int high = *max_element(bloomDay.begin(), bloomDay.end());
        int ans = -1;
        
        // Binary Search on Days
        while (low <= high) {
            int mid = low + (high - low) / 2; // Beech ka ek din guess kiya
            
            if (isPossible(bloomDay, m, k, mid)) {
                ans = mid;       // Agar is din par kaam ho gaya, toh ise save karo
                high = mid - 1;  // Hume MINIMUM days chahiye, toh aur pehle ka din check karne left jao
            } else {
                low = mid + 1;   // Agar phool kam pade, toh aur wait karna padega (right jao)
            }
        }
        
        return ans;
    }
};