class Solution {
public:
    int countGoodSubstrings(string s) {
        int count = 0;
        int n = s.length();
        
        // Agar string 3 se choti hai toh koi 3 length ki substring nahi banegi
        if (n < 3) return 0;
        
        // Loop 'n - 3' tak hi chalega taaki i + 2 boundary se bahar na jaye
        for (int i = 0; i <= n - 3; i++) {
            char a = s[i];
            char b = s[i + 1];
            char c = s[i + 2];
            
            // Agar teeno characters alag-alag hain (Unique hain)
            if (a != b && b != c && a != c) {
                count++; // Ek valid substring mil gayi
            }
        }
        
        return count;
    }
};