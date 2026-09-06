class Solution {
public:
    string removeKdigits(string num, int k) {
        string ans = ""; // Yeh hamara stack hai
        
        // Simple index-based loop
        for (int j = 0; j < num.length(); j++) {
            char c = num[j];
            
            // WHILE LOOP: Jab tak stack khali nahi hai, k bacha hai, AUR top element bada hai
            while (!ans.empty() && k > 0 && ans.back() > c) {
                ans.pop_back(); // Bade element ko uda do (Pop)
                k--;            // Ek deletion kam ho gaya
            }
            ans.push_back(c); // Current element ko daal do
        }
        
        // Edge Case 1: Agar k abhi bhi bacha hai (jaise "1234" ke case mein)
        while (k > 0 && !ans.empty()) {
            ans.pop_back(); // Aakhiri se bade elements hatao
            k--;
        }
        
        // Edge Case 2: Leading zeroes ko hatana (jaise "0200" ko "200" banana)
        int startIndex = 0;
        while (startIndex < ans.length() && ans[startIndex] == '0') {
            startIndex++;
        }
        
        // Shuruat ke zeroes ko chhodkar baki string cut kar lo
        string finalAns = ans.substr(startIndex);
        
        // Agar kuch nahi bacha, toh "0" return karo, nahi toh finalAns
        return finalAns.empty() ? "0" : finalAns;
    }
};