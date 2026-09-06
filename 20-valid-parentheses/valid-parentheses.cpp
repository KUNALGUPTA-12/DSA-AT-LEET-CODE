class Solution {
public:
    bool isValid(string s) {
        // by the help of stack 
        stack<char> st;
        // dono loop ke sath
        for(int i = 0;i < s.length(); i++){
            char c = s[i];
        // for(char c : s){
            // cahr agra open bracket hai toh store karo stack mai 
            if(c == '(' || c == '{' || c == '['){
                st.push(c);
            }
            // agar close hota toh
            else{
                // close bracket shurvat mai hai toh
                if(st.empty()) return false;

                if((c == ')' && st.top() == '(') || (c == '}' && st.top() == '{') || (c == ']' && st.top() == '[')){
                    st.pop();
                }
                else{
                    return false;
                }
            }

        }
        return st.empty();

        // string se kara 
        //  string ans = ""; // String ko hi stack bana diya
        
        // for (char c : s) {
        //     // Agar open bracket hai, toh string ke end (top) par push karo
        //     if (c == '(' || c == '{' || c == '[') {
        //         ans.push_back(c);
        //     } 
        //     // Agar close bracket hai
        //     else {
        //         // Close bracket aaya par string khali hai -> Invalid!
        //         if (ans.empty()) return false;
                
        //         // ans.back() se string ke sabse aakhiri (top) element ko check kiya
        //         if ((c == ')' && ans.back() == '(') || 
        //             (c == '}' && ans.back() == '{') || 
        //             (c == ']' && ans.back() == '[')) {
        //             ans.pop_back(); // Jodidar mila toh end se hata do
        //         } else {
        //             return false; // Galat jodidar -> Invalid!
        //         }
        //     }
        // }
        // // Agar aakhiri mein string khali ho gayi, toh true, nahi toh false
        // return ans.empty();
    }
};