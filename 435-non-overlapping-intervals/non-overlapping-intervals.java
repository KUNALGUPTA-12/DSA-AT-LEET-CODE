class Solution {
    public int eraseOverlapIntervals(int[][] intervals) {
        // 1. Agar koi interval nahi hai, toh 0 return karo
        if (intervals.length == 0) {
            return 0;
        }
        
        // 2. Pure array ko unke End Time (index 1) ke hisab se sort karo
        Arrays.sort(intervals, (a, b) -> Integer.compare(a[1], b[1]));
        
        int count = 0; // Cancelled meetings ka counter
        int prevEnd = intervals[0][1]; // Pehli meeting ka End Time
        
        // 3. Dusri meeting (index 1) se lekar aakhri meeting tak check karo
        for (int i = 1; i < intervals.length; i++) {
            // Agar current meeting ka Start Time, pichli meeting ke End Time se pehle hai
            if (intervals[i][0] < prevEnd) {
                count++; // Overlap hua! Is meeting ko remove/cancel karo
            } 
            // Agar overlap nahi hai, toh meeting smoothly chalegi
            else {
                prevEnd = intervals[i][1]; // Room khali hone ka naya End Time update karo
            }
        }
        
        // 4. Final answer return karo
        return count;
    }
}