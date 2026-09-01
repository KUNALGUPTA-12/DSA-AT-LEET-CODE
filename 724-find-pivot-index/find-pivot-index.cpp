class Solution {
public:
    int pivotIndex(vector<int>& nums) {
        int total_sum = 0,left_sum = 0;
        for(int num : nums){
            total_sum += num;
        }
        int i = 0;
        for(int num : nums){
            total_sum -= num;

            if(left_sum == total_sum){
                return i;
            }
            left_sum += num;
            i++;
        }
        return -1;



        // simple loop wala
        // int total_sum = 0;
        // int left_sum = 0;
        // int n = nums.size();
        
        // // Step 1: Poore array ka total sum nikal lo (Right Side tarazu)
        // for (int i = 0; i < n; i++) {
        //     total_sum += nums[i];
        // }
        
        // // Step 2: Har ek index par jaakar check karo
        // for (int i = 0; i < n; i++) {
        //     // Right side se current element ko minus karo
        //     total_sum -= nums[i]; 
            
        //     // Agar left aur right side ka sum barabar ho gaya
        //     if (left_sum == total_sum) {
        //         return i; // Mil gaya pivot index!
        //     }
            
        //     // Agar barabar nahi hai, toh ise left side mein plus kar do
        //     left_sum += nums[i];
        // }
        
        // // Agar poore loop mein kahin nahi mila toh -1 return karo
        // return -1; 
    }
};