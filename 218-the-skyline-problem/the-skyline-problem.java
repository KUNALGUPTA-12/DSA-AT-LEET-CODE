class Solution {
    public List<List<Integer>> getSkyline(int[][] buildings) {
        // 1. Events list declare ki
        List<int[]> events = new ArrayList<>();
        
        // 2. Saari buildings ko Start aur End events mein todo
        for (int[] b : buildings) {
            events.add(new int[]{b[0], -b[2]}); // Start Event: {Left X, -Height}
            events.add(new int[]{b[1], b[2]});  // End Event: {Right X, Height}
        }
        
        // 3. Events ko sort karo (Pehle X ke basis par, agar X same hai toh height ke basis par)
        Collections.sort(events, (a, b) -> {
            if (a[0] != b[0]) return Integer.compare(a[0], b[0]);
            return Integer.compare(a[1], b[1]);
        });
        
        List<List<Integer>> result = new ArrayList<>();
        
        // Max-Heap (PriorityQueue in descending order)
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
        maxHeap.add(0); // Zameen ki height
        int prevMax = 0;
        
        // 4. Line sweep shuru
        for (int[] ev : events) {
            int x = ev[0];
            int h = ev[1];
            
            if (h < 0) {
                maxHeap.add(-h); // Nayi building shuru hui
            } else {
                maxHeap.remove(h); // Building khatam hui
            }
            
            int currentMax = maxHeap.peek(); // Sabse unchi height abhi kya hai
            
            // 5. Agar max height badli, toh corner point mil gaya!
            if (currentMax != prevMax) {
                result.add(Arrays.asList(x, currentMax));
                prevMax = currentMax;
            }
        }
        
        return result;
    }
}