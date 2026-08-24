class Solution {
public:
    int lengthOfLongestSubstring(string s) {
        // int n = s.size(),left = 0,max_length = 0;
        // std::vector<int>freq(128,0);
        // for(int r = 0;r < n;r++){
        //     freq[s[r]]++;
        //     while(freq[s[r]] > 1){
        //         --freq[s[left++]];
        //     }
        //     max_length = std::max(max_length,r-left+1);
        // }
        // return max_length;
        
        std::unordered_set<char> charSet;
        int n = s.size(),max_length = 0,left = 0;
        for(int r = 0;r < n;r++){
            while(charSet.count(s[r])){
                charSet.erase(s[left]);
                left++;
            }
            charSet.insert(s[r]);
            max_length = std::max(max_length,r-left+1);
        }
        return max_length;

    }
};