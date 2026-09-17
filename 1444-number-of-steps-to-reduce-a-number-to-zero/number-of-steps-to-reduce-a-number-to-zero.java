class Solution {
    public int numberOfSteps(int num) {
          int stepCount = 0; // camelCase variable
        
        // Jab tak number 0 nahi hota, loop chalta rahega
        while (num > 0) {
            // Agar number even hai (2 se poora divide ho raha hai)
            if (num % 2 == 0) {
                num = num / 2;
            } 
            // Agar number odd hai
            else {
                num = num - 1;
            }
            
            // Har baar ek step badha do
            stepCount++;
        }
        
        return stepCount;
    }
}