class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> result = new ArrayList<>();
        
        // Edge case: agar s ki lambai p se choti hai
        if (s.length() < p.length()) return result;

        // 26 size ke arrays frequency store karne ke liye
        int[] pCount = new int[26];
        int[] sCount = new int[26];

        // Pehla Loop: p aur s ke starting window ka count lena
        for (int i = 0; i < p.length(); i++) {
            pCount[p.charAt(i) - 'a']++;
            sCount[s.charAt(i) - 'a']++;
        }

        // Pehle window ka check
        if (Arrays.equals(pCount, sCount)) result.add(0);

        // Doosra Loop: Sliding Window shuru
        for (int i = p.length(); i < s.length(); i++) {
            sCount[s.charAt(i) - 'a']++;               // Naya character window me aaya
            sCount[s.charAt(i - p.length()) - 'a']--;  // Puraana character window se bahar gaya

            // Har sliding step par check karo
            if (Arrays.equals(pCount, sCount)) {
                result.add(i - p.length() + 1);
            }
        }

        return result;
    }
}