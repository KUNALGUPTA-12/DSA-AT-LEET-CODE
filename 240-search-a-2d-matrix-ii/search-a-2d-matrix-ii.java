class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
         if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return false;
        }
        
        int m = matrix.length;    // Total rows
        int n = matrix[0].length; // Total columns
        
        // Top-Right corner se shuru karenge
        int row = 0;
        int col = n - 1;
        
        while (row < m && col >= 0) {
            if (matrix[row][col] == target) {
                return true; // Target mil gaya!
            }
            else if (matrix[row][col] > target) {
                col--; // Element bada hai, toh left wale column me jao
            }
            else {
                row++; // Element chota hai, toh neeche wali row me jao
            }
        }
        
        return false; // Agar loop khatam ho gaya aur nahi mila
    }
}