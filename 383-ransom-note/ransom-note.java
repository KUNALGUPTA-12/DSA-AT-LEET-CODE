class Solution {
    public boolean canConstruct(String ransomNote, String magazine) {
        // vector wala hai 
        int[] magazineFreq = new int[128]; // Fixed size java array
        
        // Loop 1: Magazine inventory update
        for (int i = 0; i < magazine.length(); i++) {
            char magChar = magazine.charAt(i);
            magazineFreq[magChar]++;
        }
        
        // Loop 2: Ransom Note verification from magazineFreq array
        for (int i = 0; i < ransomNote.length(); i++) {
            char noteChar = ransomNote.charAt(i);
            
            if (magazineFreq[noteChar] == 0) {
                return false;
            }
            magazineFreq[noteChar]--;
        }
        
        return true;
    }
}