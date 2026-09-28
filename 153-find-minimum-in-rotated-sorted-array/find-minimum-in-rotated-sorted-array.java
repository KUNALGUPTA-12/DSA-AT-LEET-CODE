class Solution {
    public int findMin(int[] nums) {
         int left = 0;
        int right = nums.length - 1;

        // <= nahi lagaya taaki infinite loop na bane
        while (left < right) {
            int mid = left + (right - left) / 2;

            // Agar mid bada hai right se, matlab chhota element right side hai
            if (nums[mid] > nums[right]) {
                left = mid + 1;
            } 
            // Agar mid chhota ya barabar hai, toh mid khud answer ho sakta hai
            else {
                right = mid; // -1 nahi kiya taaki minimum element miss na ho
            }
        }
        return nums[left]; // Akhiri mein bacha hua ek akela element hi minimum hai
    }
}