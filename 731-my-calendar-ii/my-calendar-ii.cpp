class MyCalendarTwo {
private:
    vector<pair<int, int>> bookings;        // Saare booked events
    vector<pair<int, int>> doubleBookings;  // Sirf double-booked (overlap) zones

public:
    MyCalendarTwo() {
        // Constructor khali rahega
    }
    
    bool book(int startTime, int endTime) {
        // 1. Check karo kya yeh naya event kisi double-booked zone se takra raha hai?
        for (const auto& sub : doubleBookings) {
            if (max(startTime, sub.first) < min(endTime, sub.second)) {
                return false; // Triple booking ho gayi! Reject karo
            }
        }
        
        // 2. Agar safe hai, toh dekho pichli bookings ke saath kahan-kahan double booking ban rahi hai
        for (const auto& b : bookings) {
            if (max(startTime, b.first) < min(endTime, b.second)) {
                // Takraav ka common area nikal kar doubleBookings mein daal do
                int overlapStart = max(startTime, b.first);
                int overlapEnd = min(endTime, b.second);
                doubleBookings.push_back({overlapStart, overlapEnd});
            }
        }
        
        // 3. Is naye event ko successfully book karo
        bookings.push_back({startTime, endTime});
        return true; 
    }
};

/**
 * Your MyCalendarTwo object will be instantiated and called as such:
 * MyCalendarTwo* obj = new MyCalendarTwo();
 * bool param_1 = obj->book(startTime,endTime);
 */