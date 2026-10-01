class Solution {
public:
    vector<int> countServers(int n, vector<vector<int>>& logs, int x, vector<int>& queries) {
            int num_queries = queries.size();
        std::vector<int> ans(num_queries);
        
        // 1. Queries ko unke original index ke sath store karo aur sort karo
        std::vector<std::pair<int, int>> sorted_queries;
        for (int i = 0; i < num_queries; i++) {
            sorted_queries.push_back({queries[i], i});
        }
        std::sort(sorted_queries.begin(), sorted_queries.end());
        
        // 2. Logs ko time ke hisab se sort karo
        std::sort(logs.begin(), logs.end(), [](const std::vector<int>& a, const std::vector<int>& b) {
            return a[1] < b[1];
        });
        
        std::unordered_map<int, int> active_servers;
        int left = 0, right = 0;
        
        // 3. Sorted queries par sliding window chalao
        for (int i = 0; i < num_queries; i++) {
            int query_time = sorted_queries[i].first;
            int original_idx = sorted_queries[i].second;
            
            int window_start = query_time - x;
            int window_end = query_time;
            
            // Right pointer: Naye logs ko shamil karo jo window end tak hain
            while (right < logs.size() && logs[right][1] <= window_end) {
                active_servers[logs[right][0]]++;
                right++;
            }
            
            // Left pointer: Un purane logs ko nikalo jo window start se pehle ke hain
            while (left < logs.size() && logs[left][1] < window_start) {
                int server_id = logs[left][0];
                active_servers[server_id]--;
                if (active_servers[server_id] == 0) {
                    active_servers.erase(server_id);
                }
                left++;
            }
            
            // Khali baithe servers = Total - Active
            ans[original_idx] = n - active_servers.size();
        }
        
        return ans;
    }
};