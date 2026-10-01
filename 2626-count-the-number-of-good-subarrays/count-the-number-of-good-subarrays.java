class Solution {
    public long countGood(int[] nums, int k) {
         HashMap<Integer, Integer> freq = new HashMap<>(); // Memory me frequency track karne ke liye
        int left = 0;
        long currentPairs = 0; // Java me long data type overflow se bachata hai
        long ans = 0;
        int n = nums.length;
        
        for (int right = 0; right < n; right++) {
            int rightElement = nums[right];
            // Rule: Naye element ke aane se kitne naye pairs bane = uski purani frequency
            currentPairs += freq.getOrDefault(rightElement, 0);
            freq.put(rightElement, freq.getOrDefault(rightElement, 0) + 1);
            
            // Jab tak pairs >= k hain, tab tak left se window choti karo
            while (currentPairs >= k) {
                // Counting Trick: right ke aage bache saare elements valid subarrays banayenge
                ans += (n - right);
                
                int leftElement = nums[left];
                // Left pointer wale element ki frequency ek kam karo
                freq.put(leftElement, freq.get(leftElement) - 1);
                // Uske jaane se jitne pairs kam hue, unhe minus karo
                currentPairs -= freq.get(leftElement);
                
                left++; // Left pointer aage badhao
            }
        }
        
        return ans;
    }
}