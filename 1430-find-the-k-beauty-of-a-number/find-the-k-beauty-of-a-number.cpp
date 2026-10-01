class Solution {
public:
    int divisorSubstrings(int num, int k) {
           string s = to_string(num); // Number ko string mein badla
        int beauty_count = 0;
        int n = s.length();

        // Loop chalayenge jahan tak k length ka substring mil sake
        for (int i = 0; i <= n - k; i++) {
            // i index se lekar k length ka tukda nikala
            string sub = s.substr(i, k); 
            
            // String tukde ko wapas integer (number) mein badla
            int div = stoi(sub); 

            // 0 se division allowed nahi hai, isliye div != 0 check kiya
            if (div != 0 && num % div == 0) {
                beauty_count++; // Agar divide ho gaya toh count badhao
            }
        }

        return beauty_count;
    }
};