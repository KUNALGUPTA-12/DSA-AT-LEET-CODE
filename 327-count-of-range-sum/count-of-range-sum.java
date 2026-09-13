class Solution {
    public int countRangeSum(int[] nums, int lower, int upper) {
        int n = nums.length;
        long[] prefixSum = new long[n + 1];
        for (int i = 0; i < n; i++) {
            prefixSum[i + 1] = prefixSum[i] + nums[i];
        }
        
        return mergeSortCount(prefixSum, 0, n, lower, upper);
    }
    
    private int mergeSortCount(long[] sum, int start, int end, int lower, int upper) {
        if (end <= start) return 0;
        
        int mid = start + (end - start) / 2;
        // Left aur Right sections ka count
        int count = mergeSortCount(sum, start, mid, lower, upper) + 
                    mergeSortCount(sum, mid + 1, end, lower, upper);
        
        // Cross elements compare karne ke liye pointers
        int lowIdx = mid + 1;
        int highIdx = mid + 1;
        
        for (int i = start; i <= mid; i++) {
            while (lowIdx <= end && sum[lowIdx] - sum[i] < lower) lowIdx++;
            while (highIdx <= end && sum[highIdx] - sum[i] <= upper) highIdx++;
            
            count += (highIdx - lowIdx);
        }
        
        // Sorting the array in place (Standard Merge logic)
        long[] cache = new long[end - start + 1];
        int r = mid + 1, t = start, c = 0;
        for (int i = start; i <= mid; i++) {
            while (r <= end && sum[r] < sum[i]) {
                cache[c++] = sum[r++];
            }
            cache[c++] = sum[i];
        }
        while (r <= end) {
            cache[c++] = sum[r++];
        }
        
        System.arraycopy(cache, 0, sum, start, cache.length);
        
        return count;
    }
}