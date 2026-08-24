class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
     List<List<Integer>> result = new ArrayList<>();  //Wrapper Class" ka concept kehte hain.Autoboxing
     int n = nums.length;//java ka normal; array hai
     //build in sort func 
     Arrays.sort(nums);
    //  leader ko i ka loop
    for(int i = 0;i<n-2;i++){
        // duplicates hatao
        if(i>0 && nums[i]==nums[i-1]){
            continue;
        }
        int left = i+1;
        int right = n-1;
        while(left < right){
            int sum = nums[i]+nums[left]+nums[right];
            if(sum == 0){
                result.add(Arrays.asList(nums[i],nums[left],nums[right]));
                while(left<right && nums[left]==nums[left+ 1]) left++;
                while(left <right && nums[right]==nums[right-1]) right--;
                left++;
                right--;
            }
            else if(sum<0){
                left++;
            }
            else{
                right--;
            }
        }
    }
    return result;
    }
}