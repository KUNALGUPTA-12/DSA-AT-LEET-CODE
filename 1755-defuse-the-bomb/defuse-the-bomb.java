class Solution {
    public int[] decrypt(int[] code, int k) {
         int n = code.length;
        int[] result = new int[n]; // Shuruat me sabko 0 rakhlo
        
        // Rule 3: Agar k == 0 hai, toh saare 0 hi rahenge (direct return)
        if (k == 0) return result;
        
        // 1. Window ke boundaries set karo
        int start = 1, end = k;
        if (k < 0) {
            start = n - Math.abs(k); // Negative k ke liye window piche banti hai
            end = n - 1;
        }
        
        // 2. Pehli window ka sum nikaal lo
        int currentSum = 0;
        for (int i = start; i <= end; i++) {
            currentSum += code[i];
        }
        
        // 3. Window ko pure array par ek baar slide karo
        for (int i = 0; i < n; i++) {
            result[i] = currentSum; // Is index ka answer save kiya
            
            // Window ko 1 kadam aage badhao:
            // Purana element (start wala) minus karo
            currentSum -= code[start % n]; 
            start++; // start ko aage badhao
            
            // Naya element (end + 1 wala) plus karo
            end++; 
            currentSum += code[end % n]; 
        }
        
        return result;
    }
}