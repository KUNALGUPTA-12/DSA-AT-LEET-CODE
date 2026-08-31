class Solution {
    public int maxProduct(int[] nums) {
        if(nums == null || nums.length == 0) return 0;
        int maxPro = nums[0],minPro = nums[0],ans = nums[0],n = nums.length;

        for(int i = 1;i < n;i++){
            // negative hai toh swp karo

            if(nums[i] < 0){
                int temp = maxPro;
                maxPro = minPro;
                minPro = temp;
            }
            maxPro = Math.max(nums[i],maxPro*nums[i]);
            minPro = Math.min(nums[i],minPro*nums[i]);

            ans = Math.max(ans,maxPro);
        }
        return ans;
    }
}