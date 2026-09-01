class Solution {
    public int findMaxLength(int[] nums) {
         // Diary (HashMap) banayi jisme 'Level : Index' store karenge
        HashMap<Integer, Integer> registerMap = new HashMap<>();
        
        // Shuruat ka base case: Level 0 mila tha Index -1 par
        registerMap.put(0, -1); 
        
        int level = 0;
        int maxLength = 0;
        
        for (int i = 0; i < nums.length; i++) {
            // 1 aane par level +1, 0 aane par level -1
            if (nums[i] == 1) {
                level++;
            } else {
                level--;
            }
            
            // Agar yeh level Diary mein pehle se MOJUD HAI
            if (registerMap.containsKey(level)) {
                // Abhi ke index se purane index ko minus karke length nikalo
                int length = i - registerMap.get(level);
                maxLength = Math.max(maxLength, length);
            } 
            // Agar yeh level pehli baar aaya hai
            else {
                // Diary mein note karlo ki yeh level kis index par mila
                registerMap.put(level, i);
            }
        }
        
        return maxLength;
    }
}