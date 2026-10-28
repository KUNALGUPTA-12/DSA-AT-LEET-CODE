class Solution {
    public boolean isCovered(int[][] ranges, int left, int right) {
         // Numbers max 50 tak hain, isliye safe side 52 size ka array le liya
        boolean[] visited = new boolean[52];
        
        // 1. Har ek range ke andar ke points ko true mark karo
        for (int i = 0; i < ranges.length; i++) {
            int start = ranges[i][0]; // Range ka shuruat
            int end = ranges[i][1];   // Range ka khatma
            
            for (int j = start; j <= end; j++) {
                visited[j] = true; // Yeh point covered hai!
            }
        }
        
        // 2. Check karo kya left se right tak ka koi number miss toh nahi hua?
        for (int i = left; i <= right; i++) {
            if (!visited[i]) {
                return false; // Ek bhi number chhut gaya toh seedha false!
            }
        }
        
        // Agar loop bina ruke poora chal gaya, matlab sab covered hain
        return true;
    }
}