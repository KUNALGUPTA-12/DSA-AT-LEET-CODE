class Solution {
private:
    // Helper Checker Function: Check karta hai ki kya 'divisor' se sum <= threshold hai
    bool isPossible(const vector<int>& nums, int threshold, int divisor) {
        int sum = 0;
        for (int num : nums) {
            // C++ mein ceil() float/double par kaam karta hai, ya fir hum integer math use kar sakte hain:
            // (num + divisor - 1) / divisor halanki ceiling division ka shortcut hai
            sum += (num + divisor - 1) / divisor;
        }
        return sum <= threshold;
    }

public:
    int smallestDivisor(vector<int>& nums, int threshold) {
        int low = 1;
        int high = *max_element(nums.begin(), nums.end());
        int ans = high;
        
        while (low <= high) {
            int mid = low + (high - low) / 2; // Beech ka divisor guess kiya
            
            if (isPossible(nums, threshold, mid)) {
                ans = mid;       // Ans save kiya
                high = mid - 1;  // Smallest chahiye, toh chota dhoondne left jao
            } else {
                low = mid + 1;   // Sum bada ho gaya, divisor badhane right jao
            }
        }
        return ans;
    }
};