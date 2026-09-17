class Solution {
public:
    int maximumWealth(vector<vector<int>>& accounts) {
         int maxWealth = 0; // Sabse ameer ki wealth store karne ke liye
        
        // Bahar ka loop: Har ek customer par jane ke liye
        for (int i = 0; i < accounts.size(); i++) {
            int currentCustomerWealth = 0; // Is dost ke kul paise
            
            // Andar ka loop: Us customer ke har bank ke paise jodne ke liye
            for (int j = 0; j < accounts[i].size(); j++) {
                currentCustomerWealth += accounts[i][j];
            }
            
            // C++ ka built-in max function use karke dono me se jo bada hai woh rakh lenge
            maxWealth = max(maxWealth, currentCustomerWealth);
        }
        
        return maxWealth;
    }
};