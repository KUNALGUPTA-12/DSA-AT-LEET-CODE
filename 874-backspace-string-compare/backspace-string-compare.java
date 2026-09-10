class Solution {
    public boolean backspaceCompare(String s, String t) {
        // // with the help of two pointers but it done last of that

        // int i = s.length() - 1;
        // int j = t.length() - 1;
        
        // int skipS = 0, skipT = 0;
        
        // while (i >= 0 || j >= 0) {
        //     // String s ke liye valid character dundo piche se
        //     while (i >= 0) {
        //         if (s.charAt(i) == '#') { skipS++; i--; }
        //         else if (skipS > 0) { skipS--; i--; }
        //         else break;
        //     }
            
        //     // String t ke liye valid character dundo piche se
        //     while (j >= 0) {
        //         if (t.charAt(j) == '#') { skipT++; j--; }
        //         else if (skipT > 0) { skipT--; j--; }
        //         else break;
        //     }
            
        //     // Dono ke valid characters ko compare karo
        //     if (i >= 0 && j >= 0 && s.charAt(i) != t.charAt(j)) return false;
            
        //     // Agar ek string khatam ho gayi par dusri bachi hai
        //     if ((i >= 0) != (j >= 0)) return false;
            
        //     i--; j--;
        // }
        // return true;

        // with the help of stack using first

        StringBuilder finalS = new StringBuilder();
        StringBuilder finalT = new StringBuilder();
        
        // 1. String s ko aage se process karo
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (ch != '#') {
                finalS.append(ch); // Normal character ko add karo
            } else if (finalS.length() > 0) {
                finalS.deleteCharAt(finalS.length() - 1); // Safety check: Tabhi delete karo jab kuch bacha ho
            }
        }
        
        // 2. String t ko aage se process karo
        for (int i = 0; i < t.length(); i++) {
            char ch = t.charAt(i);
            if (ch != '#') {
                finalT.append(ch); // Normal character ko add karo
            } else if (finalT.length() > 0) {
                finalT.deleteCharAt(finalT.length() - 1); // Safety check: Tabhi delete karo jab kuch bacha ho
            }
        }
        
        return finalS.toString().equals(finalT.toString());
    }
}