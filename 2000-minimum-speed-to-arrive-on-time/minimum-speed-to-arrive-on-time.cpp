class Solution {
private:
    // Helper Checker Function: Check karta hai ki kya di gayi speed se time par pahunch sakte hain?
    bool isPossible(const vector<int>& dist, double hour, int speed) {
        double totalTime = 0.0;
        int n = dist.size();
        
        for (int i = 0; i < n; i++) {
            double timeTaken = (double)dist[i] / speed;
            
            // Agar yeh aakhri train nahi hai, toh time ko round-up (ceil) karna padega
            if (i < n - 1) {
                totalTime += ceil(timeTaken);
            } else {
                // Aakhri train ke liye normal float time hi add hoga
                totalTime += timeTaken;
            }
        }
        return totalTime <= hour;
    }

public:
    int minSpeedOnTime(vector<int>& dist, double hour) {
        int n = dist.size();
        // Base Case: Agar total trains 'n' hain, toh kam se kam 'n-1' ghante toh sirf pehli n-1 trains badalne mein lagenge.
        // Isliye agar total hours hi n-1 se kam ya barabar hain, toh pahunchna namumkin hai.
        if (hour <= n - 1) {
            return -1;
        }
        
        int low = 1;
        int high = 1e7; // 10^7 ko 1e7 likhte hain
        int ans = -1;
        
        while (low <= high) {
            int mid = low + (high - low) / 2; // Beech ki speed guess ki
            
            if (isPossible(dist, hour, mid)) {
                ans = mid;       // Answer save kiya
                high = mid - 1;  // Minimum speed chahiye, toh choti speed check karne left jao
            } else {
                low = mid + 1;   // Agar late ho gaye, toh speed badhane right jao
            }
        }
        return ans;
        
    }
};