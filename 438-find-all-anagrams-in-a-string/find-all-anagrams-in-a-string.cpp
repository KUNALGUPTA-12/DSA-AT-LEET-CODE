class Solution {
public:
    vector<int> findAnagrams(string s, string p) {
        //   vector<int> result;
        
        // // Edge case: agar s ki lambai p se choti hai
        // if (s.length() < p.length()) return result;

        // // 26 size ke vectors frequency store karne ke liye
        // vector<int> p_count(26, 0);
        // vector<int> s_count(26, 0);

        // // Pehla Loop: p aur s ke starting window ka count lena
        // for (int i = 0; i < p.length(); i++) {
        //     p_count[p[i] - 'a']++;
        //     s_count[s[i] - 'a']++;
        // }

        // // Pehle window ka check
        // if (p_count == s_count) result.push_back(0);

        // // Doosra Loop: Sliding Window shuru
        // for (int i = p.length(); i < s.length(); i++) {
        //     s_count[s[i] - 'a']++; // Naya character window me aaya
            
        //     // FIXED LINE: Pehle s ka sahi index nikala, fir uska character lekar '- a' kiya
        //     s_count[s[i - p.length()] - 'a']--; // Puraana character window se bahar gaya

        //     // Har sliding step par check karo
        //     if (p_count == s_count) {
        //         result.push_back(i - p.length() + 1);
        //     }
        // }

        // return result;

        // hash map se kiya wa 

          vector<int> result;
        if (s.length() < p.length()) return result;

        unordered_map<char, int> p_map, s_map;

        // Pehla Loop: p aur s ke starting window ki frequency map me daalna
        for (int i = 0; i < p.length(); i++) {
            p_map[p[i]]++;
            s_map[s[i]]++;
        }

        // Pehle window ka check
        if (p_map == s_map) result.push_back(0);

        // Doosra Loop: Sliding Window shuru
        for (int i = p.length(); i < s.length(); i++) {
            // 1. Naya character map me add karo
            s_map[s[i]]++; 

            // 2. Puraana character map se hatao
            char old_char = s[i - p.length()];
            s_map[old_char]--;
            
            // Map clean up: Agar kisi character ka count 0 ho jaye, toh use map se erase/delete karna padega
            // taaki dono maps ka structural comparison (==) sahi se ho sake
            if (s_map[old_char] == 0) {
                s_map.erase(old_char);
            }

            // 3. Dono maps ko compare karo
            if (p_map == s_map) {
                result.push_back(i - p.length() + 1);
            }
        }

        return result;
    }
};