class Solution {
    public boolean isValid(String s) {
        Stack<Character> st = new Stack<>(); // st naam ka stack banaya
        
        // For-each loop: string ko char array mein badal kar ek-ek character 'c' mein aayega
        for (char c : s.toCharArray()) {
            // Agar open bracket hai, toh stack mein push karo
            if (c == '(' || c == '{' || c == '[') {
                st.push(c);
            } 
            // Agar close bracket hai
            else {
                // Close bracket aaya par stack khali hai -> Invalid!
                if (st.isEmpty()) return false;
                
                // st.peek() se stack ke sabse upar (top) waale element ko check kiya
                if ((c == ')' && st.peek() == '(') || 
                    (c == '}' && st.peek() == '{') || 
                    (c == ']' && st.peek() == '[')) {
                    st.pop(); // Jodidar mila toh top se hata do
                } else {
                    return false; // Galat jodidar -> Invalid!
                }
            }
        }

        return st.isEmpty();
        
        // Loop ke bahar aane ke baad simple if-else check
        // if (st.isEmpty()) {
        //     return true;  // Stack khali hai, matlab sab valid tha 🎉
        // } else {
        //     return false; // Stack khali nahi hai -> Invalid ❌
        // }

        // string builder se 
        // StringBuilder ans = new StringBuilder(); // StringBuilder ko stack banaya
        
        // for (char c : s.toCharArray()) {
        //     if (c == '(' || c == '{' || c == '[') {
        //         ans.append(c); // Element ko end mein add kiya (Push)
        //     } else {
        //         int len = ans.length();
        //         // Close bracket aaya par StringBuilder khali hai -> Invalid!
        //         if (len == 0) return false;
                
        //         // ans.charAt(len - 1) se sabse aakhiri (top) element ko check kiya
        //         if ((c == ')' && ans.charAt(len - 1) == '(') || 
        //             (c == '}' && ans.charAt(len - 1) == '{') || 
        //             (c == ']' && ans.charAt(len - 1) == '[')) {
        //             ans.deleteCharAt(len - 1); // Jodidar mila toh end se hata do (Pop)
        //         } else {
        //             return false;
        //         }
        //     }
        // }
        
        // // Simple if-else check length ke basis par
        // if (ans.length() == 0) {
        //     return true;
        // } else {
        //     return false;
        // }

        // two pointers se 
        //  char[] arr = s.toCharArray(); // In-place change karne ke liye array banaya
        // int i = -1; // Write pointer (stack top ki tarah)
        
        // for (char c : arr) {
        //     if (c == '(' || c == '{' || c == '[') {
        //         i++;
        //         arr[i] = c; // Open bracket ko array mein write kar diya
        //     } else {
        //         // Close bracket aaya par VIP line khali hai (i < 0) -> Invalid!
        //         if (i < 0) return false;
                
        //         // arr[i] par baitha hai hamara aakhiri open bracket
        //         if ((c == ')' && arr[i] == '(') || 
        //             (c == '}' && arr[i] == '{') || 
        //             (c == ']' && arr[i] == '[')) {
        //             i--; // Match ho gaya, pointer peeche le jao (Pop)
        //         } else {
        //             return false;
        //         }
        //     }
        // }
        
        // // i wapas -1 par aa gaya matlab saare brackets clear ho gaye (Empty)
        // if (i == -1) {
        //     return true;
        // } else {
        //     return false;
        // }
    }
}