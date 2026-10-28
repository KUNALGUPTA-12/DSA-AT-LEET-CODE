class Solution {
    public long countSubarrays(int[] nums, int minK, int maxK) {
         long ans = 0;
        
        // Pointers ko track karne ke liye variables
        int badIdx = -1;  // Range se bahar wale element ka index
        int minIdx = -1;  // minK ka sabse aakhri index
        int maxIdx = -1;  // maxK ka sabse aakhri index
        
        for (int i = 0; i < nums.length; i++) {
            // 1. Agar element out of bound hai, toh badIdx update karo
            if (nums[i] < minK || nums[i] > maxK) {
                badIdx = i;
            }
            
            // 2. Agar element minK ke barabar hai
            if (nums[i] == minK) {
                minIdx = i;
            }
            
            // 3. Agar element maxK ke barabar hai
            if (nums[i] == maxK) {
                maxIdx = i;
            }
            
            // 4. Valid starting points gino aur answer mein add karo
            // Math.min(minIdx, maxIdx) ensure karta hai ki dono minK aur maxK subarray me aa chuke hain
            int validSubarraysCount = Math.min(minIdx, maxIdx) - badIdx;
            
            if (validSubarraysCount > 0) {
                ans = ans + validSubarraysCount;
            }
        }
        
        return ans;
    }
}