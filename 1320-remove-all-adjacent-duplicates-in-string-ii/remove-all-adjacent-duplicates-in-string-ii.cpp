class Solution {
public:
    string removeDuplicates(string s, int k) {
        // stack se 
        // Hum vector ko hi stack ki tarah use kar rahe hain jo 'pair' store karega
        vector<pair<char, int>> st; 
        
        // Simple index-based loop
        for (int j = 0; j < s.length(); j++) {
            char c = s[j]; // Current character
            
            // Condition 1: Agar stack khali hai ya top element alag hai
            if (st.empty() || st.back().first != c) {
                st.push_back({c, 1}); // Naya pair daal do count 1 ke sath
            } 
            // Condition 2: Agar top element same hai
            else {
                st.back().second++; // Top waale pair ka count 1 badha do
            }
            
            // Check: Agar count 'k' ke barabar ho gaya, toh poora pair uda do
            if (st.back().second == k) {
                st.pop_back(); // Pop
            }
        }
        
        // Aakhiri mein bache hue pairs se wapas string taiyar karo
        string ans = "";
        for (int i = 0; i < st.size(); i++) {
            // Jitna count hai, utni baar us character ko answer mein jod do
            ans.append(st[i].second, st[i].first);
        }
        
        return ans;

        // // two pionters se
        // int n = s.length();
        // int i = -1; // Write pointer (VIP line manager)
        // vector<int> counts(n, 0); // Har index par character ka count yaad rakhne ke liye array
        
        // // Simple index-based loop (j se read karenge)
        // for (int j = 0; j < n; j++) {
        //     i++;
        //     s[i] = s[j]; // Character ko overwrite (write) kiya
            
        //     // Step A: Count update karo
        //     // Agar pehla element hai ya pichle element se alag hai, toh count = 1
        //     if (i == 0 || s[i] != s[i - 1]) {
        //         counts[i] = 1;
        //     } 
        //     // Agar pichle element ke bilkul same hai, toh pichle count mein +1 kar do
        //     else {
        //         counts[i] = counts[i - 1] + 1;
        //     }
            
        //     // Step B: Agar count 'k' ke barabar ho gaya -> BLAST!
        //     if (counts[i] == k) {
        //         i = i - k; // Write pointer ko 'k' kadam peeche khinch lo (Delete ho gaya)
        //     }
        // }
        
        // // Shuru se lekar i index tak jo sahi string bachi, use return kar do
        // return s.substr(0, i + 1);
    }
};