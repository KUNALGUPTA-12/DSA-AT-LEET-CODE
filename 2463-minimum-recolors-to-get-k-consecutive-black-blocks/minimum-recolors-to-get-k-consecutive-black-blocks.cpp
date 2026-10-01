class Solution {
public:
    int minimumRecolors(string blocks, int k) {
         int current_whites = 0;
        
        // 1. Pehli k size ki window ready ki
        for (int i = 0; i < k; i++) {
            if (blocks[i] == 'W') current_whites++;
        }
        
        int min_ops = current_whites;
        
        // 2. Ab proper left pointer banaya jo index 0 se shuru hoga
        int left = 0; 
        
        for (int right = k; right < blocks.length(); right++) {
            // Aage se element enter hua
            if (blocks[right] == 'W') current_whites++;
            
            // Piche se left pointer wala element bahar nikala
            if (blocks[left] == 'W') current_whites--;
            
            left++; // Left pointer ko khud se aage badhaya (Window slide hui)
            
            min_ops = min(min_ops, current_whites);
        }
        
        return min_ops;
    }
};