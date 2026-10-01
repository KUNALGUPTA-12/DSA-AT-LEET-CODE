class Solution {
public:
    vector<int> decrypt(vector<int>& code, int k) {
        int n = code.size();
        vector<int> result(n, 0); // Shuruat me sabko 0 rakhlo
        
        // Rule 3: Agar k == 0 hai, toh saare 0 hi rahenge (direct return)
        if (k == 0) return result;
        
        // 1. Window ke boundaries set karo
        int start = 1, end = k;
        if (k < 0) {
            start = n - abs(k); // Negative k ke liye window piche banti hai
            end = n - 1;
        }
        
        // 2. Pehli window ka sum nikaal lo
        int current_sum = 0;
        for (int i = start; i <= end; i++) {
            current_sum += code[i];
        }
        
        // 3. Window ko pure array par ek baar slide karo
        for (int i = 0; i < n; i++) {
            result[i] = current_sum; // Is index ka answer save kiya
            
            // Window ko 1 kadam aage badhao:
            // Purana element (start wala) minus karo
            current_sum -= code[start % n]; 
            start++; // start ko aage badhao
            
            // Naya element (end + 1 wala) plus karo
            end++; 
            current_sum += code[end % n]; 
        }
        
        return result;
    }
};