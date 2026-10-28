class Solution {
public:
    int visiblePoints(vector<vector<int>>& points, int angle, vector<int>& location) {
        vector<double> angles;
        int common_points = 0;
        int posx = location[0];
        int posy = location[1];
        
        // 1. Har point ka angle nikalna
        for (const auto& p : points) {
            if (p[0] == posx && p[1] == posy) {
                common_points++; // Same location wale points hamesha dikhenge
                continue;
            }
            // atan2 se radian nikal kar use degree me convert kiya
            double angle_rad = atan2(p[1] - posy, p[0] - posx);
            double angle_deg = angle_rad * 180.0 / M_PI;
            angles.push_back(angle_deg);
        }
        
        // 2. Angles ko sort karo
        sort(angles.begin(), angles.end());
        
        // 3. Cyclic array handle karne ke liye array ko duplicate karo (+360 karke)
        int n = angles.size();
        for (int i = 0; i < n; i++) {
            angles.push_back(angles[i] + 360.0);
        }
        
        // 4. Sliding Window chalao maximum points dhoondne ke liye
        int max_visible = 0;
        int left = 0;
        
        for (int right = 0; right < angles.size(); right++) {
            // Agar right aur left angle ka difference given angle se bada ho jaye, window choti karo
            while (angles[right] - angles[left] > angle) {
                left++;
            }
            // Window ki current size check karo
            max_visible = max(max_visible, right - left + 1);
        }
        
        // 5. Total points = window ke andar wale + jo same location par the
        return max_visible + common_points;
    }
};