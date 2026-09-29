class Solution {
public:
    int peakIndexInMountainArray(vector<int>& arr) {
        int low = 0;
        int high = arr.size() - 1;
        int ans = -1; // Peak index ko store karne ke liye
        
        while (low <= high) {
            int mid = low + (high - low) / 2;
            
            // Agar mid wala element agle element se bada hai,
            // iska matlab hum downward slope par hain ya khud peak par hain.
            if (arr[mid] > arr[mid + 1]) {
                ans = mid;       // Isko potential peak maan kar save kar lo
                high = mid - 1;  // Aur left me check karo ki koi isse bhi bada toh nahi
            } 
            // Agar mid wala element agle se chota hai,
            // iska matlab hum abhi pahaad chadh rahe hain (upward slope). Peak right me hai.
            else {
                low = mid + 1;   // Right side me dhoondo
            }
        }
        
        return ans; // Jo sabse behtar peak mila use return kar do
    }
};