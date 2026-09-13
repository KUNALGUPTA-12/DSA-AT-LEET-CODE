class Solution {
    public int shortestSubarray(int[] nums, int k) {
         int n = nums.length;
        
        // Overflow se bachne ke liye long array use kiya prefix sum ke liye
        long[] prefixSum = new long[n + 1];
        for (int i = 0; i < n; i++) {
            prefixSum[i + 1] = prefixSum[i] + nums[i];
        }

        Deque<Integer> dq = new ArrayDeque<>();
        int minLength = n + 1;

        for (int i = 0; i <= n; i++) {
            // FIXED: empty() ki jagah isEmpty() ka use kiya
            // 1. Target check karo aur left boundary khisakao (Sahi Subarray Milne Par)
            while (!dq.isEmpty() && prefixSum[i] - prefixSum[dq.peekFirst()] >= k) {
                minLength = Math.min(minLength, i - dq.pollFirst());
            }

            // FIXED: empty() ki jagah isEmpty() ka use kiya
            // 2. Monotonic maintenance: Badi values ko peeche se hatao (Kachra Hatao)
            while (!dq.isEmpty() && prefixSum[i] <= prefixSum[dq.peekLast()]) {
                dq.pollLast();
            }

            // Current index daal do
            dq.offerLast(i);
        }

        // Agar minLength change hi nahi hui, matlab koi subarray nahi mila, toh -1 return karo
        return minLength == n + 1 ? -1 : minLength;
    }
}