class MyCalendarTwo {
private List<int[]> bookings;       // Saare booked events
    private List<int[]> doubleBookings; // Sirf double-booked (overlap) zones

    public MyCalendarTwo() {
        bookings = new ArrayList<>();
        doubleBookings = new ArrayList<>();
    }
    
    public boolean book(int startTime, int endTime) {
        // 1. Check karo kya yeh naya event kisi double-booked zone se takra raha hai?
        for (int[] sub : doubleBookings) {
            if (Math.max(startTime, sub[0]) < Math.min(endTime, sub[1])) {
                return false; // Triple booking ho gayi! Reject karo
            }
        }
        
        // 2. Agar safe hai, toh dekho pichli bookings ke saath kahan-kahan double booking ban rahi hai
        for (int[] b : bookings) {
            if (Math.max(startTime, b[0]) < Math.min(endTime, b[1])) {
                // Takraav ka common area nikal kar doubleBookings mein daal do
                int overlapStart = Math.max(startTime, b[0]);
                int overlapEnd = Math.min(endTime, b[1]);
                doubleBookings.add(new int[]{overlapStart, overlapEnd});
            }
        }
        
        // 3. Is naye event ko successfully book karo
        bookings.add(new int[]{startTime, endTime});
        return true;
    }
}

/**
 * Your MyCalendarTwo object will be instantiated and called as such:
 * MyCalendarTwo obj = new MyCalendarTwo();
 * boolean param_1 = obj.book(startTime,endTime);
 */