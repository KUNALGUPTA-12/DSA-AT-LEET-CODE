class Solution {
    public int[] sortedSquares(int[] nums) {
        int n = nums.length;//array mai kitne elemnts hoga(Size)
        int[] result = new int[n];//naya aur khali array for storeing the result 
        int left = 0;
        int right = n-1;
        int index = n-1;
        while(left <= right){
            int leftSquare = nums[left]*nums[left];
            int rightSquare = nums[right]*nums[right];

            if(leftSquare > rightSquare){
                result[index] = leftSquare;
                left ++;
            }
            else{
                result[index] = rightSquare;
                right --;
            }
            index --;
        }
        return result;
    }
}