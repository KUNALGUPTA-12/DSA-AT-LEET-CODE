class Solution {
private:
    int getNextIndex(vector<int>& nums, int i) {
        int n = nums.size();
        int next = (i + nums[i]) % n;
        return (next < 0) ? (next + n) : next;
    }

public:
    bool circularArrayLoop(vector<int>& nums) {
        int n = nums.size();
        
        for (int i = 0; i < n; ++i) {
            if (nums[i] == 0) continue; 
            
            int slow = i;
            int fast = i;
            bool isForward = (nums[i] > 0); 
            
            while (true) {
                // Sahi direction aur 0 check dono saath mein lagaye hain
                if (nums[slow] == 0 || (nums[slow] > 0) != isForward) break;
                
                int nextFast = getNextIndex(nums, fast);
                if (nums[nextFast] == 0 || (nums[nextFast] > 0) != isForward) break;
                
                int nextNextFast = getNextIndex(nums, nextFast);
                if (nums[nextNextFast] == 0 || (nums[nextNextFast] > 0) != isForward) break;
                
                slow = getNextIndex(nums, slow);
                fast = nextNextFast;
                
                if (slow == fast) {
                    if (slow == getNextIndex(nums, slow)) {
                        break; 
                    }
                    return true; 
                }
            }
            
            // Path cleanup optimization
            slow = i;
            while (nums[slow] != 0 && (nums[slow] > 0) == isForward) {
                int next = getNextIndex(nums, slow);
                nums[slow] = 0;
                slow = next;
            }
        }
        
        return false;
        
    }
};