class Solution {
public:
    int numberOfSteps(int num) {
         int step_count = 0; // snake_case variable
        
        // Jab tak number 0 nahi hota, tab tak loop chalega
        while (num > 0) {
            // % 2 == 0 matlab even check kar rahe hain
            if (num % 2 == 0) {
                num /= 2; // num = num / 2 likhne ka short tarika
            } 
            else {
                num -= 1; // num = num - 1 likhne ka short tarika
            }
            
            step_count++; // Step badha diya
        }
        
        return step_count;
    }
};