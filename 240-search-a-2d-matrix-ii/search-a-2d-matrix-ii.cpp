class Solution {
public:
    bool searchMatrix(vector<vector<int>>& matrix, int target) {
         if (matrix.empty() || matrix[0].empty()) return false;
        
        int m = matrix.size();    // Total rows
        int n = matrix[0].size(); // Total columns
        
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
};