class Solution {
    public int hIndex(int[] citations) {
        int n = citations.length;
        int low = 0;
        int high = n - 1;
        int ans = 0;
        
        while (low <= high) {
            int mid = low + (high - low) / 2;
            
            // mid se lekar aakhiri tak total kitne papers hain
            int remaining_papers = n - mid;
            
            // Agar citations papers ke count se badi ya barabar hain
            if (citations[mid] >= remaining_papers) {
                ans = remaining_papers; // Yeh ek valid h-index hai (isey save kar lo)
                high = mid - 1;         // Left me jao taaki mid chota ho aur papers ka count (remaining_papers) badh sake!
            } else {
                low = mid + 1;          // Citations bohot kam hain, unhe badhane ke liye right jao
            }
        }
        
        return ans; // Jo sabse bada valid papers ka count mila, wahi h-index hai
    }
}