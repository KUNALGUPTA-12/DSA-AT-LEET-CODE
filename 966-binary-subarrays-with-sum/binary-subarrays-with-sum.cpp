class Solution {
    private :
    int atMost(vector<int>& nums,int goal){
        if(goal < 0) return 0;

        int left = 0,count = 0,current_sum = 0;

        for(int r = 0;r < nums.size();r++){
            current_sum += nums[r];//window elemnt dalo

            // agar sum goal se badaa hai
            while(current_sum > goal){
                current_sum -= nums[left];
                left++;
            }
            count += (r - left + 1);
        }
        return count;
    }
public:
    int numSubarraysWithSum(vector<int>& nums, int goal) {
        return atMost(nums,goal) - atMost(nums,goal -1);
    }
};