class Solution {
public:
    int maxNumberOfBalloons(string text) {
        // // by the help of vector
        // // 128 size ka vector banaya (Saare symbols ke liye pehle se 0 initialized)
        // vector<int> freq(128, 0);
        
        // // Pass 1: Frequency count karna
        // for (char c : text) {
        //     freq[c]++;
        // }
        
        // // Pass 2: Har character ke hisab se balloon count nikalna
        // int b_count = freq['b'];
        // int a_count = freq['a'];
        // int l_count = freq['l'] / 2; // 2 'l' milkar 1 balloon banta hai
        // int o_count = freq['o'] / 2; // 2 'o' milkar 1 balloon banta hai
        // int n_count = freq['n'];
        
        // // C++ unique feature: curly braces ke sath ek baar mein sabka minimum
        // return min({b_count, a_count, l_count, o_count, n_count});

        // by the help of hashmap
        
        // Vector ko hata kar asli HashMap banaya
        unordered_map<char, int> freq;
        
        // Pass 1: Map mein characters ki frequency dynamic bharna
        for (char c : text) {
            freq[c]++; 
        }
        
        // Pass 2: Map se values nikalna
        int b_count = freq['b'];
        int a_count = freq['a'];
        int l_count = freq['l'] / 2;
        int o_count = freq['o'] / 2;
        int n_count = freq['n'];
        
        return min({b_count, a_count, l_count, o_count, n_count});
    }
};