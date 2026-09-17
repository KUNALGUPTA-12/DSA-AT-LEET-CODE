class Solution {
public:
    char repeatedCharacter(string s) {
         // 26 size ka vector jisme shuru me sabhi values 0 hain
        vector<int> letter_counts(26, 0); // snake_case
        
        for (int i = 0; i < s.length(); i++) {
            char current_character = s[i]; // snake_case
            int alphabet_index = current_character - 'a'; // snake_case
            
            // Ginti ko 1 badhaya
            letter_counts[alphabet_index]++;
            
            // Check kiya ki kya yeh doosri baar aaya hai
            if (letter_counts[alphabet_index] == 2) {
                return current_character;
            }
        }
        
        return ' ';
    }
};