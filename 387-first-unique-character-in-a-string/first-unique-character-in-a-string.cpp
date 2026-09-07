class Solution {
public:
    int firstUniqChar(string s) {
        // teen mathod se kiya hai 
        // first freq 
        // second hashmap
        // third count ka 26

        // std::vector<int> freq(128,0);
        
        // // pass 1
        // // for(int i = 0;i < s.length();i++){
        //     // char c = s[i];
        // for(char c : s){
        //     freq[c]++;
        // }

        // // pass two
        // for(int i = 0;i < s.length();i++){
        //     if(freq[s[i]] == 1){
        //         return i;
        //     }
        // }
        // return -1;

        // hasmap se 

        // std::unordered_map<char, int> freq;
        //  // pass 1
        // // for(int i = 0;i < s.length();i++){
        //     // char c = s[i];
        // for(char c : s){
        //     freq[c]++;
        // }

        // // pass two
        // for(int i = 0;i < s.length();i++){
        //     if(freq[s[i]] == 1){
        //         return i;
        //     }
        // }
        // return -1;

        // count 

        std::vector<int> count(26,0);

         // pass 1
        // for(int i = 0;i < s.length();i++){
            // char c = s[i];
        for(char c : s){
            count[c - 'a']++;
        }

        // pass two
        for(int i = 0;i < s.length();i++){
            if(count[s[i] - 'a'] == 1){
                return i;
            }
        }
        return -1;
    }
};