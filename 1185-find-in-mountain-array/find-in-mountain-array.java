/**
 * // This is MountainArray's API interface.
 * // You should not implement it, or speculate about its implementation
 * interface MountainArray {
 *     public int get(int index) {}
 *     public int length() {}
 * }
 */
 
class Solution {
    public int findInMountainArray(int target, MountainArray mountainArr) {
         int n = mountainArr.length();
        
        // Step 1: Find the Peak Element Index
        int low = 0;
        int high = n - 1;
        int peak = 0;
        while (low < high) {
            int mid = low + (high - low) / 2;
            if (mountainArr.get(mid) < mountainArr.get(mid + 1)) {
                low = mid + 1;
            } else {
                high = mid;
            }
        }
        peak = low; // Pahad ki choti mil gayi
        
        // Step 2: Left side me normal Binary Search (Increasing Order)
        low = 0;
        high = peak;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            int val = mountainArr.get(mid);
            if (val == target) return mid; // Pehla index mil gaya to return karo
            else if (val < target) low = mid + 1;
            else high = mid - 1;
        }
        
        // Step 3: Right side me Reverse Binary Search (Decreasing Order)
        low = peak + 1;
        high = n - 1;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            int val = mountainArr.get(mid);
            if (val == target) return mid;
            // Kyunki ye decreasing order hai, isliye logic ulta hoga
            else if (val > target) low = mid + 1; // Bada hai to aage jao kyunki aage chote number hain
            else high = mid - 1;
        }
        
        return -1; // Agar pure pahad me target nahi mila
    }
}