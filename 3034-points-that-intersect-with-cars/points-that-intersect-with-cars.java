class Solution {
    public int numberOfPoints(List<List<Integer>> nums) {
         // Unique slots ko yaad rakhne ke liye HashSet banaya
        HashSet<Integer> uniquePoints = new HashSet<>();
        
        // 1. Yeh loop ek-ek karke saari rows (cars) par jayega
        for (int i = 0; i < nums.size(); i++) {
            
            // nums.get(i).get(0) -> i-th row (car) ka Start Point
            int start = nums.get(i).get(0); 
            
            // nums.get(i).get(1) -> i-th row (car) ka End Point
            int end = nums.get(i).get(1);   
            
            // 2. Start se lekar End tak ke saare slots ko set mein add karo
            for (int j = start; j <= end; j++) {
                uniquePoints.add(j); // HashSet duplicate values ko dobara add nahi karega
            }
        }
        
        // 3. Set ka total size hi hamara final answer hai
        return uniquePoints.size();
    }
}