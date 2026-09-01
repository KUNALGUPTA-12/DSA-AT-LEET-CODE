class Solution {
public:
    int subarraysDivByK(vector<int>& nums, int k) {
         std::unordered_map<int, int> remainderFrequency;
        
        // Base Case: Shuruat mein remainder 0 ek baar aa chuka hai
        remainderFrequency[0] = 1;
        
        int currentSum = 0;
        int subarrayCount = 0;
        int n = nums.size();
        
        for (int i = 0; i < n; i++) {
            currentSum += nums[i];
            
            // Negative numbers ko handle karne ke liye safe remainder nikalne ka tareeka
            int rem = (currentSum % k + k) % k;
            
            // Agar yeh remainder pehle diary mein dikha hai
            if (remainderFrequency.find(rem) != remainderFrequency.end()) {
                subarrayCount += remainderFrequency[rem];
            }
            
            // Is remainder ki frequency badhao diary mein
            remainderFrequency[rem]++;
        }
        
        return subarrayCount;
    }
};