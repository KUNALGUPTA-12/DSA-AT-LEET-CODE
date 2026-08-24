class Solution {
public:
    int totalFruit(vector<int>& fruits) {
        // int n = fruits.size(),left = 0,unique_count = 0,max_fruits;
        // std::vector<int> freq(100001,0);//c++ vector implementation
        // for(int right = 0;right < n;right++){
        //     // /naya fruits joda aur checkkiya yah pheeli baar aya yaha anahi
        //     if(freq[fruits[right]]++ == 0) unique_count++;
        //     // agar yah2se zayada unique fruits hai
        //     while(unique_count > 2){
        //         if(--freq[fruits[left++]] == 0) unique_count--;
        //     }
        //     max_fruits = std::max(max_fruits,right-left+1);
        // }
        // return max_fruits;

        int n = fruits.size(),left = 0,max_fruits = 0;
        std::unordered_map<int,int> basket;
        for(int r = 0;r < n;r++){
            basket[fruits[r]]++;
            while(basket.size() > 2){
                basket[fruits[left]]--;
                if(basket[fruits[left]] == 0){
                    basket.erase(fruits[left]);
                }
                left++;
            }
            max_fruits = std::max(max_fruits,r-left+1);
        }
        return max_fruits;
    }
};