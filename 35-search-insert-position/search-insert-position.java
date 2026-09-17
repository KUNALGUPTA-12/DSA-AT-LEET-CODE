class Solution {
    public int searchInsert(int[] nums, int target) {
         int startIndex = 0; // camelCase
        int endIndex = nums.length - 1; // camelCase
        
        while (startIndex <= endIndex) {
            // Integer overflow se bachne ke liye safe formula
            int midIndex = startIndex + (endIndex - startIndex) / 2; // camelCase
            
            // Case 1: Agar target mil gaya
            if (nums[midIndex] == target) {
                return midIndex;
            }
            // Case 2: Agar target bada hai, toh right side me dhoondho
            else if (nums[midIndex] < target) {
                startIndex = midIndex + 1;
            }
            // Case 3: Agar target chota hai, toh left side me dhoondho
            else {
                endIndex = midIndex - 1;
            }
        }
        
        // Loop tootne par startIndex hi sahi insertion position (future index) hota hai
        return startIndex;
    }
}