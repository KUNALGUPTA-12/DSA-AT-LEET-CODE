class Solution {
    public int mySqrt(int x) {
         if (x == 0 || x == 1) return x; // Base cases

        int low = 1, high = x, ans = 0;

        while (low <= high) {
            int mid = low + (high - low) / 2;

            // Overflow se bachne ke liye (mid * mid <= x) ki jagah (mid <= x / mid) use kiya hai
            if (mid <= x / mid) {
                ans = mid;        // Yeh ek possible answer ho sakta hai
                low = mid + 1;    // Aur bade number ke liye right side jao
            } else {
                high = mid - 1;   // Agar square bada hai toh left side jao
            }
        }
        return ans;
    }
}