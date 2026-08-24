class Solution {
public:
    vector<int> sortedSquares(vector<int>& nums) {
        int n = nums.size(); // new array ka size same of the nums
        vector<int> result(n);//ek khali array cerate kara
        int left = 0;//first elemnt of array of nums to be squre
        int right = n-1;//last element of array
        int index = n-1; //last element of array to store in last of that array
        while(left <= right){
            int leftSquare = nums[left]*nums[left];
            int rightSquare = nums[right]*nums[right];
            // array ko compare karana to arrange in new array akhri mai rakhna 
            if(leftSquare > rightSquare){
                result[index] = leftSquare;
                left ++; //agaa badao
            }
            else{
                result[index] = rightSquare;
                right --;//piche karo 
            }
            index --;//piche se khli dabo ko dundo
        }
        return result;// final sorted square array
    }
};