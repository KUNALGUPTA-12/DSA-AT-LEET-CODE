class Solution {
public:
    bool isCovered(vector<vector<int>>& ranges, int left, int right) {
         // Question ke constraints ke mutabik numbers max 50 tak hi ho sakte hain
        // Isliye humne 51 size ka array liya (0-indexed hota hai)
        vector<bool> visited(52, false);
        
        // 1. Har ek range ke andar ke points ko true mark karo
        for (int i = 0; i < ranges.size(); i++) {
            int start = ranges[i][0]; // Range ka shuruat
            int end = ranges[i][1];   // Range ka khatma
            
            for (int j = start; j <= end; j++) {
                visited[j] = true; // Yeh point covered hai!
            }
        }
        
        // 2. Check karo kya left se right tak ka koi number miss toh nahi hua?
        for (int i = left; i <= right; i++) {
            if (visited[i] == false) {
                return false; // Ek bhi number chhut gaya toh seedha false!
            }
        }
        
        // Agar loop bina ruke poora chal gaya, matlab sab covered hain
        return true;
    }
};