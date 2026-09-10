class Solution {
    public int findUnsortedSubarray(int[] nums) {
        int n = nums.length;
        
        // Shuruat mein end ko -1 rakha taaki pata chale ki koi galti mili ya nahi
        int end = -1;
        int max_val = Integer.MIN_VALUE; // Sabse choti value se shuru kiya
        
        // 1. Left se Right ja kar aakhiri galti ('end') dhoondho
        for (int i = 0; i < n; i++) {
            if (nums[i] < max_val) {
                end = i; // Galti mili! end ko update karo
            } else {
                max_val = nums[i]; // Agar sab sahi hai toh max value update karo
            }
        }
        
        // Agar end abhi bhi -1 hai, matlab poore array mein ek bhi galti nahi mili (Array already sorted hai)
        if (end == -1) return 0;
        
        int start = 0;
        int min_val = Integer.MAX_VALUE; // Sabse badi value se shuru kiya
        
        // 2. Right se Left aa kar pehli galti ('start') dhoondho
        for (int j = n - 1; j >= 0; j--) {
            if (nums[j] > min_val) {
                start = j; // Galti mili! start ko update karo
            } else {
                min_val = nums[j]; // Agar sab sahi hai toh min value update karo
            }
        }
        
        // 3. Unsorted subarray ki total length return karo
        return end - start + 1;
    }
}