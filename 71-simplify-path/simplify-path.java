class Solution {
    public String simplifyPath(String path) {
         Stack<String> st = new Stack<>();
        
        // String ko '/' ke basis par tod kar array bana liya
        String[] tokens = path.split("/");
        
        // For-each loop lagaya saare tukdon par
        for (String token : tokens) {
            // Agar khali hai ya '.' hai toh ignore karo
            if (token.equals("") || token.equals(".")) {
                continue;
            }
            // Agar '..' aaya toh ek kadam peeche hato
            if (token.equals("..")) {
                if (!st.isEmpty()) {
                    st.pop();
                }
            } 
            // Normal naam hai toh stack mein push karo
            else {
                st.push(token);
            }
        }
        
        // Stack se nikal kar wapas seedhi string banana
        StringBuilder ans = new StringBuilder();
        for (String dir : st) {
            ans.append("/").append(dir);
        }
        
        // Agar length 0 hai toh "/" de do, nahi toh bani hui string return karo
        return ans.length() == 0 ? "/" : ans.toString();
    }
}