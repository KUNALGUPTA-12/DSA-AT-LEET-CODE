class Solution {
public:
//  bool isVowel(char ch) {
//             return ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u';
//         }
//     int maxVowels(string s, int k) {
//         int current_vowels = 0;

//         // loop 1 for winodw seen

//         for(int i = 0;i < k;i++){
//             if(isVowel(s[i])) current_vowels++;
//         }

//         int max_vowels = current_vowels;

//         // loop 2 for windopw updates

//         for(int i = k;i < s.length();i++){
//             if(isVowel(s[i])) current_vowels++; //naya chr add karo
//             if(isVowel(s[i - k])) current_vowels--;

//             max_vowels = max(max_vowels, current_vowels);
//             if(max_vowels == k) return max_vowels;
//         } 
//         return max_vowels;

        // yah merge for loop se kiya hau

        public:
    bool isVowel(char ch) {
        return ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u';
    }

    int maxVowels(string s, int k) {
        int current_vowels = 0;
        int max_vowels = 0;
        
        // Sirf 1 loop index 0 se end tak
        for (int i = 0; i < s.length(); i++) {
            // Step A: Naya element hamesha add hoga
            if (isVowel(s[i])) current_vowels++;
            
            // Step B: Jab window size 'k' se cross hone lage, purana minus karo
            if (i >= k && isVowel(s[i - k])) current_vowels--;
            
            // Step C: Jab pehli valid window ban jaye, max update karna shuru karo
            if (i >= k - 1) {
                max_vowels = max(max_vowels, current_vowels);
                if (max_vowels == k) return max_vowels; // Optimization
            }
        }
        
        return max_vowels;
    }
};