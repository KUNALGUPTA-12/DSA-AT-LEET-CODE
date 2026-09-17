/* The isBadVersion API is defined in the parent class VersionControl.
      boolean isBadVersion(int version); */

public class Solution extends VersionControl {
    public int firstBadVersion(int n) {
         int startIndex = 1; // camelCase (Kyunki ginti 1 se n tak hai)
        int endIndex = n;   // camelCase (Isliye n-1 nahi kiya)
        
        while (startIndex <= endIndex) {
            // Integer overflow se bachne ke liye safe formula
            int midIndex = startIndex + (endIndex - startIndex) / 2; // camelCase
            
            // Agar yeh version kharab hai, toh ho sakta hai pehla kharab aur piche ho
            if (isBadVersion(midIndex)) {
                endIndex = midIndex - 1; // Left side check karne jao
            } 
            // Agar yeh version sahi hai, toh pakka pehla kharab aage hi hoga
            else {
                startIndex = midIndex + 1; // Right side check karne jao
            }
        }
        
        // Loop break hone par startIndex automatically pehle bad version par rukta hai
        return startIndex;
    }
}