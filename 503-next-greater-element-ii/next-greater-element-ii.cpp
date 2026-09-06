class Solution {
public:
    vector<int> nextGreaterElements(vector<int>& nums) {
         int n = nums.size();
        vector<int> ans(n, -1); // Shuruat mein sabhi positions par -1 bhar diya
        stack<int> st;          // Elements ke indices (0, 1, 2...) store karne ke liye stack
        
        // Loop array ke double size tak piche se chalega (2*n-1 se 0 tak)
        for (int i = 2 * n - 1; i >= 0; i--) {
            int currIndex = i % n; // i ko asli array index (0 se n-1) mein badla
            
            // WHiLE LOOP: Jab tak stack khali nahi hai AUR top par baitha padosi
            // current element se chota ya barabar hai (nums[st.top()] <= nums[currIndex])
            // Tab tak chote logon ko stack se hatate (pop) jao
            while (!st.empty() && nums[st.top()] <= nums[currIndex]) {
                st.pop();
            }
            
            // Agar hum asli array range (i < n) mein pahunch gaye hain, toh answer set karo
            if (i < n) {
                // Agar saare chote hatne ke baad stack khali ho gaya, matlab koi bada nahi mila
                if (st.empty()) {
                    ans[currIndex] = -1; 
                } 
                // Agar stack khali nahi hai, toh top par baitha index hi next greater hai
                else {
                    ans[currIndex] = nums[st.top()];
                }
            }
            
            // Current index ko stack mein push karo taaki yeh left waalon ke liye padosi bane
            st.push(currIndex);
        }
        
        return ans;
    }
};