class Solution {
public:
    int sumSubarrayMins(vector<int>& arr) {
        int n = arr.size();
        stack<int> st; // Yeh sirf INDEX store karega
        long long totalSum = 0;
        int MOD = 1e9 + 7;
        
        // i = 0 se n tak chalega (n par hum maanenge ki -infinity aaya taaki stack khali ho jaye)
        for (int i = 0; i <= n; i++) {
            // Jab tak stack khali na ho, aur current number stack ke top wale number se chhota ho
            while (!st.empty() && (i == n || arr[st.top()] >= arr[i])) {
                int mid = st.top(); // Jis number ka hisaab karna hai uska index
                st.pop();
                
                // Left mein kahan tak ja sakta hai
                int leftBoundary = st.empty() ? -1 : st.top();
                // Right mein kahan tak ja sakta hai (abhi wala index 'i')
                int rightBoundary = i;
                
                // Kitne subarrays mein arr[mid] sabse chhota banega:
                long long leftChoices = mid - leftBoundary;
                long long rightChoices = rightBoundary - mid;
                long long count = leftChoices * rightChoices;
                
                totalSum = (totalSum + arr[mid] * count) % MOD;
            }
            st.push(i);
        }
        
        return totalSum;
    }
};
