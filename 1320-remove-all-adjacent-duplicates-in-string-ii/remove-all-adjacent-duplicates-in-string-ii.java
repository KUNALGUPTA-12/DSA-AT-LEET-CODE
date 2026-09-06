class Solution {
    public String removeDuplicates(String s, int k) {
        // // stack se 
        // // Do stacks banaye: ek chars ke liye aur ek unke chal rahe counts ke liye
        // Stack<Character> charSt = new Stack<>();
        // Stack<Integer> countSt = new Stack<>();
        
        // for (int j = 0; j < s.length(); j++) {
        //     char c = s.charAt(j);
            
        //     // Agar stack khali nahi hai aur top char same hai
        //     if (!charSt.isEmpty() && charSt.peek() == c) {
        //         countSt.push(countSt.pop() + 1); // Purana count nikal kar +1 karke wapas daal diya
        //     } 
        //     // Agar alag hai ya khali hai
        //     else {
        //         charSt.push(c);
        //         countSt.push(1); // Naya char aur count 1 daal diya
        //     }
            
        //     // Check: Agar count 'k' tak pahunch gaya, toh dono stacks se pop karo
        //     if (countSt.peek() == k) {
        //         charSt.pop();
        //         countSt.pop();
        //     }
        // }
        
        // // Stack se wapas final string banana
        // StringBuilder ans = new StringBuilder();
        // while (!charSt.isEmpty()) {
        //     char ch = charSt.pop();
        //     int count = countSt.pop();
        //     // Jitna count tha, utni baar char ko aage (reverse order mein) jodte jao
        //     for (int i = 0; i < count; i++) {
        //         ans.insert(0, ch);
        //     }
        // }
        
        // return ans.toString();

        // two pionters se
        char[] arr = s.toCharArray(); // In-place change karne ke liye array banaya
        int n = arr.length;
        int i = -1; // Write pointer
        int[] counts = new int[n]; // Count ka track rakhne ke liye array
        
        for (int j = 0; j < n; j++) {
            i++;
            arr[i] = arr[j]; // Write kiya
            
            // Count set kiya
            if (i == 0 || arr[i] != arr[i - 1]) {
                counts[i] = 1;
            } else {
                counts[i] = counts[i - 1] + 1;
            }
            
            // Blast condition
            if (counts[i] == k) {
                i = i - k; // 'k' kadam peeche hato
            }
        }
        
        // Safe characters (0 se i+1 length) ki string banakar return karo
        return new String(arr, 0, i + 1);
    }
}