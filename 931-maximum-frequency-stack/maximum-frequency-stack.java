class FreqStack {
    // 1. Yeh map batayega ki kaunsa number ab tak kitni baar aaya hai (e.g., 5 -> 3 baar)
    private Map<Integer, Integer> freq;
    
    // 2. Yeh map har frequency (Floor 1, Floor 2, Floor 3) ke liye ek alag Stack banayega
    private Map<Integer, Stack<Integer>> group;
    
    // 3. Yeh yaad rakhega ki abhi sabse badi frequency (sabse uncha floor) kaunsa hai
    private int maxFreq;

    public FreqStack() {
        // Constructor: Jab naya FreqStack banega toh dono maps khali aur maxFreq 0 hoga
        freq = new HashMap<>();
        group = new HashMap<>();
        maxFreq = 0;
    }
    
    // --- PUSH FUNCTION (Naya number daalne ke liye) ---
    public void push(int val) {
        // Line A: 'val' ki purani ginti nikalo (nahi hai toh 0) aur usmein 1 jod kar save karo
        int f = freq.getOrDefault(val, 0) + 1;
        freq.put(val, f);
        
        // Line B: Check karo ki kya 'val' ab sabse zyada baar aane wala number ban gaya hai?
        if (f > maxFreq) {
            maxFreq = f; // Agar haan, toh sabse uncha floor (maxFreq) update kar do
        }
        
        // Line C: Agar Floor number 'f' par abhi tak koi stack nahi bana hai, toh naya banao
        group.putIfAbsent(f, new Stack<>());
        
        // Line D: Floor number 'f' wale stack mein 'val' ko sabse upar rakh do
        group.get(f).push(val);
    }
    
    // --- POP FUNCTION (Sabse zyada baar aane wala number nikalne ke liye) ---
    public int pop() {
        // Line E: Sabse unche floor (maxFreq) ke stack se sabse upar wala number bahar nikalo
        int topVal = group.get(maxFreq).pop();
        
        // Line F: Kyunki ek copy bahar nikal gayi hai, isliye us number ki total ginti 1 kam karo
        freq.put(topVal, freq.get(topVal) - 1);
        
        // Line G: Check karo ki kya sabse unche floor (maxFreq) ka stack ab bilkul khali ho gaya?
        if (group.get(maxFreq).isEmpty()) {
            maxFreq--; // Agar floor khali ho gaya, toh ab ek floor neeche (maxFreq - 1) aa jao!
        }
        
        // Line H: Jo number nikala tha, use return kar do
        return topVal;
    }
}
