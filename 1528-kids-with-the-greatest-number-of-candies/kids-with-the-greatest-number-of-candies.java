class Solution {
    public List<Boolean> kidsWithCandies(int[] candies, int extraCandies) {
          int maxCandies = 0; // camelCase
        
        for (int i = 0; i < candies.length; i++) {
            if (candies[i] > maxCandies) {
                maxCandies = candies[i];
            }
        }
        
        List<Boolean> result = new ArrayList<>(); // camelCase
        
        for (int i = 0; i < candies.length; i++) {
            // Smart shortcut using camelCase variables
            result.add(candies[i] + extraCandies >= maxCandies);
        }
        
        return result;
    }
}