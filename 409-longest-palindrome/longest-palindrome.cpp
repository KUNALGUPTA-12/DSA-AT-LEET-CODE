class Solution {
public:
    int longestPalindrome(string s) {
         // by vector freq method 
        vector<int> freq(128, 0);
        // for(i = 0;i < s.length();i++){
            // char c = s[i];
        for(char c : s){
            freq[c]++;
        }
        int length = 0;
        bool has_odd = false;
        for(int i = 0;i < 128;i++){
            int count = freq[i];
            length += (count / 2) * 2 ;//integer dision trick

            if(count % 2 != 0){
                has_odd = true;
            }
        }
        if(has_odd){
            length += 1;
        }
        return length;
    }
};