class Solution {
public:
    int shortestSubarray(vector<int>& nums, int k) {
         int n = nums.size();
        // Prefix sum ke liye vector banaya, 0 index par sum 0 hoga
        // Negative elements aur bade numbers ke liye 'long long' use kiya taaki overflow na ho
        vector<long long> prefixSum(n + 1, 0);
        for (int i = 0; i < n; i++) {
            prefixSum[i + 1] = prefixSum[i] + nums[i];
        }

        deque<int> dq; // Yeh indices store karega
        int minLength = n + 1; // Shuruat me max length rakh di

        for (int i = 0; i <= n; i++) {
            // 1. Sahi Subarray Milne Par Window Choti Karo
            // Agar current sum aur purane kisi sum ka difference >= k hai, toh answer update karo
            while (!dq.empty() && prefixSum[i] - prefixSum[dq.front()] >= k) {
                minLength = min(minLength, i - dq.front());
                dq.pop_front(); // Is index ka kaam ho gaya, remove karo
            }

            // 2. Monotonic Property Maintain Karo (Kachra Hatao)
            // Agar current prefix sum purane kisi prefix sum se chota ya barabar hai,
            // toh purana waala kabhi shortest subarray nahi bana payega. Use peeche se nikal do.
            while (!dq.empty() && prefixSum[i] <= prefixSum[dq.back()]) {
                dq.pop_back();
            }

            // Current index ko deque me daal do
            dq.push_back(i);
        }

        // Agar minLength change hi nahi hui, matlab koi subarray nahi mila, toh -1 return karo
        return minLength == n + 1 ? -1 : minLength;
    }
};