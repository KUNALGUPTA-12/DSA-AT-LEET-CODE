class Solution {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        Map<Integer, Integer> nextGreater = new HashMap<>();
        Stack<Integer> st = new Stack<>();
        
        // Step 1: Sabhi elements ko shuru mein hi -1 de do
        for (int num : nums2) {
            nextGreater.put(num, -1);
        }
        
        // Step 2: Jisko bada number mil jaye, uska -1 update kar do
        for (int num : nums2) {
            while (!st.isEmpty() && num > st.peek()) {
                nextGreater.put(st.pop(), num);
            }
            st.push(num);
        }
        
        // Step 3: nums1 ke answers nikal kar return karo
        int[] ans = new int[nums1.length];
        for (int i = 0; i < nums1.length; i++) {
            ans[i] = nextGreater.get(nums1[i]);
        }
        
        return ans;
    }
}
