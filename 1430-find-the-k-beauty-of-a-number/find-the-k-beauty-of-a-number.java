class Solution {
    public int divisorSubstrings(int num, int k) {
            String s = String.valueOf(num); // Number ko string mein badla
        int beautyCount = 0;
        int n = s.length();

        // Loop chalayenge n - k tak takki k size ki window bani rahe
        for (int i = 0; i <= n - k; i++) {
            // substring(start, end) -> end index exclusive hota hai isliye i + k kiya
            String sub = s.substring(i, i + k);
            
            // String ko integer mein convert kiya
            int div = Integer.parseInt(sub);

            // Check kiya ki number 0 na ho aur num ko poora divide kare
            if (div != 0 && num % div == 0) {
                beautyCount++; // Condition sahi toh count badhao
            }
        }

        return beautyCount;
    }
}