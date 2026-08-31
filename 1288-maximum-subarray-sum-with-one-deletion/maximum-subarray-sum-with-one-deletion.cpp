class Solution {
public:
    int maximumSum(vector<int>& arr) {
        // if(arr.empty()) return 0 ;

        // int normal_bag = arr[0];//Bina power ka bag
        // int special_bag = arr[0];//power use karne ka bag baad wala sum
        // int ans = arr[0];//sabse bad sum wala ans ko store karne ke liye
        // int n = arr.size();
        // for(size_t i = 1;i < n;i++)//yah unsignednumer ko legai 
        // {
        //     // agal mai jana ke lye piche compare e liya
        //     int prev_normal = normal_bag;
        //     // normal ko shru karo aur naya jodo
        //     normal_bag = max(arr[i],normal_bag + arr[i]);
        //     // special bag ki abhi power use kara yah nahi 
        //     special_bag = max(prev_normal,special_bag + arr[i]);

        //     ans = max({ans,normal_bag,special_bag});
        // }
        // return ans;

        int n = arr.size();
        if (n == 0) return 0;
        if (n == 1) return arr[0];

        // Do tracking arrays banayein taaki pichli continuous states leak na hon
        vector<int> normal_bag(n);  // max sum ending at i without deletion
        vector<int> special_bag(n); // max sum ending at i with at most one deletion

        normal_bag[0] = arr[0];
        special_bag[0] = arr[0];
        int ans = arr[0];

        for (int i = 1; i < n; i++) {
            // Normal Kadane: Ya toh naya shuru karo ya pichle bina-deletion wale mein jodo
            normal_bag[i] = max(arr[i], normal_bag[i - 1] + arr[i]);

            // Special Bag: 
            // Choice 1: Pichle bina-deletion wale mein se current ko delete kar diya (yaani sirf normal_bag[i-1])
            // Choice 2: Deletion pehle hi ho chuki hai, ab current ko include karo (special_bag[i-1] + arr[i])
            special_bag[i] = max(normal_bag[i - 1], special_bag[i - 1] + arr[i]);

            // Dono mein se aur poorane ans mein se jo bada ho use update karo
            ans = max({ans, normal_bag[i], special_bag[i]});
        }

        return ans;
    }
};