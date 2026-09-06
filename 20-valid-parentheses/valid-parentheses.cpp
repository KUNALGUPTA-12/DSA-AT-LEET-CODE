class Solution {
public:
    bool isValid(string s) {
        // // by the help of stack 
        // stack<char> st;
        // // dono loop ke sath
        // for(int i = 0;i < s.length(); i++){
        //     char c = s[i];
        // // for(char c : s){
        //     // cahr agra open bracket hai toh store karo stack mai 
        //     if(c == '(' || c == '{' || c == '['){
        //         st.push(c);
        //     }
        //     // agar close hota toh
        //     else{
        //         // close bracket shurvat mai hai toh
        //         if(st.empty()) return false;

        //         if((c == ')' && st.top() == '(') || (c == '}' && st.top() == '{') || (c == ']' && st.top() == '[')){
        //             st.pop();
        //         }
        //         else{
        //             return false;
        //         }
        //     }

        // }
        // return st.empty();

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

        // two pointers appoach se
         int i = -1; // Write pointer (Jo stack top ki tarah behave karega)
        
        // Simple index-based loop (j se read karenge)
        for (int j = 0; j < s.length(); j++) {
            char c = s[j]; // Current character uthaya
            
            // Agar open bracket hai, toh VIP line mein aage badh kar write karo
            if (c == '(' || c == '{' || c == '[') {
                i++;
                s[i] = c; // Open bracket ko overwrite kar diya
            } 
            // Agar close bracket hai
            else {
                // Close bracket aaya par VIP line bilkul khali hai (i < 0) -> Invalid!
                if (i < 0) {
                    return false;
                }
                
                // s[i] par baitha hai hamara aakhiri open bracket. Usse compare karo.
                if ((c == ')' && s[i] == '(') || 
                    (c == '}' && s[i] == '{') || 
                    (c == ']' && s[i] == '[')) {
                    i--; // Matching jodidar mila, toh pointer peeche le jao (Pop)
                } else {
                    return false; // Galat jodidar -> Invalid!
                }
            }
        }
        
        // Loop khatam hone ke baad simple if-else check
        if (i == -1) {
            return true;  // Agar i wapas -1 par aa gaya, matlab sab valid tha 🎉
        } else {
            return false; // Agar i abhi bhi >= 0 hai, matlab kuch brackets bach gaye ❌
        }
    }
};