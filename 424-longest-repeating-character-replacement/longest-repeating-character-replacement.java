class Solution {
    public int characterReplacement(String s, int k) {
        // int n = s.length(),left = 0,maxLength = 0,maxFreq = 0;
        // int[] freq = new int[26];
        // for(int r = 0;r < n;r++){
        //     maxFreq = Math.max(maxFreq,++freq[s.charAt(r) - 'A']);
        //     while((r-left+1) - maxFreq > k){
        //         freq[s.charAt(left++) - 'A']--;
        //     }
        //     maxLength = Math.max(maxLength,r-left+1);
        // }
        // return maxLength;


        int n = s.length(), left = 0, maxLength = 0, maxFreq = 0;
         HashMap<Character, Integer> freqMap = new HashMap<>(); // Dynamic attendance tokri

        for (int right = 0; right < n; right++) {
            char rChar = s.charAt(right);
            // Naya character joda ya purani ginti mein +1 kiya
            freqMap.put(rChar, freqMap.getOrDefault(rChar, 0) + 1);
            
            // Check kiya kya yeh ab tak ka sabse zyada baar aane wala akshar hai
            maxFreq = Math.max(maxFreq, freqMap.get(rChar));

            // Faltu Akshar agar k se zyada hain toh window shrink karo
            while ((right - left + 1) - maxFreq > k) {
                char lChar = s.charAt(left);
                freqMap.put(lChar, freqMap.get(lChar) - 1); // Piche wale ki ginti kam ki
                left++; // Left pointer aage badhaya
            }

            maxLength = Math.max(maxLength, right - left + 1);
        }
        return maxLength;
    }
}