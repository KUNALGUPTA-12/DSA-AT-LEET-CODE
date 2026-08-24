class Solution {
public:
    int threeSumClosest(vector<int>& nums, int target) {
     int n = nums.size();
     int closestSum = nums[0]+nums[1]+nums[2];
     std::sort(nums.begin(),nums.end());
    //  leaderko bulao aur loop chalao   //
    for(int i = 0;i < n-2; i++){
        int left = i+1;
        int right = n-1;
        while(left<right){
            int currentSum = nums[i]+nums[left]+nums[right];
            if(currentSum == target){
                return currentSum;//bahut badiya
            }
            if(std::abs(currentSum - target) < std::abs(closestSum - target)){
                closestSum = currentSum;//dairy ko uupdte karo
            }
            if(currentSum < target){
                left++;
            }
            else{
                right--;
            }
        }
    } 
    return closestSum;
    }
};