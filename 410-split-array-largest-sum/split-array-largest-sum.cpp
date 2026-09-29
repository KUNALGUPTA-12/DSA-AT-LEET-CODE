class Solution {
private:
    // Helper Checker Function: Check karta hai ki kya 'maxSumLimit' ke sath 'k' ya usse kam subarrays banenge?
    bool isPossible(const vector<int>& nums, int k, int maxSumLimit) {
        int subarrayCount = 1; // Kam se kam 1 subarray toh shuru karenge hi
        int currentSum = 0;
        
        for (int num : nums) {
            // Agar pehle se chal rahe sum mein naya element add karne par limit cross ho rahi hai
            if (currentSum + num > maxSumLimit) {
                subarrayCount++;      // Naya subarray shuru karo
                currentSum = num;     // Naye subarray ka initial sum
            } else {
                currentSum += num;    // Usi subarray mein add karte jao
            }
        }
        
        // Kya total bane subarrays allowed 'k' ke andar hain?
        return subarrayCount <= k;
    }

public:
    int splitArray(vector<int>& nums, int k) {
        // low = array ka sabse bada element
        int low = *max_element(nums.begin(), nums.end());
        // high = array ke saare elements ka total sum
        int high = accumulate(nums.begin(), nums.end(), 0);
        
        int ans = high;
        
        // Binary Search on Subarray Sum
        while (low <= high) {
            int mid = low + (high - low) / 2; // Beech ka sum limit guess kiya
            
            if (isPossible(nums, k, mid)) {
                ans = mid;       // Answer save kiya
                high = mid - 1;  // Minimized chahiye, toh aur choti limit check karne left jao
            } else {
                low = mid + 1;   // Subarrays zyada ban gaye, limit badhane right jao
            }
        }
        return ans;
    }
};