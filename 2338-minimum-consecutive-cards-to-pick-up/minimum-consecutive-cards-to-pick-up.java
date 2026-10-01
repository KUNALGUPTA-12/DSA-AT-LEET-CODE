class Solution {
    public int minimumCardPickup(int[] cards) {
         HashMap<Integer, Integer> lastSeen = new HashMap<>(); // Key: Card Value, Value: Latest Index
        int minCards = Integer.MAX_VALUE; // Memory me initial value Infinity rakhi hai
        
        for (int i = 0; i < cards.length; i++) {
            int currentCard = cards[i];
            
            // containsKey memory check karega ki kya yeh card pehle kabhi dekha hai?
            if (lastSeen.containsKey(currentCard)) {
                // Agar joda mila, toh dono ke beech ke lagatar cards ki length nikalo
                int length = i - lastSeen.get(currentCard) + 1;
                minCards = Math.min(minCards, length); // Sabse choti length ko safe rakho
            }
            
            // Har baar card ka sabse naya index map me update/insert kar do
            lastSeen.put(currentCard, i);
        }
        
        // Agar minCards abhi bhi Integer.MAX_VALUE hai (matlab koi joda nahi mila), toh -1 return karo
        return (minCards == Integer.MAX_VALUE) ? -1 : minCards;
    }
}