class Solution {
public:
    void sortColors(vector<int>& nums) {
        int low = 0;
        int mid = 0;
        int high = nums.size() - 1; // Sabse aakhiri index (n-1)
        
        // Jab tak checking pointer (mid) aakhiri pointer (high) ko cross nahi karta
        while (mid <= high) {
            if (nums[mid] == 0) {
                // 0 mila toh use shuruat (low) mein bhejo
                std::swap(nums[mid], nums[low]);
                low++;
                mid++; // Dono pointers ko aage badhao
            } 
            else if (nums[mid] == 1) {
                // 1 toh beech mein hi rahega, bas bina swap kiye aage badho
                mid++;
            } 
            else { // Yani nums[mid] == 2
                // 2 mila toh use bilkul aakhiri (high) mein bhejo
                std::swap(nums[mid], nums[high]);
                high--;
                // Yahan mid++ NAHI hota, taaki peeche se aaye naye number ko agle round mein check kiya ja sake
            }
        } // <-- 1. Yeh bracket WHILE loop ko band karne ke liye hai (Missing tha!)
    }     // <-- 2. Yeh bracket sortColors function ko band karne ke liye hai
};        // <-- 3. Yeh bracket class Solution ko band karne ke liye hai