class Solution {
 // Helper function jo matrix me mid se chote ya barabar elements ginta hai
    private int countLessEqual(int[][] matrix, int mid, int n) {
        int count = 0;
        int row = n - 1; // Bottom-left corner se shuru kiya
        int col = 0;
        
        while (row >= 0 && col < n) {
            if (matrix[row][col] <= mid) {
                // Agar ye chota hai, toh iske upar ke saare elements bhi chote honge
                count += (row + 1);
                col++; // Right side mud jao
            } else {
                row--; // Upar wali row me jao
            }
        }
        return count;
    }

    public int kthSmallest(int[][] matrix, int k) {
        int n = matrix.length;
        int low = matrix[0][0];         // Sabse chota element
        int high = matrix[n - 1][n - 1]; // Sabse bada element
        int ans = low;
        
        while (low <= high) {
            int mid = low + (high - low) / 2;
            
            // Agar mid se chote ya barabar elements ka count k se bada ya barabar hai
            if (countLessEqual(matrix, mid, n) >= k) {
                ans = mid;       // Potential answer save kar lo
                high = mid - 1;  // Aur chota dhoondne ke liye left jao
            } else {
                low = mid + 1;   // Guess chota hai, badhane ke liye right jao
            }
        }
        return ans;
    }
}