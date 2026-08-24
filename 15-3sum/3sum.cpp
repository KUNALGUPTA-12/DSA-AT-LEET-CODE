class Solution {
public:
    vector<vector<int>> threeSum(vector<int>& nums) {
       std::vector<std::vector<int>> result;//final anser ko store karne ka liya
        int n = nums.size();//array ke length
        // array ko sort karna by sort func
        std::sort(nums.begin(),nums.end());

        // i ko fix karna ke liya
        for(int i=0;i < n-2 ;i++){
            // duplicte ko remove karne ke liya
            if(i > 0 && nums[i]==nums[i-1]){
                continue;
            }
            int left = i+1;//ise gla elemnt
            int right = n-1;//last ka elemnet
            // helpers apna kam shru kara ga
            while(left < right){
                int sum = nums[i] + nums[left] + nums[right];

                if(sum == 0){
                    result.push_back({nums[i],nums[left],nums[right]});
                    // left aur right ke duplictes hatana
                    while(left < right && nums[left] == nums[left + 1]) left++;
                    while(left < right && nums[right] == nums[right-1]) right--;

                    // border se agla naye number kolanake liya aur jump karna ke liya
                    left++;
                    right--;                
                }
                else if (sum < 0){
                    left++;//sum chota hai toh aga badhao
                }
                else{
                    right--;//agar badaha hai toh pecha karo
                }
            } 
        }
        return result;
    }
};