class Solution {
public:
    int numOfSubarrays(vector<int>& arr, int k, int threshold) {
        int count = 0 ;
        int current_sum = 0;
        int target_sum = k * threshold;//divion erroe  ke liye multlpiction trick
        // pehli k size ki window tayar kanrna 

        for(int i = 0;i < k;i++){
            current_sum += arr[i];
        }

        // phlei window ko check karo ki 
        if ( current_sum >= target_sum){
            count++;
        }
        // window ko aga badahao
        for(int i = k;i < arr.size();i++){
            current_sum += arr[i] - arr[i-k];
            // check karo
            if ( current_sum >= target_sum){
            count++;
            }
        }
        return count;
    }
};