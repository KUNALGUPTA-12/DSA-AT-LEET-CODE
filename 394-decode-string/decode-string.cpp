class Solution {
public:
    string decodeString(string s) {
        stack<char> st;
        
        for (char ch : s) {
            if (ch != ']') {
                st.push(ch);
            } 
            else {
                // Step 1: '[' milne tak characters peeche jodte jao (No extra memory!)
                string word = "";
                while (st.top() != '[') {
                    word += st.top(); 
                    st.pop();
                }
                st.pop(); // '[' hatao
                reverse(word.begin(), word.end()); // Bas ek baar seedha kar do!
                
                // Step 2: Number nikalo aur ek baar seedha karo
                string numStr = "";
                while (!st.empty() && isdigit(st.top())) {
                    numStr += st.top();
                    st.pop();
                }
                reverse(numStr.begin(), numStr.end());
                int k = stoi(numStr);
                
                // Step 3: Repeat karke stack mein daalo
                while (k--) {
                    for (char c : word) {
                        st.push(c);
                    }
                }
            }
        }
        
        // Step 4: Final answer ko bhi peeche jod kar ek baar reverse kar do
        string ans = "";
        while (!st.empty()) {
            ans += st.top();
            st.pop();
        }
        reverse(ans.begin(), ans.end());
        
        return ans;
    }
};
