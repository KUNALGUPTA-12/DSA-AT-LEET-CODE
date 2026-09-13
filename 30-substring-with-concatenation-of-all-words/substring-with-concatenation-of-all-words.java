class Solution {
    public List<Integer> findSubstring(String s, String[] words) {
        List<Integer> result = new ArrayList<>();
        if (s == null || s.length() == 0 || words == null || words.length == 0) {
            return result;
        }

        int wordLen = words[0].length();
        int wordCount = words.length;
        int totalLen = wordLen * wordCount;
        int sLen = s.length();

        if (sLen < totalLen) return result;

        // Target Map: Recipe parchi
        Map<String, Integer> wordMap = new HashMap<>();
        for (String word : words) {
            wordMap.put(word, wordMap.getOrDefault(word, 0) + 1);
        }

        // wordLen ke shifts par loop chalayenge (e.g., 0, 1, 2 agar wordLen 3 hai)
        for (int i = 0; i < wordLen; i++) {
            int left = i;
            Map<String, Integer> seenWords = new HashMap<>();
            int count = 0;

            // wordLen ke gap par jump lagaye
            for (int j = i; j <= sLen - wordLen; j += wordLen) {
                String currentWord = s.substring(j, j + wordLen);

                if (wordMap.containsKey(currentWord)) {
                    seenWords.put(currentWord, seenWords.getOrDefault(currentWord, 0) + 1);
                    count++;

                    // Duplicate/Extra word aane par left window ko tab tak khisakao jab tak count sahi na ho
                    while (seenWords.get(currentWord) > wordMap.get(currentWord)) {
                        String leftWord = s.substring(left, left + wordLen);
                        seenWords.put(leftWord, seenWords.get(leftWord) - 1);
                        count--;
                        left += wordLen;
                    }

                    // Agar exact saare words match ho gaye
                    if (count == wordCount) {
                        result.add(left);
                    }
                } else {
                    // Invalid word milte hi window clear aur jump to next position
                    seenWords.clear();
                    count = 0;
                    left = j + wordLen;
                }
            }
        }

        return result;
    }
}