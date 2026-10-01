class Solution {
    public int numOfSubarrays(int[] arr, int k, int threshold) {
        int count = 0;
        int currentSum = 0;
        int targetSum = k * threshold; // Division se bachne ke liye multiplication trick

        // 1. Pehli k size ki window ka sum nikal lo
        for (int i = 0; i < k; i++) {
            currentSum += arr[i];
        }

        // Pehli window ko check karo
        if (currentSum >= targetSum) {
            count++;
        }

        // 2. Window ko aage slide karo (Index k se shuru karke end tak)
        for (int i = k; i < arr.length; i++) {
            // Naya element add karo, sabse pichla element minus karo
            currentSum += arr[i] - arr[i - k];

            // Agar naya sum target se bada ya barabar hai
            if (currentSum >= targetSum) {
                count++;
            }
        }

        return count;
    }
}