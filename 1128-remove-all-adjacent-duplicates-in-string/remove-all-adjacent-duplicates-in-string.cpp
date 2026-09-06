class Solution {
public:
    string removeDuplicates(string s) {
        // "Back" ka matlab hota hai "Aakhiri Chhor" (End of the string).
        
        // yah stack ki madad se hua hai 
        string ans = "";//yeh humara khali stack hai

        // for(char i = 0 ;i < s.length();i++){
        for(char c : s){
            if(!ans.empty() && ans.back() == c){
                ans.pop_back();// du[licate ko delete karo
            }
            else{
                ans.push_back(c);//c mai jo hai vo stack mai dal do
            }
        }
        return ans;
    }
};