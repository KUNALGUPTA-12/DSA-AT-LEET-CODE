class Solution {
    public boolean checkInclusion(String s1, String s2) {
        // yah hash map se likh samjana kha kiye

        int n1 = s1.length();
        int n2 = s2.length();
        if (n1 > n2) return false;

        // Class and Objects definition
        HashMap<Character, Integer> s1Map = new HashMap<>();
        HashMap<Character, Integer> s2Map = new HashMap<>();

        for (int i = 0; i < n1; i++) {
            s1Map.put(s1.charAt(i), s1Map.getOrDefault(s1.charAt(i), 0) + 1);
            s2Map.put(s2.charAt(i), s2Map.getOrDefault(s2.charAt(i), 0) + 1);
        }

        if (s1Map.equals(s2Map)) return true;

        for (int i = n1; i < n2; i++) {
            char newChar = s2.charAt(i);
            s2Map.put(newChar, s2Map.getOrDefault(newChar, 0) + 1);

            char oldChar = s2.charAt(i - n1);
            s2Map.put(oldChar, s2Map.get(oldChar) - 1);
            
            // Strict Object clean up rules
            if (s2Map.get(oldChar) == 0) {
                s2Map.remove(oldChar);
            }

            if (s1Map.equals(s2Map)) return true;
        }
        return false;

        // yh wala vector se hua hai fast run time ke liye

        // int n1 = s1.length();
        // int n2 = s2.length();
        // if (n1 > n2) return false;
        
        // // Direct array elements manipulation
        // int[] s1Count = new int[26];
        // int[] s2Count = new int[26];
        
        // for (int i = 0; i < n1; i++) {
        //     s1Count[s1.charAt(i) - 'a']++;
        //     s2Count[s2.charAt(i) - 'a']++;
        // }
        
        // if (Arrays.equals(s1Count, s2Count)) return true;
        
        // for (int i = n1; i < n2; i++) {
        //     s2Count[s2.charAt(i) - 'a']++;
        //     s2Count[s2.charAt(i - n1) - 'a']--;
            
        //     if (Arrays.equals(s1Count, s2Count)) return true;
        // }
        // return false;
    }
};