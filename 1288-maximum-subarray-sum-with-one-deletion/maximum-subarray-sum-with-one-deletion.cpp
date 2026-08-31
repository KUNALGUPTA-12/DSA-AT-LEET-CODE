class Solution {
public:
    int maximumSum(vector<int>& arr) {
        if(arr.empty()) return 0 ;

        int normal_bag = arr[0];//Bina power ka bag
        int special_bag = arr[0];//power use karne ka bag baad wala sum
        int ans = arr[0];//sabse bad sum wala ans ko store karne ke liye
        int n = arr.size();
        for(size_t i = 1;i < n;i++)//yah unsignednumer ko legai 
        {
            // agal mai jana ke lye piche compare e liya
            int prev_normal = normal_bag;
            // normal ko shru karo aur naya jodo
            normal_bag = max(arr[i],normal_bag + arr[i]);
            // special bag ki abhi power use kara yah nahi 
            special_bag = max(prev_normal,special_bag + arr[i]);

            ans = max({ans,normal_bag,special_bag});
        }
        return ans;
    }
};