class Solution {
public:
    vector<vector<int>> merge(vector<vector<int>>& intervals) {
        // Agar intervals khali hain, toh khali return kar do
    if (intervals.empty()) return {};

    // Step 1: Start time [0] ke basis par sort karo
    sort(intervals.begin(), intervals.end());

    // Yeh hamari "Diary" (Result vector) hai
    vector<vector<int>> merged;

    // Pehle interval (0th index) ko bina check kiye diary mein push karo
    // Takki aage wale intervals ke liye compare karne ka base mil sake
    merged.push_back(intervals[0]);

    // Loop i = 1 (dusre interval) se shuru hoga, kyunki 0th pehle se andar hai
    for (int i = 1; i < intervals.size(); i++) {
        
        // Diary ka sabse aakhri interval ka End Time [1]
        int last_end_time = merged.back()[1]; 
        
        // Naye interval ka Start Time [0] aur End Time [1]
        int current_start_time = intervals[i][0];
        int current_end_time = intervals[i][1];

        // Agar naya kaam pichle ke khatam hone se PEHLE ya USI WAQT shuru ho raha hai
        if (current_start_time <= last_end_time) {
            // Overlap hai! Diary ke sabse aakhri interval ka End Time [1] bada kar do
            merged.back()[1] = max(last_end_time, current_end_time);
        } 
        // Agar naya kaam pichle ke khatam hone ke BAAD shuru ho raha hai (No Overlap)
        else {
            // Bilkul naya interval hai, diary mein naya page jodo
            merged.push_back(intervals[i]);
        }
    }
    
    // Final merged intervals return karo
    return merged;
    }
};