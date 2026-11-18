class Solution {
public:
    string smallestSubsequence(string s) {
    unordered_map<int,int> count;
    unordered_map<int,int> inStack;

    for(char ch : s){

       count[ch]++;
    }
    string ans = "";

    for(char ch : s){
        count[ch]--;

        if(inStack[ch]) continue;

        while(!ans.empty() && ch < ans.back() && count[ans.back()] > 0){
            inStack[ans.back()] = false;
            ans.pop_back();
        }
        ans.push_back(ch);
        inStack[ch] = true;
    }
    return ans;
    }
};