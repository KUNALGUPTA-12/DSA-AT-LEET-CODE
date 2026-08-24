class Solution {
public:
    string minWindow(string s, string t) {
        int m = s.length(), n = t.length();
        if(m < n) return "";

        vector<int> target_freq(128,0);
        // agar simple array mai karna hota toh
        // int target_freq[128] = {0};
        vector<int> window_freq(128,0);

        int left = 0,match_count = 0,start_idx = -1,min_len = INT_MAX;
        string ans = "";

        // loop mai freq ki upated karna in a t string

        for(char c : t){
            target_freq[c]++;
        }
        for(int r = 0;r < m;r++){
            char r_char = s[r] ;
            window_freq[r_char]++;

            if(target_freq[r_char] > 0 && window_freq[r_char] <= target_freq[r_char]){
                match_count++;
            }
            // main content

            while(match_count == n){
                if(r - left + 1 < min_len){
                    min_len = r - left + 1;
                    start_idx = left;
                    // ans = s.substr(left , min_len);
                }

                char l_char = s[left];
                window_freq[l_char]--;

                if(target_freq[l_char] > 0 && window_freq[l_char] < target_freq[l_char]){
                    match_count--;
                }
                left++;
            }
            //  ------------------------------
        }
        return(start_idx == -1)? "" : s.substr(start_idx,min_len);

        // return (min_len == INT_MAX)? "" : ans;ise memory excess ayga
    }
};