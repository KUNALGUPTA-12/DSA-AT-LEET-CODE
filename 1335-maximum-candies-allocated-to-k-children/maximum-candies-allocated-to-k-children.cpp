class Solution {
private:
    // Helper Checker Function: Check karta hai ki kya har bache ko 'candiesPerChild' dene par 'k' bacho ka kaam ho jayega?
    bool isPossible(const vector<int>& candies, long long k, long long candiesPerChild) {
        long long childrenCount = 0;
        
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

public:
    int __attribute__((no_sanitize("undefined"))) maximumCandies(vector<int>& candies, long long k) {
        // Base Case: Agar poore bagiche ki total toffees hi bacho se kam hain, toh kisi ko 1 bhi nahi milegi (0 answer)
        long long totalCandies = 0;
        for (int c : candies) {
            totalCandies += c;
        }
        if (totalCandies < k) {
            return 0;
        }
        
        int low = 1;
        int high = *max_element(candies.begin(), candies.end());
        int ans = 0;
        
        // Binary Search on Candies count
        while (low <= high) {
            int mid = low + (high - low) / 2; // Beech ki candy size guess ki
            
            if (isPossible(candies, k, mid)) {
                ans = mid;       // Answer save kiya
                low = mid + 1;   // MAXIMIZE karna hai, toh aur badi candy size check karne right jao
            } else {
                high = mid - 1;  // Bachon ki ginti kam padi, toh candy size choti karne left jao
            }
        }
        return ans;
        
    }
};