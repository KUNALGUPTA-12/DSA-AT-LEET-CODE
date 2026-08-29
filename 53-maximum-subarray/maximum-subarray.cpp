class Solution {
public:
    int maxSubArray(vector<int>& nums) {
        // kadens patterns sai
        // int max_sum = nums[0];
        // int n = nums.size();
        // int current_sum = 0;
        // for(int i = 0;i < n;i++){
        //     current_sum += nums[i];

        //     if(current_sum > max_sum){
        //         max_sum = current_sum;
        //     }
        //     if(current_sum < 0){
        //         current_sum = 0;
        //     }
        // }
        // return max_sum;

        // sliding methos se

        int max_sum = nums[0]; // Pehle element se start karenge
        int current_sum = 0;
        
        int left = 0; // Window ka starting point
        
        for (int right = 0; right < nums.size(); right++) {
            current_sum += nums[right]; // Window ko right se badao
            
            if (current_sum > max_sum) {
                max_sum = current_sum; // Naya bada sum mila toh save karo
            }
            
            // Dynamic Window Rule: Agar sum negative ho jaye, toh purani window kharab hai
            if (current_sum < 0) {
                current_sum = 0;       // Sum zero karo
                left = right + 1;      // Window ko shrink karke naye element par le jao
            }
        }
        return max_sum;

    }
};