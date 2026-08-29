class Solution {
    public int maxSubArray(int[] nums) {
        // kadens patternbs se 


        // int maxSum = nums[0];
        // int currentSum = 0;
        // int n = nums.length;
        // for(int i = 0;i < n;i++){
        //     currentSum += nums[i];
        //     if(currentSum > maxSum){
        //         maxSum = currentSum;
        //     }
        //     if(currentSum < 0){
        //         currentSum = 0;
        //     }
        // }
        // return maxSum;/
        // sliding window se

        int maxSum = nums[0]; // Pehle element se start karenge
        int currentSum = 0;
        
        int left = 0; // Window ka starting point
        
        for (int right = 0; right < nums.length; right++) {
            currentSum += nums[right]; // Window ko right se badao
            
            if (currentSum > maxSum) {
                maxSum = currentSum; // Naya bada sum mila toh save karo
            }
            
            // Dynamic Window Rule: Agar sum negative ho jaye, toh purani window kharab hai
            if (currentSum < 0) {
                currentSum = 0;        // Sum zero karo
                left = right + 1;      // Window ko shrink karke naye element par le jao
            }
        }
        return maxSum;
    }
}