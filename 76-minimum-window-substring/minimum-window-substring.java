class Solution {
    public String minWindow(String s, String t) {
        int m = s.length();
        int n = t.length();
        if(m < n) return "";
        int[] targetFreq = new int[128];
        int[] windowFreq = new int[128];
        String ans = "";
        int minLen = Integer.MAX_VALUE,left = 0,matchCount = 0;

        for(char c : t.toCharArray()){
            targetFreq[c]++;
        }
        for(int r = 0;r < m;r++){
            char rChar = s.charAt(r);
            windowFreq[rChar]++;

            if(targetFreq[rChar] > 0 && windowFreq[rChar] <= targetFreq[rChar]){
                matchCount++;
            }
            while(matchCount == n){
                if(r-left+1 < minLen){
                    minLen = r-left+1;
                    ans = s.substring(left,r + 1);
                }
                char lChar = s.charAt(left);
                windowFreq[lChar]--;
                if(targetFreq[lChar] > 0 && windowFreq[lChar] < targetFreq[lChar]){
                    matchCount--;
                }
                left++;
            }
        }
        return (minLen == Integer.MAX_VALUE)? "" : ans;
    }
}