class Solution {
    public int maximumLengthSubstring(String s) {
         int[] count = new int[26]; // Frequency store karne ke liye array
        int left = 0, maxLen = 0;

        for (int right = 0; right < s.length(); right++) {
            count[s.charAt(right) - 'a']++; // Character ka count badhao

            // Jab tak character 2 se zyada baar hai, window ko left se chota karo
            while (count[s.charAt(right) - 'a'] > 2) {
                count[s.charAt(left) - 'a']--;
                left++;
            }

            // Sabse lambi window ki length track karo
            maxLen = Math.max(maxLen, right - left + 1);
        }

        return maxLen;
    }
}