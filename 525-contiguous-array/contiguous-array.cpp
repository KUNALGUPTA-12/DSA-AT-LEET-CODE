class Solution {
public:
    int findMaxLength(vector<int>& nums) {
        // Diary (Map) banayi jisme hum 'Level : Index' store karenge
    unordered_map<int, int> register_map;
    
    // Shuruat ka base case: Level 0 mila tha Index -1 par
    register_map[0] = -1; 
    
    int level = 0;
    int max_length = 0;
    
    for (int i = 0; i < nums.size(); i++) {
        // 1 aane par level +1, 0 aane par level -1
        if (nums[i] == 1) {
            level++;
        } else {
            level--;
        }
        
        // register_map.find(level) Diary mein dhoondhta hai.
        // Agar mil jata hai, toh wo aakhiri point (end()) tak NAHI pahunch pata.
        // Isiliye '!= register_map.end()' ka matlab hai: "Level MIL GAYA"
        if (register_map.find(level) != register_map.end()) {
            
            // Abhi ke index se purane index ko minus karke length nikalo
            int length = i - register_map[level];
            max_length = max(max_length, length);
            
        } 
        // Agar dhoondhte-dhoondhte computer aakhiri tak pahunch gaya (yaani == end())
        // Iska matlab level pehli baar aaya hai
        else {
            // Diary mein note karlo ki yeh level kis index par mila
            register_map[level] = i;
        }
    }
    
    return max_length;
    }
};