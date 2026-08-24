class Solution {
public:
    int characterReplacement(string s, int k) {
        // int n = s.length(),left = 0,max_length = 0,max_freq = 0;
        // std::vector<int> freq(26,0);
        // for(int r = 0;r < n;r++){
        //     max_freq = std::max(max_freq,++freq[s[r] - 'A']);
        //     while((r-left+1) - max_freq > k){
        //         freq[s[left++] - 'A']--;
        //     }
        //     max_length = std::max(max_length,r-left+1);
        // }
        // return max_length;

         int n = s.length(), left = 0, max_length = 0, max_freq = 0;
        std::unordered_map<char, int> freq_map; // Dynamic attendance tokri

        for (int right = 0; right < n; right++) {
            freq_map[s[right]]++; // Naya character daala aur attendance badhai
            
            // Check kiya kya yeh ab tak ka sabse zyada baar aane wala akshar hai
            max_freq = std::max(max_freq, freq_map[s[right]]);

            // Faltu Akshar (Length - max_freq) agar k se zyada hain toh shrink karo
            while ((right - left + 1) - max_freq > k) {
                freq_map[s[left]]--; // Piche wale ki ginti kam ki
                left++; // Left pointer aage badhaya
            }

            max_length = std::max(max_length, right - left + 1);
        }
        return max_length;
        
    }
};