class Solution {
public:
    vector<int> findSubstring(string s, vector<string>& words) {
          vector<int> result;
        if (s.empty() || words.empty()) return result;

        int wordLen = words[0].length();
        int wordCount = words.size();
        int totalLen = wordLen * wordCount;
        int sLen = s.length();

        if (sLen < totalLen) return result;

        // Target Map: Kaun sa word kitni baar chahiye
        unordered_map<string, int> wordMap;
        for (const string& word : words) {
            wordMap[word]++;
        }

        // Hum string ko wordLen ke alag-alag offsets se scan karenge
        for (int i = 0; i < wordLen; i++) {
            int left = i;
            unordered_map<string, int> seenWords;
            int count = 0; // Kitne valid words mil chuke hain

            // j ko wordLen ki jumps se aage badhayenge
            for (int j = i; j <= sLen - wordLen; j += wordLen) {
                string currentWord = s.substr(j, wordLen);

                // Agar word humari target list me hai
                if (wordMap.find(currentWord) != wordMap.end()) {
                    seenWords[currentWord]++;
                    count++;

                    // Agar koi word limit se zyada baar aa gaya, toh left pointer ko aage badhao
                    while (seenWords[currentWord] > wordMap[currentWord]) {
                        string leftWord = s.substr(left, wordLen);
                        seenWords[leftWord]--;
                        count--;
                        left += wordLen; // Window ko left se chota kiya
                    }

                    // Agar saare words sahi count me mil gaye
                    if (count == wordCount) {
                        result.push_back(left);
                    }
                } 
                // Agar koi aisa word mila jo list me hai hi nahi, toh window ko reset karo
                else {
                    seenWords.clear();
                    count = 0;
                    left = j + wordLen; // Window ab naye sire se shuru hogi
                }
            }
        }

        return result;
    }
};