class Solution {
    // Helper function: Ek single valid block ke andar complete substrings ginta hai
    private int countForBlock(String block, int k) {
        int n = block.length();
        int count = 0;
        
        // u matlab Unique characters (Max 26 hi ho sakte hain)
        for (int u = 1; u <= 26 && u * k <= n; u++) {
            int windowSize = u * k;
            int[] freq = new int[26];
            int validChars = 0; // Kitne characters strictly K baar hain
            
            // Sliding Window setup
            for (int i = 0; i < n; i++) {
                // 1. Naya element window mein shamil karo
                int rChar = block.charAt(i) - 'a';
                freq[rChar]++;
                if (freq[rChar] == k) validChars++;
                else if (freq[rChar] == k + 1) validChars--; // K se zyada ho gaya toh invalid
                
                // 2. Window size bada ho gaya toh left se element hatao
                if (i >= windowSize) {
                    int lChar = block.charAt(i - windowSize) - 'a';
                    freq[lChar]--;
                    if (freq[lChar] == k) validChars++;
                    else if (freq[lChar] == k - 1) validChars--; // K se kam ho gaya toh invalid
                }
                
                // 3. Agar unique characters (u) ke barabar characters strictly K baar hain
                if (i >= windowSize - 1 && validChars == u) {
                    count++;
                }
            }
        }
        return count;
    }

    public int countCompleteSubstrings(String word, int k) {
        int n = word.length();
        int totalCount = 0;
        int start = 0;
        
        // Poori string ko scan karke jahan gap > 2 hai, wahan se block todo
        for (int i = 1; i <= n; i++) {
            if (i == n || Math.abs(word.charAt(i) - word.charAt(i - 1)) > 2) {
                // Ek valid block mil gaya start se lekar i-1 tak
                String block = word.substring(start, i);
                totalCount += countForBlock(block, k);
                start = i; // Agla block yahan se shuru hoga
            }
        }
        
        return totalCount;
    }
}