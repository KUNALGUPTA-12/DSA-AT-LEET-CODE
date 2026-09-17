class Solution {
    public int search(int[] nums, int target) {
        int startIndex = 0; // camelCase
        int endIndex = nums.length - 1; // camelCase
        
        // Jab tak start pointer, end pointer se piche ya barabar hai
        while (startIndex <= endIndex) {
            // Beech ka index nikalne ka safe tarika (overflow se bachne ke liye)
            int midIndex = startIndex + (endIndex - startIndex) / 2; // camelCase
            
            // Case 1: Agar element mil gaya
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
        
        // Agar poore loop me target nahi mila
        return -1;
    }
}