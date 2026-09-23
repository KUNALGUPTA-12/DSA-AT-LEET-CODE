class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        // Base case: Agar matrix khali hai
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) return false;
        
        int m = matrix.length;       // Total Rows
        int n = matrix[0].length;    // Total Columns
        
        int low = 0;
        int high = (m * n) - 1;      // Imaginary 1D array ka aakhiri index
        
        while (low <= high) {
            int mid = low + (high - low) / 2;
            
            // Formula: 1D index ko 2D Row aur Column me badalna
            int element = matrix[mid / n][mid % n];
            
            if (element == target) {
                return true; // Target mil gaya!
            } 
            else if (element < target) {
                low = mid + 1; // Right side me dhoondho
            } 
            else {
                high = mid - 1; // Left side me dhoondho
            }
        }
        
        return false; // Agar pure loop me nahi mila
    }
}