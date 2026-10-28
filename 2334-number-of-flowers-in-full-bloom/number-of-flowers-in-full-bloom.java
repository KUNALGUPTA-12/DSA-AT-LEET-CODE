class Solution {
    public int[] fullBloomFlowers(int[][] flowers, int[] people) {
         int n = flowers.length;
        int[] starts = new int[n];
        int[] ends = new int[n];
        
        // 1. Start aur End times ko alag-alag arrays mein daalo
        for (int i = 0; i < n; i++) {
            starts[i] = flowers[i][0];
            ends[i] = flowers[i][1];
        }
        
        // 2. Dono ko sort kar lo taaki Binary Search laga sakein
        Arrays.sort(starts);
        Arrays.sort(ends);
        
        int[] ans = new int[people.length];
        
        // 3. Har ek person ke liye binary search karo
        for (int i = 0; i < people.length; i++) {
            int t = people[i];
            
            // Binary Search to find count of start_times <= t
            int bloomed = binarySearchUpperBound(starts, t);
            
            // Binary Search to find count of end_times < t
            int withered = binarySearchLowerBound(ends, t);
            
            ans[i] = bloomed - withered;
        }
        
        return ans;
    }
    
    // Custom Binary Search for upper_bound (elements <= t)
    private int binarySearchUpperBound(int[] arr, int target) {
        int left = 0, right = arr.length;
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (arr[mid] <= target) left = mid + 1;
            else right = mid;
        }
        return left;
    }
    
    // Custom Binary Search for lower_bound (elements < t)
    private int binarySearchLowerBound(int[] arr, int target) {
        int left = 0, right = arr.length;
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (arr[mid] < target) left = mid + 1;
            else right = mid;
        }
        return left;
    }
}