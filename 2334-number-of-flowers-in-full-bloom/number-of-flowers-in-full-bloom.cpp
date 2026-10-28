class Solution {
public:
    vector<int> fullBloomFlowers(vector<vector<int>>& flowers, vector<int>& people) {
        vector<int> starts, ends;
        
        // 1. Start aur End times ko alag-alag vectors mein daalo
        for (const auto& f : flowers) {
            starts.push_back(f[0]);
            ends.push_back(f[1]);
        }
        
        // 2. Dono ko sort kar lo taaki Binary Search laga sakein
        sort(starts.begin(), starts.end());
        sort(ends.begin(), ends.end());
        
        vector<int> ans;
        
        // 3. Har ek person ke liye binary search karo
        for (int t : people) {
            // Kitne phool khil chuke hain (start_time <= t)
            int bloomed = upper_bound(starts.begin(), starts.end(), t) - starts.begin();
            
            // Kitne phool murjha chuke hain (end_time < t)
            int withered = lower_bound(ends.begin(), ends.end(), t) - ends.begin();
            
            ans.push_back(bloomed - withered);
        }
        
        return ans;
    }
};