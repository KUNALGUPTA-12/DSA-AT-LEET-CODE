class Solution {
public:
    int subarraySum(vector<int>& nums, int k) {
        std::unordered_map<int,int> notebook;
        notebook[0] = 1;//base case sum 0 1 bar aya hai

        int current_sum = 0,total_subarrays = 0;

        // for each loop
        for(int num : nums){
            current_sum += num;

            int bacha_hua_sum = current_sum -k;

            if(notebook.find(bacha_hua_sum) != notebook.end()){
                total_subarrays += notebook[bacha_hua_sum];
            }
            notebook[current_sum]++;
        }
        return total_subarrays;
    }
};