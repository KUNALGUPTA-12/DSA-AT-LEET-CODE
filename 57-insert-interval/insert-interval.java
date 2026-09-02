class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {
         // Java me dynamic size ke liye List of 1D Arrays use kar rahe hain
        List<int[]> result = new ArrayList<>();
        int i = 0;
        int n = intervals.length;

        // Loop 1: Pehle wale intervals
        // intervals[i][1] = Purane ka End, newInterval[0] = Naye ka Start
        while (i < n && intervals[i][1] < newInterval[0]) {
            result.add(intervals[i]);
            i++;
        }

        // Loop 2: Overlap wale aur unko merge karna
        // intervals[i][0] = Purane ka Start, newInterval[1] = Naye ka End
        while (i < n && intervals[i][0] <= newInterval[1]) {
            newInterval[0] = Math.min(newInterval[0], intervals[i][0]);
            newInterval[1] = Math.max(newInterval[1], intervals[i][1]);
            i++;
        }
        // Merged single array ko list me add karo
        result.add(newInterval);

        // Loop 3: Baad wale intervals
        while (i < n) {
            result.add(intervals[i]);
            i++;
        }

        // List ko wapas standard 2D Array me badal kar return karo
        return result.toArray(new int[result.size()][]);
    }
}