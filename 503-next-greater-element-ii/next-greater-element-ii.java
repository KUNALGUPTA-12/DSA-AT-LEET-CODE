class Solution {
    public int[] nextGreaterElements(int[] nums) {
         int n = nums.length;
        int[] ans = new int[n];
        Arrays.fill(ans, -1); // Sabhi positions par pehle se -1 fill kar diya
        Stack<Integer> st = new Stack<>(); // Indices store karne ke liye stack
        
        // Loop double size tak piche se chalaya
        for (int i = 2 * n - 1; i >= 0; i--) {
            int currIndex = i % n; // i ko asli index mein badla
            
            // Jab tak stack khali nahi hai AUR top element chota/barabar hai, pop karo
            while (!st.isEmpty() && nums[st.peek()] <= nums[currIndex]) {
                st.pop();
            }
            
            // Asli array range (0 se n-1) mein answer note karo
            if (i < n) {
                // Agar stack khali ho gaya toh koi bada element nahi mila -> -1
                if (st.isEmpty()) {
                    ans[currIndex] = -1;
                } 
                // Agar stack mein koi bacha hai, toh st.peek() waala element hi next greater hai
                else {
                    ans[currIndex] = nums[st.peek()];
                }
            }
            
            st.push(currIndex); // Current index ko stack mein add karo
        }
        
        return ans; // Final array return kiya
    }
}