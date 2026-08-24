class Solution {
public:
// advance notice (prototype)
    int getNext(int num) {
        int sum = 0;
        while(num > 0 ){
            int digit = num % 10;
            sum += digit*digit;
            num /= 10;
        }
        return sum;
    }

    bool isHappy(int n) {
        int slow = n,fast = n;
        while(fast != 1 && getNext(fast) != 1) {
            slow = getNext(slow);
            fast = getNext(getNext(fast));
            if(fast == slow)return false;
        }
        return true;
    }
};