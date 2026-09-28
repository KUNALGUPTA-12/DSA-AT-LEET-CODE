class Solution {
public:
    double findMedianSortedArrays(vector<int>& nums1, vector<int>& nums2) {
         if (nums1.size() > nums2.size()) {
            return findMedianSortedArrays(nums2, nums1);
        }

        int m = nums1.size();
        int n = nums2.size();
        int left = 0, right = m;

        while (left <= right) {
            int i = left + (right - left) / 2;
            int j = (m + n + 1) / 2 - i;

            int L1 = (i == 0) ? INT_MIN : nums1[i - 1];
            int R1 = (i == m) ? INT_MAX : nums1[i];

            int L2 = (j == 0) ? INT_MIN : nums2[j - 1];
            int R2 = (j == n) ? INT_MAX : nums2[j];

            if (L1 <= R2 && L2 <= R1) {
                if ((m + n) % 2 == 1) {
                    return max(L1, L2);
                }
                return (max(L1, L2) + min(R1, R2)) / 2.0;
            }
            else if (L1 > R2) {
                right = i - 1;
            }
            else {
                left = i + 1;
            }
        }
        return 0.0;
    }
};