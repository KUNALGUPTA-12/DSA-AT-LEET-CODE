class Solution {
    public int pivotIndex(int[] nums) {
        // int totalSum = 0;
        // int leftSum = 0;
        // int n = nums.length;
        
        // // Step 1: Poore array ka total sum nikal lo (Right Side tarazu)
        // for (int i = 0; i < n; i++) {
        //     totalSum += nums[i];
        // }
        
        // // Step 2: Har ek index par jaakar check karo
        // for (int i = 0; i < n; i++) {
        //     // Right side se current element ko minus karo
        //     totalSum -= nums[i]; 
            
        //     // Agar left aur right side ka sum barabar ho gaya
        //     if (leftSum == totalSum) {
        //         return i; // Mil gaya pivot index!
        //     }
            
        //     // Agar barabar nahi hai, toh ise left side mein plus kar do
        //     leftSum += nums[i];
        // }
        // return -1;

        // for each loop ke mada se 
        int totalSum = 0;
        int leftSum = 0;
        
        // Step 1: Poore array ka total sum nikal lo
        for (int num : nums) {
            totalSum += num;
        }
        
        // Aapka bataya hua variable 'i' index track karne ke liye
        int i = 0; 
        
        // Step 2: Tarazu wala logic check karo
        for (int num : nums) {
            totalSum -= num; // Right side se current element hatao
            
            // Agar dono side barabar hain toh index 'i' return karo
            if (leftSum == totalSum) {
                return i; 
            }
            
            leftSum += num; // Current element ko left side mein jodo
            i++;             // Loop ki speed ke sath match karne ke liye sirf ++ kiya
        }
        
        return -1;
    }

}