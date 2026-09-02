class Solution {
    public int[][] merge(int[][] intervals) {
         if (intervals.length == 0) return new int[0][0];

        // Step 1: Start time [0] ke basis par sort karo
        Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));

        // Yeh hamari "Diary" (ArrayList) hai
        List<int[]> merged = new ArrayList<>();
        
        // Pehle interval (0th index) ko diary mein daal do
        merged.add(intervals[0]);

        // Loop i = 1 se shuru hoga
        for (int i = 1; i < intervals.length; i++) {
            
            // Diary ka sabse aakhri interval uthao
            int[] last_interval = merged.get(merged.size() - 1);
            
            // Us aakhri interval ka End Time [1]
            int last_end_time = last_interval[1];
            
            // Naye interval ka Start Time [0] aur End Time [1]
            int current_start_time = intervals[i][0];
            int current_end_time = intervals[i][1];

            // Agar overlap hai (current_start <= last_end)
            if (current_start_time <= last_end_time) {
                // Diary ke usi aakhri interval ka End Time [1] update kar do
                last_interval[1] = Math.max(last_end_time, current_end_time);
            } 
            // Agar overlap nahi hai
            else {
                // Diary mein bilkul naya interval add karo
                merged.add(intervals[i]);
            }
        }

        // List ko wapas 2D Array me convert karke return karo
        return merged.toArray(new int[merged.size()][]);
    }
}