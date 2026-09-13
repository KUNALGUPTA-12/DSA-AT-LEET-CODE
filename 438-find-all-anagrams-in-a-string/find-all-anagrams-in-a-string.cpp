class Solution {
public:
    vector<int> findAnagrams(string s, string p) {
          vector<int> result;
        
        // Edge case: agar s ki lambai p se choti hai
        if (s.length() < p.length()) return result;

        // 26 size ke vectors frequency store karne ke liye
        vector<int> p_count(26, 0);
        vector<int> s_count(26, 0);

        // Pehla Loop: p aur s ke starting window ka count lena
        for (int i = 0; i < p.length(); i++) {
            p_count[p[i] - 'a']++;
            s_count[s[i] - 'a']++;
        }

        // Pehle window ka check
        if (p_count == s_count) result.push_back(0);

        // Doosra Loop: Sliding Window shuru
        for (int i = p.length(); i < s.length(); i++) {
            s_count[s[i] - 'a']++; // Naya character window me aaya
            
            // FIXED LINE: Pehle s ka sahi index nikala, fir uska character lekar '- a' kiya
            s_count[s[i - p.length()] - 'a']--; // Puraana character window se bahar gaya

            // Har sliding step par check karo
            if (p_count == s_count) {
                result.push_back(i - p.length() + 1);
            }
        }

        return result;
    }
};