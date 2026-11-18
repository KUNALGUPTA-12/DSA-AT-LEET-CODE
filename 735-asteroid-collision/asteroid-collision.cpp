class Solution {
public:
    vector<int> asteroidCollision(vector<int>& asteroids) {
        stack<int> st;

        for(int ast : asteroids){
            bool destroyed = false;

            while(!st.empty() && st.top() > 0 && ast < 0){
                if(st.top() < abs(ast)){
                    st.pop();
                    continue;
                }
                else if(st.top() == abs(ast)){
                    st.pop();
                }
                destroyed = true;
                break;
            }
            if(!destroyed){
                st.push(ast);
            }
        }
        vector<int> ans(st.size());
        for(int i = st.size() - 1;i >= 0;i--){
            ans[i] = st.top();
            st.pop();
        }
        return ans;
    }
};