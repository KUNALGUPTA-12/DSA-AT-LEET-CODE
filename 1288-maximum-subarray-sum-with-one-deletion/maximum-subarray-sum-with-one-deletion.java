class Solution {
    public int maximumSum(int[] arr) {
        // if(arr == null || arr.length == 0) return 0;
        // int normalBag = arr[0],specialBag = arr[0],ans = arr[0];

        // for(int i = 0;i < arr.length;i++){
        //     int prevNormal = normalBag;

        //     normalBag = Math.max(arr[i],normalBag + arr[i]);

        //     specialBag = Math.max(prevNormal,specialBag + arr[i]);

        //     ans = Math.max(ans,Math.max(normalBag,specialBag));
        //     //ans = Math.max(ans, normalBag);
        //     //ans = Math.max(ans, specialBag);
        // }
        // return ans;
        if (arr == null || arr.length == 0) return 0;
        int n = arr.length;
        if (n == 1) return arr[0];

        // Alag se memory allocate ki taaki state leak na ho
        int[] normalBag = new int[n];  
        int[] specialBag = new int[n]; 

        // Shuruat sirf pehle element se karo
        normalBag[0] = arr[0];
        specialBag[0] = arr[0];
        int ans = arr[0];

        for (int i = 1; i < n; i++) {
            // Normal Kadane: Ya toh naya shuru karo ya pichle bina-deletion wale mein jodo
            normalBag[i] = Math.max(arr[i], normalBag[i - 1] + arr[i]);

            // Special Bag:
            // Choice 1: Pichle normal wale mein se current ko delete kiya (normalBag[i-1])
            // Choice 2: Deletion pehle hi ho chuki hai, current ko jodo (specialBag[i-1] + arr[i])
            specialBag[i] = Math.max(normalBag[i - 1], specialBag[i - 1] + arr[i]);

            // Global answer update
            ans = Math.max(ans, normalBag[i]);
            ans = Math.max(ans, specialBag[i]);
        }

        return ans;
    }
}