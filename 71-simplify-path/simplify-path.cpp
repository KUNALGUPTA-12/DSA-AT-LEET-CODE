class Solution {
public:
    string simplifyPath(string path) {
        vector<string> st; // Hum vector ko hi stack ki tarah use kar rahe hain
        stringstream ss(path);
        string token;
        
        // Yeh loop string ko '/' ke basis par tod kar ek-ek tukda 'token' mein dega
        while (getline(ss, token, '/')) {
            // Agar tukda khali hai ya single dot '.' hai, toh kuch mat karo
            if (token == "" || token == ".") {
                continue;
            }
            // Agar double dot '..' aaya, toh ek kadam peeche jao (pop)
            if (token == "..") {
                if (!st.empty()) {
                    st.pop_back(); // Pichle folder ko remove kiya
                }
            } 
            // Agar koi valid naam hai (jaise 'home', '...', 'foo')
            else {
                st.push_back(token); // Stack mein folder ka naam daal do
            }
        }
        
        // Aakhiri mein saare bache hue folders ko '/' se jod kar final path banao
        string ans = "";
        for (string dir : st) {
            ans += "/" + dir;
        }
        
        // Agar stack bilkul khali tha, toh sirf "/" return karo, nahi toh ans return karo
        return ans.empty() ? "/" : ans;
    }
};