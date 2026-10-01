class Solution {
    public int[] countServers(int n, int[][] logs, int x, int[] queries) {
          int numQueries = queries.length;
        int[] ans = new int[numQueries];
        
        // 1. Queries ko unke original index ke sath store karke sort karo
        int[][] sortedQueries = new int[numQueries][2];
        for (int i = 0; i < numQueries; i++) {
            sortedQueries[i][0] = queries[i]; // Query Time
            sortedQueries[i][1] = i;          // Original Index
        }
        Arrays.sort(sortedQueries, (a, b) -> Integer.compare(a[0], b[0]));
        
        // 2. Logs ko time ke hisab se sort karo
        Arrays.sort(logs, (a, b) -> Integer.compare(a[1], b[1]));
        
        HashMap<Integer, Integer> activeServers = new HashMap<>();
        int left = 0, right = 0;
        
        // 3. Sorted queries par sliding window chalao
        for (int i = 0; i < numQueries; i++) {
            int queryTime = sortedQueries[i][0];
            int originalIdx = sortedQueries[i][1];
            
            int windowStart = queryTime - x;
            int windowEnd = queryTime;
            
            // Right pointer: Naye logs ko shamil karo
            while (right < logs.length && logs[right][1] <= windowEnd) {
                int serverId = logs[right][0];
                activeServers.put(serverId, activeServers.getOrDefault(serverId, 0) + 1);
                right++;
            }
            
            // Left pointer: Un purane logs ko nikalo
            while (left < logs.length && logs[left][1] < windowStart) {
                int serverId = logs[left][0];
                activeServers.put(serverId, activeServers.get(serverId) - 1);
                if (activeServers.get(serverId) == 0) {
                    activeServers.remove(serverId);
                }
                left++;
            }
            
            // Khali baithe servers = Total - Active
            ans[originalIdx] = n - activeServers.size();
        }
        
        return ans;
    }
}