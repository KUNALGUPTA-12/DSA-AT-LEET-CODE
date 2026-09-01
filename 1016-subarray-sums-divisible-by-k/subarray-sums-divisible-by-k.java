class Solution {
    public int subarraysDivByK(int[] nums, int k) {
         // Map store karega -> <remainder, kitni_baar_aaya>
        Map<Integer, Integer> remainderFrequency = new HashMap<>();
        
        // Base Case: Shuruat mein remainder 0 ek baar aa chuka hai
        remainderFrequency.put(0, 1);
        
        int currentSum = 0;
        int subarrayCount = 0;
        int n = nums.length;
        
        for (int i = 0; i < n; i++) {
            currentSum += nums[i];
            
            // Negative numbers ko handle karne ke liye safe remainder nikalne ka tareeka
            int rem = (currentSum % k + k) % k;
            
            // Agar yeh remainder pehle diary mein dikha hai
            if (remainderFrequency.containsKey(rem)) {
                subarrayCount += remainderFrequency.get(rem);
            }
            
            // Is remainder ki frequency badhao diary mein
            remainderFrequency.put(rem, remainderFrequency.getOrDefault(rem, 0) + 1);
        }
        
        return subarrayCount;
    }
}