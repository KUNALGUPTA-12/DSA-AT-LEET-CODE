class Solution {
    public String removeDuplicates(String s) {
        //  StringBuilder ans = new StringBuilder(); // StringBuilder as Stack
        
        // for (int j = 0; j < s.length(); j++) {
        //     char c = s.charAt(j);
        //     int len = ans.length();
            
        //     // Agar stack khali nahi hai aur aakhiri character same hai
        //     if (len > 0 && ans.charAt(len - 1) == c) {
        //         ans.deleteCharAt(len - 1); // Top element ko remove kar do
        //     } else {
        //         ans.append(c); // Stack mein add kar do
        //     }
        // }
        // return ans.toString();

        // two pointers approach
        char[] arr = s.toCharArray(); // In-place badlav ke liye array
        int i = -1; // Write pointer
        
        for (int j = 0; j < arr.length; j++) {
            // Agar i valid hai aur pichla likha hua arr[i] naye arr[j] ke barabar hai
            if (i >= 0 && arr[i] == arr[j]) {
                i--; // Duplicate mila, toh write pointer peeche hato
            } else {
                i++; // Agle ghar mein jao
                arr[i] = arr[j]; // Character overwrite karo
            }
        }
        // Array se 0 se leke i+1 length tak ki filtered string banakar return karo
        return new String(arr, 0, i + 1);
    }
}