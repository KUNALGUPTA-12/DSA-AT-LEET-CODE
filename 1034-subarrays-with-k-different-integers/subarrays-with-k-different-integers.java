class Solution {
    // Helper function: Jo 'At Most K' unique elements wale subarrays ginta hai
    private int subarraysWithAtMostK(int[] nums, int k) {
        HashMap<Integer, Integer> countMap = new HashMap<>(); // Element ki frequency track karne ke liye
        int left = 0;
        int ans = 0;
        
        for (int right = 0; right < nums.length; right++) {
            // 1. Right element ko window mein shamil karo
            countMap.put(nums[right], countMap.getOrDefault(nums[right], 0) + 1);
            
            // 2. Agar unique elements K se zyada ho gaye, toh left se window choti karo
            while (countMap.size() > k) {
                countMap.put(nums[left], countMap.get(nums[left]) - 1);
                if (countMap.get(nums[left]) == 0) {
                    countMap.remove(nums[left]); // Agar count 0 ho jaye, toh map se hata do
                }
                left++; // Left pointer ko aage badhao
            }
            
            // 3. Current right pointer par khatam hone wale saare valid subarrays ki ginti
            ans += (right - left + 1);
        }
        return ans;
    }

    public int subarraysWithKDistinct(int[] nums, int k) {
        // Formula: Exact K = AtMost(K) - AtMost(K - 1)
        return subarraysWithAtMostK(nums, k) - subarraysWithAtMostK(nums, k - 1);
    }
}