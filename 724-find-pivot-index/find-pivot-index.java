class Solution {
    public int pivotIndex(int[] nums) {
        int totalSum = 0;
        int leftSum = 0;
        int n = nums.length;
        
        // Step 1: Poore array ka total sum nikal lo (Right Side tarazu)
        for (int i = 0; i < n; i++) {
            totalSum += nums[i];
        }
        
        // Step 2: Har ek index par jaakar check karo
        for (int i = 0; i < n; i++) {
            // Right side se current element ko minus karo
            totalSum -= nums[i]; 
            
            // Agar left aur right side ka sum barabar ho gaya
            if (leftSum == totalSum) {
                return i; // Mil gaya pivot index!
            }
            
            // Agar barabar nahi hai, toh ise left side mein plus kar do
            leftSum += nums[i];
        }
        return -1;
    }

}