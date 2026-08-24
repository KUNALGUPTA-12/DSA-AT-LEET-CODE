class Solution {
    public int totalFruit(int[] fruits) {
        // this is solve by an hash map
        // int n = fruits.length,left = 0,maxFruits = 0;
        // Map<Integer, Integer> basket = new HashMap<>();
        // for(int right = 0;right < n;right++){
        //     basket.put(fruits[right],basket.getOrDefault(fruits[right],0)+1);
        //     while(basket.size() > 2 ){
        //         int leftFruit = fruits[left];
        //         basket.put(leftFruit,basket.get(leftFruit) - 1);
        //         if(basket.get(leftFruit) == 0){
        //             basket.remove(leftFruit);
        //         }
        //         left++;
        //     }
        //     maxFruits = Math.max(maxFruits,right-left+1);
        // }
        // return maxFruits;

        // new code this an solve by an array 
        int n = fruits.length,left = 0,maxFruits = 0,uniqueCount = 0;
        int[] freq = new int[100001];
        for(int r = 0;r < n;r++){
            if(freq[fruits[r]]++ == 0) uniqueCount ++;
            while(uniqueCount > 2){
                if(--freq[fruits[left++]] == 0) uniqueCount--;
            }
            maxFruits = Math.max(maxFruits,r-left+1);
        }
        return maxFruits;
    }
}