class Solution {
public:
    vector<string> fizzBuzz(int n) {
        vector<string> answer;
        
        for (int i = 1; i <= n; i++) {
            // Agar 3 aur 5 dono se divide ho
            if (i % 3 == 0 && i % 5 == 0) {
                answer.push_back("FizzBuzz");
            } 
            // Agar sirf 3 se divide ho
            else if (i % 3 == 0) {
                answer.push_back("Fizz");
            } 
            // Agar sirf 5 se divide ho
            else if (i % 5 == 0) {
                answer.push_back("Buzz");
            } 
            // Agar kisi se divide na ho, toh number ko string banakar daalo
            else {
                answer.push_back(to_string(i));
            }
        }
        
        return answer;
    }
};