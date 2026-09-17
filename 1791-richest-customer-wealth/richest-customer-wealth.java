class Solution {
    public int maximumWealth(int[][] accounts) {
          int maxWealth = 0; // Sabse ameer ki wealth store karne ke liye
        
        // Bahar ka loop: Har ek customer (row) par jane ke liye
        for (int i = 0; i < accounts.length; i++) {
            int currentCustomerWealth = 0; // Is dost ke kul paise
            
            // Andar ka loop: Us customer ke har bank (column) ke paise jodne ke liye
            for (int j = 0; j < accounts[i].length; j++) {
                currentCustomerWealth += accounts[i][j];
            }
            
            // Agar is customer ke paise purane max se zyaada hain, toh update karo
            if (currentCustomerWealth > maxWealth) {
                maxWealth = currentCustomerWealth;
            }
        }
        
        return maxWealth;
    }
}