class Solution {
    public List<Integer> survivedRobotsHealths(int[] positions, int[] healths, String directions) {
        int n = positions.length;
        Integer[] indices = new Integer[n];
        
        for (int i = 0; i < n; i++) {
            indices[i] = i;
        }
        
        // Positions ke hisaab se indices ko sort karo
        Arrays.sort(indices, (a, b) -> Integer.compare(positions[a], positions[b]));
        
        Stack<Integer> st = new Stack<>();
        
        for (int curr : indices) {
            if (directions.charAt(curr) == 'R') {
                st.push(curr);
            } 
            else {
                while (!st.isEmpty() && healths[curr] > 0) {
                    int topIdx = st.peek();
                    
                    if (healths[topIdx] < healths[curr]) {
                        healths[topIdx] = 0;
                        healths[curr] -= 1;
                        st.pop();
                    } 
                    else if (healths[topIdx] > healths[curr]) {
                        healths[curr] = 0;
                        healths[topIdx] -= 1;
                    } 
                    else {
                        healths[topIdx] = 0;
                        healths[curr] = 0;
                        st.pop();
                    }
                }
            }
        }
        
        List<Integer> ans = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            if (healths[i] > 0) {
                ans.add(healths[i]);
            }
        }
        
        return ans;
    }
}
