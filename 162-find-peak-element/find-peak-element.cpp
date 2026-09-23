class Solution {
public:
    int findPeakElement(vector<int>& nums) {
         int low = 0;
        int high = nums.size() - 1;
        
        // Binary Search Loop
        while (low < high) {
            int mid = low + (high - low) / 2;
            
            // Agar mid wala element apne agle element se chota hai,
            // matlab hum chadhai (slope) par hain aur peak right side me hai.
            if (nums[mid] < nums[mid + 1]) {
                low = mid + 1;
            } 
            // Agar mid wala element bada ya barabar hai,
            // matlab peak left side me hai ya mid khud peak hai.
            else {
                high = mid;
            }
        }
        
        // Loop khatam hone par low aur high dono ek hi peak par rukenge.
        return low;
    }
};