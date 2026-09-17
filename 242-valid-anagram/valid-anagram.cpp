class Solution {
public:
    bool isAnagram(string s, string t) {
        // simple wala tarika for complexity o(nlogn)
         // Agar length alag hai, toh pehle hi false return kar do
        if (s.length() != t.length()) {
            return false;
        }
        
        // C++ me direct string ko sort kar sakte hain
        // begin() se end() tak alphabetically arrange ho jayega
        sort(s.begin(), s.end());
        sort(t.begin(), t.end());
        
        // Agar sorting ke baad string s aur string t ek jaisi hain toh true, nahi toh false
        return s == t;
    }
};