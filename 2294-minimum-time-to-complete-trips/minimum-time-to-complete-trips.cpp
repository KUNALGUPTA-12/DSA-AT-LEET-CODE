class Solution {
private:
    // Helper Checker Function: Yeh check karta hai ki diye gaye 'givenTime' mein kitni trips ho pa rahi hain
    bool isPossible(vector<int>& time, long long totalTrips, long long givenTime) {
        long long actualTrips = 0;
        
        for (int t : time) {
            // givenTime mein yeh bus kitni trips poori karegi = givenTime / ek trip ka time
            actualTrips += (givenTime / t);
            
            // Agar beech loop mein hi trips target ko par kar jayein, toh aage loop chalane ki zaroorat nahi
            if (actualTrips >= totalTrips) {
                return true;
            }
        }
        return actualTrips >= totalTrips;
    }

public:
    long long minimumTime(vector<int>& time, int totalTrips) {
        // low = kam se kam 1 unit time
        long long low = 1;
        
        // high = sabse tez bus ka time * totalTrips
        // Long long casting isliye taaki integer overflow na ho
        long long min_time = *min_element(time.begin(), time.end());
        long long high = min_time * totalTrips;
        
        long long ans = high;
        
        // Binary Search on Time
        while (low <= high) {
            long long mid = low + (high - low) / 2; // Beech ka time guess kiya
            
            if (isPossible(time, totalTrips, mid)) {
                ans = mid;       // Agar is time mein target achieve ho gaya, toh ise save karo
                high = mid - 1;  // Hume MINIMUM time chahiye, toh aur kam time check karne left jao
            } else {
                low = mid + 1;   // Agar trips kam padi, toh time badhane ke liye right jao
            }
        }
        return ans;
        
    }
};