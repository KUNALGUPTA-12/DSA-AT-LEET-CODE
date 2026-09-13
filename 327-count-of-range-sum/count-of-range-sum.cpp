class Solution {
public:
    int countRangeSum(vector<int>& nums, int lower, int upper) {
        int n = nums.size();
        // Overflow se bachne ke liye long long use kiya
        vector<long long> prefixSum(n + 1, 0);
        for (int i = 0; i < n; i++) {
            prefixSum[i + 1] = prefixSum[i] + nums[i];
        }
        
        return mergeSortCount(prefixSum, 0, n, lower, upper);
    }

private:
    int mergeSortCount(vector<long long>& sum, int start, int end, int lower, int upper) {
        if (end <= start) return 0;
        
        int mid = start + (end - start) / 2;
        // Left half aur Right half ke ranges ko alag se count karo
        int count = mergeSortCount(sum, start, mid, lower, upper) + 
                    mergeSortCount(sum, mid + 1, end, lower, upper);
        
        // Dono halves ko milate waqt cross-ranges count karo
        int lowIdx = mid + 1, highIdx = mid + 1;
        for (int i = start; i <= mid; i++) {
            // Un indices ko dhoodho jo condition satisfy karte hain
            while (lowIdx <= end && sum[lowIdx] - sum[i] < lower) lowIdx++;
            while (highIdx <= end && sum[highIdx] - sum[i] <= upper) highIdx++;
            
            count += (highIdx - lowIdx);
        }
        
        // Standard merge step to sort the array
        inplace_merge(sum.begin() + start, sum.begin() + mid + 1, sum.begin() + end + 1);
        
        return count;
    }
};