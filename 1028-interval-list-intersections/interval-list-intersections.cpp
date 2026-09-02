class Solution {
public:
    vector<vector<int>> intervalIntersection(vector<vector<int>>& firstList, vector<vector<int>>& secondList) {
        vector<vector<int>> result;
         int i = 0; // Pointer for firstList
        int j = 0; // Pointer for secondList

        while (i < firstList.size() && j < secondList.size()) {
            
            // Formula: Max of starts, Min of ends
            int start_time = max(firstList[i][0], secondList[j][0]);
            int end_time = min(firstList[i][1], secondList[j][1]);

            // Agar start_time chhota ya barabar hai end_time ke
            if (start_time <= end_time) {
                result.push_back({start_time, end_time});
            }

            // Pointer increment karne ka dimaag
            if (firstList[i][1] < secondList[j][1]) {
                i++;
            } else {
                j++;
            }
        }

        return result;
    }
};