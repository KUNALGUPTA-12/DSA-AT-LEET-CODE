class Solution {
    public boolean isAnagram(String s, String t) {
        // simple 
           // Agar dono strings ki length hi alag hai, toh anagram ho hi nahi sakte
        if (s.length() != t.length()) {
            return false;
        }
        
        // Strings ko character array me badla taaki sort kar sakein
        char[] sChars = s.toCharArray(); // camelCase
        char[] tChars = t.toCharArray(); // camelCase
        
        // Alphabetical order (A to Z) me sort kiya
        Arrays.sort(sChars);
        Arrays.sort(tChars);
        
        // Check kiya ki kya sorting ke baad dono arrays barabar hain
        return Arrays.equals(sChars, tChars);
    }
}