class Solution {
    public int equalSubstring(String s, String t, int maxCost) {
        int left = 0;
        int currentCost = 0;
        int maxLength = 0;
        
        for (int right = 0; right < s.length(); right++) {
            // Memory me s.charAt(right) aur t.charAt(right) ka ASCII difference add karo
            currentCost += Math.abs(s.charAt(right) - t.charAt(right));
            
            // Agar karcha budget se bada ho jaye, toh window ko left se chota karo
            while (currentCost > maxCost) {
                currentCost -= Math.abs(s.charAt(left) - t.charAt(left));
                left++;
            }
            
            // Sabse lambi valid substring ki length track karo
            maxLength = Math.max(maxLength, right - left + 1);
        }
        
        return maxLength;
    }
}