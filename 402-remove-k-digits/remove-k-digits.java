class Solution {
    public String removeKdigits(String num, int k) {
        StringBuilder ans = new StringBuilder(); // StringBuilder as Stack
        int n = num.length();
        
        for (int j = 0; j < n; j++) {
            char c = num.charAt(j);
            
            // Jab tak stack khali nahi hai aur top element bada hai, pop karo
            while (ans.length() > 0 && k > 0 && ans.charAt(ans.length() - 1) > c) {
                ans.deleteCharAt(ans.length() - 1);
                k--;
            }
            ans.append(c);
        }
        
        // Bacha hua k handle karo
        while (k > 0 && ans.length() > 0) {
            ans.deleteCharAt(ans.length() - 1);
            k--;
        }
        
        // Leading zeroes ko skip karo
        int startIndex = 0;
        while (startIndex < ans.length() && ans.charAt(startIndex) == '0') {
            startIndex++;
        }
        
        // Zeroes hatane ke baad substring nikal lo
        String finalAns = ans.substring(startIndex);
        
        // Agar khali ho jaye toh "0" de do
        return finalAns.length() == 0 ? "0" : finalAns;
    }
}