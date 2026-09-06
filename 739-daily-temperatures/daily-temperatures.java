class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        int n = temperatures.length;
        int[] ans = new int[n]; // Java mein array initialize karne par default value 0 hi hoti hai
        Stack<Integer> st = new Stack<>(); // Indices store karne ke liye stack
        
        // Loop piche se chalaya (n-1 se lekar 0 tak)
        for (int i = n - 1; i >= 0; i--) {
            
            // Jab tak stack khali nahi hai AUR top element chota/barabar hai, pop karo
            while (!st.isEmpty() && temperatures[st.peek()] <= temperatures[i]) {
                st.pop();
            }
            
            // Agar stack khali nahi hai, toh index ka difference le lo
            if (!st.isEmpty()) {
                ans[i] = st.peek() - i; // Formula: Future day index - Current index
            } 
            // Agar stack khali ho gaya toh koi warmer day nahi mila
            else {
                ans[i] = 0;
            }
            
            // Current index ko stack mein push (add) karo
            st.push(i);
        }
        
        return ans; // Final array return kiya
    }
}