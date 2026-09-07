class Solution {
    public boolean canConstruct(String ransomNote, String magazine) {
        // // vector wala hai 
        // int[] magazineFreq = new int[128]; // Fixed size java array
        
        // // Loop 1: Magazine inventory update
        // for (int i = 0; i < magazine.length(); i++) {
        //     char magChar = magazine.charAt(i);
        //     magazineFreq[magChar]++;
        // }
        
        // // Loop 2: Ransom Note verification from magazineFreq array
        // for (int i = 0; i < ransomNote.length(); i++) {
        //     char noteChar = ransomNote.charAt(i);
            
        //     if (magazineFreq[noteChar] == 0) {
        //         return false;
        //     }
        //     magazineFreq[noteChar]--;
        // }
        
        // return true;

        // hashmap se hua hai

        HashMap<Character, Integer> magazineFreq = new HashMap<>(); // Array hata kar map banaya
        
        // Loop 1: On-the-fly key-value insertion
        for (int i = 0; i < magazine.length(); i++) {
            char magChar = magazine.charAt(i);
            magazineFreq.put(magChar, magazineFreq.getOrDefault(magChar, 0) + 1);
        }
        
        // Loop 2: Checking using map methods
        for (int i = 0; i < ransomNote.length(); i++) {
            char noteChar = ransomNote.charAt(i);
            
            // Map se value nikali (agar key nahi mili toh default 0 milega)
            if (magazineFreq.getOrDefault(noteChar, 0) == 0) {
                return false;
            }
            // Stock mein se ek piece kam kiya
            magazineFreq.put(noteChar, magazineFreq.get(noteChar) - 1);
        }
        
        return true;
    }
}