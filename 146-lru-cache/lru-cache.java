class LRUCache {
    // Doubly Linked List ka Node
    class Node {
        int key, val;
        Node prev, next;
        Node(int k, int v) {
            key = k;
            val = v;
        }
    }

    int cap;
    HashMap<Integer, Node> map = new HashMap<>();
    Node head = new Node(-1, -1); // Dummy head
    Node tail = new Node(-1, -1); // Dummy tail

    public LRUCache(int capacity) {
        cap = capacity;
        head.next = tail;
        tail.prev = head;
    }

    // Node ko head ke bilkul baad add karne ka function
    private void addNode(Node newNode) {
        Node temp = head.next;
        newNode.next = temp;
        newNode.prev = head;
        head.next = newNode;
        temp.prev = newNode;
    }

    // Node ko list se delete karne ka function
    private void deleteNode(Node delNode) {
        Node delPrev = delNode.prev;
        Node delNext = delNode.next;
        delPrev.next = delNext;
        delNext.prev = delPrev;
    }

    public int get(int key) {
        if (map.containsKey(key)) {
            Node resNode = map.get(key);
            int ans = resNode.val;
            
            // Recent banane ke liye sabse aage shift karo
            deleteNode(resNode);
            addNode(resNode);
            
            return ans;
        }
        return -1;
    }

    public void put(int key, int value) {
        // Agar key pehle se मौजूद hai toh purana node hatao
        if (map.containsKey(key)) {
            Node existingNode = map.get(key);
            map.remove(key);
            deleteNode(existingNode);
        }

        // Agar capacity full ho gayi hai toh sabse purana (tail ke piche wala) hatao
        if (map.size() == cap) {
            Node lruNode = tail.prev;
            map.remove(lruNode.key);
            deleteNode(lruNode);
        }

        // Naya node bana kar sabse aage lagao
        Node newNode = new Node(key, value);
        addNode(newNode);
        map.put(key, newNode);
    }
}
