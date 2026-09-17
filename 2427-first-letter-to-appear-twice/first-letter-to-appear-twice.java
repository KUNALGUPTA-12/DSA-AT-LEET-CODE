class Solution {
    public char repeatedCharacter(String s) {
               // 26 size ka integer array banaya, shuru me sabhi dabbe me 0 hoga
        int[] letterCounts = new int[26]; // camelCase
        
        for (int i = 0; i < s.length(); i++) {
            char currentCharacter = s.charAt(i); // camelCase
            int alphabetIndex = currentCharacter - 'a'; // camelCase
            
            // Har baar character aane par uski ginti badhao
            letterCounts[alphabetIndex]++;
            
            // Agar ginti 2 ho gayi, matlab yeh pehla letter hai jo doosri baar dikha
            if (letterCounts[alphabetIndex] == 2) {
                return currentCharacter;
            }
        }
        
        return ' ';
    }
}