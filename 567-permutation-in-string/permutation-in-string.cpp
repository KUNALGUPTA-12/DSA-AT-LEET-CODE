class Solution {
public:
    bool checkInclusion(string s1, string s2) {
        // // yah vector wala 

        //  int n1 = s1.length();
        // int n2 = s2.length();
        // if (n1 > n2) return false;
        
        // // Primitive functions jaisa behavior, fixed 26 blocks
        // vector<int> s1_count(26, 0);
        // vector<int> s2_count(26, 0);
        
        // for (int i = 0; i < n1; i++) {
        //     s1_count[s1[i] - 'a']++;
        //     s2_count[s2[i] - 'a']++;
        // }
        
        // if (s1_count == s2_count) return true;
        
        // // Fixed-size window sliding
        // for (int i = n1; i < n2; i++) {
        //     s2_count[s2[i] - 'a']++;      // New character basket mein aaya
        //     s2_count[s2[i - n1] - 'a']--; // Old character basket se gaya
            
        //     if (s1_count == s2_count) return true;
        // }
        // return false;

        // yah wala hash map ka hai

         int n1 = s1.length(), n2 = s2.length();
        if (n1 > n2) return false;

        unordered_map<char, int> s1_map;
        unordered_map<char, int> s2_map;

        for (int i = 0; i < n1; i++) {
            s1_map[s1[i]]++;
            s2_map[s2[i]]++;
        }

        if (s1_map == s2_map) return true;

        for (int i = n1; i < n2; i++) {
            s2_map[s2[i]]++; // Object method internally invoked via operator

            char old_char = s2[i - n1];
            s2_map[old_char]--;
            
            // Map Cleanup to keep comparisons precise
            if (s2_map[old_char] == 0) {
                s2_map.erase(old_char); // Class Method Calling
            }

            if (s1_map == s2_map) return true;
        }
        return false;
    }
};