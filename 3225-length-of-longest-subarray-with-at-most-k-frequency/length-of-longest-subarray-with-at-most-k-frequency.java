class Solution {
    public int maxSubarrayLength(int[] nums, int k) {
        HashMap <Integer, Integer> freqMap = new HashMap<>();
        int left = 0,maxLen = 0;

        for(int r = 0;r < nums.length;r++){
            freqMap.put(nums[r],freqMap.getOrDefault(nums[r],0) + 1);

            while(freqMap.get(nums[r]) > k){
                freqMap.put(nums[left], freqMap.get(nums[left]) - 1);
                left ++;
            }
            maxLen = Math.max(maxLen,r - left + 1);
        }
        return maxLen;
    }
}