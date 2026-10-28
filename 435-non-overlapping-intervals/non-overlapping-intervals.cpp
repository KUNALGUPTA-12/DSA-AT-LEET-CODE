class Solution {
public:
    int eraseOverlapIntervals(vector<vector<int>>& intervals) {
         // 1. Agar koi interval nahi hai, toh 0 return karo
        if (intervals.empty()) {
            return 0;
        }
        
        // 2. Pure array ko unke End Time (index 1) ke hisab se sort karo
        sort(intervals.begin(), intervals.end(), [](const vector<int>& a, const vector<int>& b) {
            return a[1] < b[1]; 
        });
        
        int count = 0; // Cancelled meetings ka counter
        int prev_end = intervals[0][1]; // Pehli meeting ka End Time
        
        // 3. Dusri meeting (index 1) se lekar aakhri meeting tak check karo
        for (size_t i = 1; i < intervals.size(); i++) {
            // Agar current meeting ka Start Time, pichli meeting ke End Time se pehle hai
            if (intervals[i][0] < prev_end) {
                count++; // Overlap hua! Is meeting ko remove/cancel karo
            } 
            // Agar overlap nahi hai, toh meeting smoothly chalegi
            else {
                prev_end = intervals[i][1]; // Room khali hone ka naya End Time update karo
            }
        }
        
        // 4. Final answer return karo
        return count;
    }
};