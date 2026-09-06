class Solution {
public:
    vector<int> dailyTemperatures(vector<int>& temperatures) {
         int n = temperatures.size();
        vector<int> ans(n, 0); // Shuruat mein sabhi positions par 0 bhar diya
        stack<int> st;          // Days ke indices (0, 1, 2...) store karne ke liye stack
        
        // Loop array ke aakhiri element se shuru hokar 0 tak piche chalega
        for (int i = n - 1; i >= 0; i--) {
            
            // WHILE LOOP: Jab tak stack khali nahi hai AUR top par baithe din ka temperature
            // aaj ke temperature se chota ya barabar hai (temperatures[st.top()] <= temperatures[i])
            // Tab tak un chote dino ko stack se hatate (pop) jao
            while (!st.empty() && temperatures[st.top()] <= temperatures[i]) {
                st.pop();
            }
            
            // Agar saare chote hatne ke baad stack khali nahi hai, matlab koi bada din mil gaya
            if (!st.empty()) {
                // Formula: Bade bade din ka index - Mera abhi ka index
                ans[i] = st.top() - i; 
            } 
            // Agar stack bilkul khali ho gaya, matlab future mein koi bada din nahi hai
            else {
                ans[i] = 0; // 0 din intezar
            }
            
            // Current index 'i' ko stack mein push karo taaki yeh left waalon ke liye future bane
            st.push(i);
        }
        
        return ans;
    }
};