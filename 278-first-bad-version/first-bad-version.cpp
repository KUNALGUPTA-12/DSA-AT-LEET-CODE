// The API isBadVersion is defined for you.
// bool isBadVersion(int version);

class Solution {
public:
    int firstBadVersion(int n) {
         int start_index = 1; // snake_case (Kyunki ginti 1 se n tak hai)
        int end_index = n;   // snake_case (Isliye n-1 nahi kiya)
        
        while (start_index <= end_index) {
            // Integer overflow se bachne ke liye safe formula
            int mid_index = start_index + (end_index - start_index) / 2; // snake_case
            
            // Agar bad version mil gaya, toh aur piche check karo left me
            if (isBadVersion(mid_index)) {
                end_index = mid_index - 1;
            } 
            // Agar sahi version hai, toh aage right me jao
            else {
                start_index = mid_index + 1;
            }
        }
        
        // Loop break hone par start_index hi sabse pehla bad version hota hai
        return start_index;
    }
};