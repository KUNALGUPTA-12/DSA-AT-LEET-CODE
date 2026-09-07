class Solution {
public:
    bool canConstruct(string ransomNote, string magazine) {
        // // Vector hata kar asli unordered_map lagaya snake_case mein
        // unordered_map<char, int> magazine_freq; 
        
        // // Loop 1: Dynamic map insertion
        // for (int i = 0; i < magazine.length(); i++) {
        //     char mag_char = magazine[i]; 
        //     magazine_freq[mag_char]++; 
        // }
        
        // // Loop 2: Checking from map stock
        // for (int i = 0; i < ransomNote.length(); i++) {
        //     char note_char = ransomNote[i]; 
            
        //     if (magazine_freq[note_char] == 0) {
        //         return false; 
        //     }
        //     magazine_freq[note_char]--; 
        // }
        
        // return true;
        // vector se hua hai
          // C++ snake_case variables setup
        vector<int> magazine_freq(128, 0); 
        
        // Loop 1: Magazine ke characters ka stock bharna
        for (int i = 0; i < magazine.length(); i++) {
            char mag_char = magazine[i]; 
            magazine_freq[mag_char]++; 
        }
        
        // Loop 2: Ransom Note ke letters ko check aur minus karna
        for (int i = 0; i < ransomNote.length(); i++) {
            char note_char = ransomNote[i]; 
            
            // Magazine wale vector stock (magazine_freq) se check kiya
            if (magazine_freq[note_char] == 0) {
                return false; 
            }
            magazine_freq[note_char]--; 
        }
        
        return true;
    }
};