class Solution {
    public int minimumRecolors(String blocks, int k) {
              int currentWhites = 0;
        
        // 1. Pehli k size ki window ready ki (0 se k-1 tak)
        for (int i = 0; i < k; i++) {
            if (blocks.charAt(i) == 'W') {
                currentWhites++;
            }
        }
        
        int minOps = currentWhites; // Pehli window ka karcha safe kar liya
        
        // 2. Proper left pointer banaya jo index 0 se shuru hoga
        int left = 0; 
        
        for (int right = k; right < blocks.length(); right++) {
            // Naya element jo right side se window me enter ho raha hai
            if (blocks.charAt(right) == 'W') {
                currentWhites++;
            }
            
            // Purana element jo left pointer par hai aur window se bahar ja raha hai
            if (blocks.charAt(left) == 'W') {
                currentWhites--;
            }
            
            left++; // Window ko aage sarakane ke liye left ko khud se badhaya
            
            // Sabse kam karcha track karo
            minOps = Math.min(minOps, currentWhites);
        }
        
        return minOps;
    }
}