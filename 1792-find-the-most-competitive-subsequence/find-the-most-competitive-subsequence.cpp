class Solution {
public:
    vector<int> mostCompetitive(vector<int>& nums, int k) {
        vector<int> ans ;
        int n = nums.size();

        for(int i = 0;i < n;i++){

            while(!ans.empty() && nums[i] < ans.back() && (ans.size() - 1 + (n - i) >= k)){
                ans.pop_back();
            }
            if(ans.size() < k){
                ans.push_back(nums[i]);
            }
        }
        return ans;
    }
};