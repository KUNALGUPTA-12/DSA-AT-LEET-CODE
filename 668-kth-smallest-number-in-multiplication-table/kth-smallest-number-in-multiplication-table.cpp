class Solution {
private:
    // Helper function jo bina matrix banaye maths se elements ginta hai
    int countLessEqual(int mid, int m, int n) {
        int count = 0;
        for (int i = 1; i <= m; i++) {
            // i-th row me mid se chote ya barabar elements kitne honge? mid / i
            // Lekin wo column size 'n' se bada nahi ho sakta
            count += min(mid / i, n);
        }
        return count;
    }

public:
    int findKthNumber(int m, int n, int k) {
        int low = 1;
        int high = m * n;
        int ans = high;
        
        while (low <= high) {
            int mid = low + (high - low) / 2;
            
            // Agar mid se chote ya barabar elements k se bade ya barabar hain
            if (countLessEqual(mid, m, n) >= k) {
                ans = mid;       // Potential answer save karo
                high = mid - 1;  // Aur chota dhoondne ke liye left jao
            } else {
                low = mid + 1;   // Guess chota hai, right jao
            }
        }
        return ans;

    }
};