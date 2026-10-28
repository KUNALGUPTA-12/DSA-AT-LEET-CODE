class Solution {
public:
    int numberOfPoints(vector<vector<int>>& nums) {
        // Unique slots ko yaad rakhne ke liye set banaya
        unordered_set<int> unique_points;
        
        // 1. Yeh loop ek-ek karke saari rows (cars) par jayega
        for (int i = 0; i < nums.size(); i++) {
            
            // nums[i][0] -> i-th car ka Start Point
            int start = nums[i][0]; 
            
            // nums[i][1] -> i-th car ka End Point
            int end = nums[i][1];   
            
            // 2. Start se lekar End tak ke saare slots ko set mein insert karo
            for (int j = start; j <= end; j++) {
                unique_points.insert(j); // Set duplicate values ko apne aap hata dega
            }
        }
        
        // 3. Set ka total size hi hamara final answer hai
        return unique_points.size();
    }
};