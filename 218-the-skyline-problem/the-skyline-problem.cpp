class Solution {
public:
    vector<vector<int>> getSkyline(vector<vector<int>>& buildings) {
        // 1. Pehle 'events' vector ko declare karna zaroori hai (Isi wajah se error aa raha tha)
        vector<pair<int, int>> events;
        
        // 2. Saari buildings ko Start aur End events mein todo
        for (const auto& b : buildings) {
            events.push_back({b[0], -b[2]}); // Start Event: {Left X, -Height}
            events.push_back({b[1], b[2]});  // End Event: {Right X, Height}
        }
        
        // 3. Events ko X-coordinate ke hisab se sort karo
        sort(events.begin(), events.end());
        
        vector<vector<int>> result;
        
        // Max-Heap ke liye multiset banaya (Zameen ki height 0 se shuru)
        multiset<int> max_heap = {0}; 
        int prev_max = 0;
        
        // 4. Line sweep shuru
        for (const auto& ev : events) {
            int x = ev.first;
            int h = ev.second;
            
            if (h < 0) {
                max_heap.insert(-h); // Nayi building shuru hui, height add karo
            } else {
                max_heap.erase(max_heap.find(h)); // Building khatam hui, height remove karo
            }
            
            // Sabse unchi height nikalna
            int current_max = *max_heap.rbegin();
            
            // 5. Agar max height badli, toh corner point mil gaya!
            if (current_max != prev_max) {
                result.push_back({x, current_max});
                prev_max = current_max; // Nayi max height ko update karo
            }
        }
        
        return result;
    }
};