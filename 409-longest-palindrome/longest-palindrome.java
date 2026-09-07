class Solution {
    public int longestPalindrome(String s) {
       HashMap<Character, Integer> freq = new HashMap<>(); // Array hataya, map banaya
        
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            freq.put(c, freq.getOrDefault(c, 0) + 1); // Pass 1: Dynamic entry
        }
        
        int length = 0;
        boolean hasOdd = false;
        
        // Map ki saare values (counts) par loop chalaya
        for (int count : freq.values()) {
            length += (count / 2) * 2;
            
            if (count % 2 != 0) {
                hasOdd = true;
            }
        }
        
        if (hasOdd) length += 1;
        return length;

        // // by vector
        //  int[] freq = new int[128]; // Correct syntax [128] ke sath fixed array
        
        // for (int i = 0; i < s.length(); i++) {
        //     freq[s.charAt(i)]++; // Pass 1: Frequency calculation
        // }
        
        // int length = 0;
        // boolean hasOdd = false;
        
        // for (int count : freq) {
        //     length += (count / 2) * 2;
            
        //     if (count % 2 != 0) {
        //         hasOdd = true;
        //     }
        // }
        
        // if (hasOdd) length += 1;
        // return length;
    }
}