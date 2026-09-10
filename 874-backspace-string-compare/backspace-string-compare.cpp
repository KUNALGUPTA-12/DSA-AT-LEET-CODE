class Solution {
public:
    bool backspaceCompare(string s, string t) {
        // // with the help of stack 
        // // isme stack aga se chala rha hai

        //  string finalS = "";
        // string finalT = "";
        
        // // 1. String s ko aage se process karo
        // for (char ch : s) {
        //     if (ch != '#') {
        //         finalS.push_back(ch); // Normal character ko add karo
        //     } else if (!finalS.empty()) {
        //         finalS.pop_back();    // Safety check: Khaali nahi hai tabhi piche wala delete karo
        //     }
        // }
        
        // // 2. String t ko aage se process karo
        // for (char ch : t) {
        //     if (ch != '#') {
        //         finalT.push_back(ch); // Normal character ko add karo
        //     } else if (!finalT.empty()) {
        //         finalT.pop_back();    // Safety check: Khaali nahi hai tabhi piche wala delete karo
        //     }
        // }
        
        // // Dono ka final output match karo
        // return finalS == finalT;

        // with the help of two pointers
        // isme piche se kara hai 

         int i = s.length() - 1;
        int j = t.length() - 1;
        
        int skipS = 0, skipT = 0;
        
        while (i >= 0 || j >= 0) {
            // String s ke liye valid character dundo piche se
            while (i >= 0) {
                if (s[i] == '#') { skipS++; i--; }
                else if (skipS > 0) { skipS--; i--; }
                else break;
            }
            
            // String t ke liye valid character dundo piche se
            while (j >= 0) {
                if (t[j] == '#') { skipT++; j--; }
                else if (skipT > 0) { skipT--; j--; }
                else break;
            }
            
            // Dono ke valid characters ko compare karo
            if (i >= 0 && j >= 0 && s[i] != t[j]) return false;
            
            // Agar ek string khatam ho gayi par dusri bachi hai
            if ((i >= 0) != (j >= 0)) return false;
            
            i--; j--;
        }
        return true;
    }
};