class Solution {
    // public boolean isVowel(char ch) {
    //     return ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u';
    // }

    // public int maxVowels(String s, int k) {
    //     int currentVowels = 0;
        
    //     // Loop 1: Pehli k size ki window ke vowels count kar lo
    //     for (int i = 0; i < k; i++) {
    //         if (isVowel(s.charAt(i))) currentVowels++;
    //     }
        
    //     int maxVowels = currentVowels;
        
    //     // Loop 2: Window ko aage slide karo
    //     for (int i = k; i < s.length(); i++) {
    //         if (isVowel(s.charAt(i))) currentVowels++;     // Naya character add karo
    //         if (isVowel(s.charAt(i - k))) currentVowels--; // Purana character minus karo
            
    //         maxVowels = Math.max(maxVowels, currentVowels);
            
    //         if (maxVowels == k) return maxVowels;  // Optimization
    //     }
        
    //     return maxVowels;

        // merge se kiya hai

        public boolean isVowel(char ch) {
        return ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u';
    }

    public int maxVowels(String s, int k) {
        int currentVowels = 0;
        int maxVowels = 0;
        
        // Sirf 1 loop index 0 se end tak
        for (int i = 0; i < s.length(); i++) {
            // Step A: Naya element hamesha add hoga
            if (isVowel(s.charAt(i))) currentVowels++;
            
            // Step B: Jab window size 'k' se cross hone lage, purana minus karo
            if (i >= k && isVowel(s.charAt(i - k))) currentVowels--;
            
            // Step C: Jab pehli valid window ban jaye, max update karna shuru karo
            if (i >= k - 1) {
                maxVowels = Math.max(maxVowels, currentVowels);
                if (maxVowels == k) return maxVowels; // Optimization
            }
        }
        
        return maxVowels;
        
    }
}