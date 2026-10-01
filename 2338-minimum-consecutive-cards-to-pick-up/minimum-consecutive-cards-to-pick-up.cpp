class Solution {
public:
    int minimumCardPickup(vector<int>& cards) {
        std::unordered_map<int,int> last_seen;
        int min_cards = INT_MAX;

        for(int i = 0;i < cards.size();i++){
            int current_cards = cards[i];

            if(last_seen.count(current_cards)){
                int length = i - last_seen[current_cards] + 1;
                min_cards = std::min(min_cards,length);
            }
            last_seen[current_cards] = i;
        }
        return (min_cards == INT_MAX)? -1 : min_cards;
    }
};