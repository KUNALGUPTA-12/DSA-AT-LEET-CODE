class Solution {
    public int search(int[] nums, int target) {
         int left = 0;
        int right = nums.length - 1;

        while (left <= right) {
            // Overlow se bachne ke liye mid aise nikalte hain
            int mid = left + (right - left) / 2;

            // Base Case: Agar mid par hi target mil gaya
            if (nums[mid] == target) {
                return mid;
            }

            // Case 1: Check karte hain ki kya LEFT part sorted hai?
            if (nums[left] <= nums[mid]) {
                // Agar target left sorted part ke andar lay karta hai
                if (target >= nums[left] && target < nums[mid]) {
                    right = mid - 1; // Left half mein dhoondo
                } else {
                    left = mid + 1;  // Right half mein jao
                }
            } 
            // Case 2: Agar left sorted nahi hai, toh confirm RIGHT part sorted hai
            else {
                // Agar target right sorted part ke andar lay karta hai
                if (target > nums[mid] && target <= nums[right]) {
                    left = mid + 1;  // Right half mein dhoondo
                } else {
                    right = mid - 1; // Left half mein jao
                }
            }
        }

        // Agar pura loop khatam hone par bhi target nahi mila
        return -1;
    }
}