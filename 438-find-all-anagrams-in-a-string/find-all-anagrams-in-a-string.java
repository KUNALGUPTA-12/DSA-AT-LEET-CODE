class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        // List<Integer> result = new ArrayList<>();
        
        // // Edge case: agar s ki lambai p se choti hai
        // if (s.length() < p.length()) return result;

        // // 26 size ke arrays frequency store karne ke liye
        // int[] pCount = new int[26];
        // int[] sCount = new int[26];

        // // Pehla Loop: p aur s ke starting window ka count lena
        // for (int i = 0; i < p.length(); i++) {
        //     pCount[p.charAt(i) - 'a']++;
        //     sCount[s.charAt(i) - 'a']++;
        // }

        // // Pehle window ka check
        // if (Arrays.equals(pCount, sCount)) result.add(0);

        // // Doosra Loop: Sliding Window shuru
        // for (int i = p.length(); i < s.length(); i++) {
        //     sCount[s.charAt(i) - 'a']++;               // Naya character window me aaya
        //     sCount[s.charAt(i - p.length()) - 'a']--;  // Puraana character window se bahar gaya

        //     // Har sliding step par check karo
        //     if (Arrays.equals(pCount, sCount)) {
        //         result.add(i - p.length() + 1);
        //     }
        // }

        // return result;

        // hash map se kiya wa 
        
              List<Integer> result = new ArrayList<>();
        if (s.length() < p.length()) return result;

        Map<Character, Integer> pMap = new HashMap<>();
        Map<Character, Integer> sMap = new HashMap<>();

        // Pehla Loop: p aur s ke starting window ki frequency count
        for (int i = 0; i < p.length(); i++) {
            pMap.put(p.charAt(i), pMap.getOrDefault(p.charAt(i), 0) + 1);
            sMap.put(s.charAt(i), sMap.getOrDefault(s.charAt(i), 0) + 1);
        }

        // Pehle window ka check
        if (pMap.equals(sMap)) result.add(0);

        // Doosra Loop: Sliding Window shuru
        for (int i = p.length(); i < s.length(); i++) {
            // 1. Naya character map me add karo
            sMap.put(s.charAt(i), sMap.getOrDefault(s.charAt(i), 0) + 1);

            // 2. Puraana character map se hatao ya count kam karo
            char oldChar = s.charAt(i - p.length());
            if (sMap.get(oldChar) == 1) {
                sMap.remove(oldChar); // Agar count 1 hai, toh 0 karne ke bajaye map se remove kar do
            } else {
                sMap.put(oldChar, sMap.get(oldChar) - 1);
            }

            // 3. Dono maps ko compare karo
            if (pMap.equals(sMap)) {
                result.add(i - p.length() + 1);
            }
        }

        return result;
    }
}