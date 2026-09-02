class Solution {
    public int[][] intervalIntersection(int[][] firstList, int[][] secondList) {
         List<int[]> result = new ArrayList<>();
        int i = 0; // Pointer for firstList
        int j = 0; // Pointer for secondList

        // Jab tak dono arrays me elements bache hain
        while (i < firstList.length && j < secondList.length) {
            
            // Formula: Starts ka maximum aur Ends ka minimum
            int start_time = Math.max(firstList[i][0], secondList[j][0]);
            int end_time = Math.min(firstList[i][1], secondList[j][1]);

            // Agar valid common slot hai toh list me daal do
            if (start_time <= end_time) {
                result.add(new int[]{start_time, end_time});
            }

            // Galti yahan hoti hai: Jiska END time chhota hai, use aage badhao
            if (firstList[i][1] < secondList[j][1]) {
                i++; // firstList ka interval pehle khatam hua
            } else {
                j++; // secondList ka interval pehle khatam hua ya barabar hai
            }
        }

        // ArrayList ko 2D array me badal kar return karo
        return result.toArray(new int[result.size()][]);
    }
}