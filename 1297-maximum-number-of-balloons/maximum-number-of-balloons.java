class Solution {
    public int maxNumberOfBalloons(String text) {
        // 128 size ka primitive array (Pehle se 0 initialized)
        int[] freq = new int[128];
        
        // Pass 1: Frequency count karna
        for (int i = 0; i < text.length(); i++) {
            freq[text.charAt(i)]++;
        }
        
        // Pass 2: Balloon counts nikalna
        int b = freq['b'];
        int a = freq['a'];
        int l = freq['l'] / 2;
        int o = freq['o'] / 2;
        int n = freq['n'];
        
        // Java ka rule: Nested tarike se do-do karke minimum nikalna
        return Math.min(b, Math.min(a, Math.min(l, Math.min(o, n))));

        // // hashmap
        
        // // Array ko hata kar asli Java HashMap banaya
        // HashMap<Character, Integer> freq = new HashMap<>();
        
        // // Pass 1: Frequency count dynamic update karna
        // for (int i = 0; i < text.length(); i++) {
        //     char c = text.charAt(i);
        //     freq.put(c, freq.getOrDefault(c, 0) + 1);
        // }
        
        // // Pass 2: Map se values nikalna (Nahi milne par default 0 milega)
        // int b = freq.getOrDefault('b', 0);
        // int a = freq.getOrDefault('a', 0);
        // int l = freq.getOrDefault('l', 0) / 2;
        // int o = freq.getOrDefault('o', 0) / 2;
        // int n = freq.getOrDefault('n', 0);
        
        // return Math.min(b, Math.min(a, Math.min(l, Math.min(o, n))));
    }
}