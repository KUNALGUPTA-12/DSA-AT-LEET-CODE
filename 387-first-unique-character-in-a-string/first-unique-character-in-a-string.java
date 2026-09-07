class Solution {
    public int firstUniqChar(String s) {
        //  // 26 size ka array aur naam 'count' rakha (Java automatic sabko 0 kar dega)
        // int[] count = new int[26]; 
        
        // // Pass 1: Frequency count update karna
        // for (int i = 0; i < s.length(); i++) {
        //     count[s.charAt(i) - 'a']++; // Character se 'a' minus karke sahi dabba dhunda
        // }
        
        // // Pass 2: Pehla unique character dhundna
        // for (int i = 0; i < s.length(); i++) {
        //     if (count[s.charAt(i) - 'a'] == 1) {
        //         return i; // Pehla 1 count wala character milte hi return
        //     }
        // }
        
        // return -1; // Agar koi unique nahi mila

        // freq wala 

        // Array ka naam 'freq' rakha, Java automatic sabko 0 kar dega
        int[] freq = new int[128]; 
        
        // Pass 1: Frequency count karna
        for (int i = 0; i < s.length(); i++) {
            freq[s.charAt(i)]++; 
        }
        
        // Pass 2: Pehla unique character dhundna
        for (int i = 0; i < s.length(); i++) {
            if (freq[s.charAt(i)] == 1) {
                return i; 
            }
        }
        
        return -1;

        // // hashmap wala 

        //  // Asli HashMap structure (shuruat mein bilkul khali)
        // HashMap<Character, Integer> freq = new HashMap<>();
        
        // // Pass 1: Frequency count update karna
        // for (int i = 0; i < s.length(); i++) {
        //     char c = s.charAt(i);
        //     // Agar c pehle se hai toh count + 1, nahi toh 0 + 1 (Initialization on the fly)
        //     freq.put(c, freq.getOrDefault(c, 0) + 1);
        // }
        
        // // Pass 2: Pehla unique character dhundna
        // for (int i = 0; i < s.length(); i++) {
        //     if (freq.get(s.charAt(i)) == 1) {
        //         return i; 
        //     }
        // }
        
        // return -1;
    }
}