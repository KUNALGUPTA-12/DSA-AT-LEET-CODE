class Solution {
    public boolean isHappy(int n) {
        int slow = n,fast = n;
        while(fast != 1 && getNext(fast) != 1){
            slow = getNext(slow);
            fast = getNext(getNext(fast));
            if(fast == slow) return false;
        }
        return true;
    }
    int getNext(int num){
        int sum = 0;
        while(num > 0){
        int d = num % 10 ;
        sum += d*d;
        num /= 10;
        }
    return sum;
    }    
}