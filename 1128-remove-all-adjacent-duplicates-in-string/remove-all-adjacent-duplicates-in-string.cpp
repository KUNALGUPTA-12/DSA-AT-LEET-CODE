class Solution {
public:
    string removeDuplicates(string s) {
        // "Back" ka matlab hota hai "Aakhiri Chhor" (End of the string).
        
        // yah stack ki madad se hua hai 
        // string ans = "";//yeh humara khali stack hai

        // // simple and a traditonal loop
        // for(int i = 0 ;i < s.length();i++){
        //     char c = s[i];
        // // for(char c : s){
        //     if(!ans.empty() && ans.back() == c){
        //         ans.pop_back();// du[licate ko delete karo
        //     }
        //     else{
        //         ans.push_back(c);//c mai jo hai vo stack mai dal do
        //     }
        // }
        // return ans;

        // isko two pointers approach
        int i = -1;
        for(int j = 0;j < s.length();j++){
            // agar i valid index par hai picha likha hua hai 
            if(i >= 0 && s[i]==s[j]){
                i--;
            }
            else{
                i++;
                s[i] = s[j];
            }
        }
        return s.substr(0,i+1);
    }
};