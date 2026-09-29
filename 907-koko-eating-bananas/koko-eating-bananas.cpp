class Solution {
private:
    // Helper Checker Function: Check karta hai ki kya 'speed' se 'h' ghante ke andar saare kele khatam ho payenge?
    bool isPossible(const vector<int>& piles, int h, int speed) {
        long long totalHours = 0; // Kuch cases mein hours integer overflow kar sakte hain
        
        for (int pile : piles) {
            // Integer Ceiling Division Formula: (A + B - 1) / B
            // Isse bina floating point errors ke perfectly round-up hours milte hain
            totalHours += (pile + speed - 1) / speed;
            
            // Agar beech loop mein hi hours limit cross kar jayein, toh aage check karne ka koi fayda nahi
            if (totalHours > h) {
                return false;
            }
        }
        return totalHours <= h;
    }

public:
    int minEatingSpeed(vector<int>& piles, int h) {
        int low = 1;
        // high = array ka sabse bada dher (max element)
        int high = *max_element(piles.begin(), piles.end());
        int ans = high;
        
        // Binary Search on Speed
        while (low <= high) {
            int mid = low + (high - low) / 2; // Beech ki speed guess ki
            
            if (isPossible(piles, h, mid)) {
                ans = mid;       // Answer save kiya
                high = mid - 1;  // Koko ko dhime khana hai, toh choti speed dhoondne left jao
            } else {
                low = mid + 1;   // Agar late ho gayi, toh speed badhane right jao
            }
        }
        return ans;
        
    }
};