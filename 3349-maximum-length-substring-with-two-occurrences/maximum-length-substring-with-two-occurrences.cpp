class Solution {
public:
    int maximumLengthSubstring(string s) {
         vector<int> count(26, 0); // English alphabets ke liye frequency array
        int left = 0, max_len = 0;

        for (int right = 0; right < s.length(); right++) {
            count[s[right] - 'a']++; // Naye character ka count badhao

            // Agar koi character 2 se zyada baar aaye, toh left pointer ko aage badhao
            while (count[s[right] - 'a'] > 2) {
                count[s[left] - 'a']--;
                left++;
            }

            // Max length ko update karo
            max_len = max(max_len, right - left + 1);
        }

        return max_len;
    }
};