class Solution {
private:
    // Helper function: Yeh di gayi peak value (target) ke liye total array ka minimum sum nikalta hai
    long long getSum(long long elements, long long value) {
        long long sum = 0;
        
        // Agar value badi hai elements se, toh complete decreasing sequence banegi (jaise 5, 4, 3, 2)
        if (value >= elements) {
            long long fullSum = (value * (value + 1)) / 2;
            long long remainingSum = ((value - elements) * (value - elements + 1)) / 2;
            sum = fullSum - remainingSum;
        } 
        // Agar value choti hai, toh sequence 1 par aakar ruk jayegi aur baki sab 1-1 honge (jaise 3, 2, 1, 1, 1)
        else {
            long long fullSum = (value * (value + 1)) / 2;
            long long ones = elements - value;
            sum = fullSum + ones;
        }
        return sum;
    }

    bool isPossible(int n, int index, int maxSum, int target) {
        // Left side mein kitne elements hain
        long long leftElements = index;
        // Right side mein kitne elements hain
        long long rightElements = n - index - 1;
        
        // Kyunki target peak par hai, uske aaju-baaju se ginti ek-ek kam hogi (target - 1 se shuru)
        long long leftSum = getSum(leftElements, target - 1);
        long long rightSum = getSum(rightElements, target - 1);
        
        // Total sum = Left side ka sum + Favorite ka sum (target) + Right side ka sum
        long long totalSum = leftSum + target + rightSum;
        
        return totalSum <= maxSum;
    }

public:
    int maxValue(int n, int index, int maxSum) {
        int low = 1;
        int high = maxSum;
        int ans = 1;
        
        while (low <= high) {
            int mid = low + (high - low) / 2; // Beech ki peak value guess ki
            
            if (isPossible(n, index, maxSum, mid)) {
                ans = mid;       // Agar sum limited raha, toh answer save karo
                low = mid + 1;   // Hame MAXIMIZE karna hai, toh aur bade number dhoondne right jao
            } else {
                high = mid - 1;  // Kharcha badh gaya, toh peak choti karne left jao
            }
        }
        return ans;
    }
};