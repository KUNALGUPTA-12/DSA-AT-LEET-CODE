class Solution {
public:
    int equalSubstring(string s, string t, int maxCost) {
        int left = 0,current_cost = 0,max_length = 0;

        for(int r  = 0;r < s.length();r++){
            // memeory me s[right] aur t[right ki ascii values ka diifernce add karo for seen cost]
            current_cost += abs(s[r] - t[r]);
            // agar karcha buget se jayada hai shrink the window

            while(current_cost > maxCost) {
                current_cost -= abs(s[left] - t[left]);
                left++;
            }
            max_length = max(max_length , r - left + 1);
        }
        return max_length;
    }
};