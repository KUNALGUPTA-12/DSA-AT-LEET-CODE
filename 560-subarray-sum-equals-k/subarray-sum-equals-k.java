class Solution {
    public int subarraySum(int[] nums, int k) {
         HashMap<Integer, Integer> notebook = new HashMap<>();
        notebook.put(0, 1); // Base Case: Sum 0 pehle se 1 baar aa chuka hai
        
        int currentSum = 0;
        int totalSubarrays = 0;
        
        // For-Each loop jo aapne pehle seekha tha
        for (int num : nums) {
            currentSum += num; // Jeb mein naya number jodo
            
            int bachaHuaSum = currentSum - k; // Formula: current_sum - k
            
            // Notebook mein check karo bachaHuaSum pehle aaya tha kya?
            if (notebook.containsKey(bachaHuaSum)) {
                totalSubarrays += notebook.get(bachaHuaSum); 
            }
            
            // Is currentSum ko notebook mein update karo (Purani frequency + 1)
            notebook.put(currentSum, notebook.getOrDefault(currentSum, 0) + 1);
        }
        
        return totalSubarrays;
    }
}