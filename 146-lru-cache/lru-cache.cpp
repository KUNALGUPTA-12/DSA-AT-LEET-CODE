class LRUCache {
public:
    // Doubly Linked List ka Node
    struct Node {
        int key, val;
        Node* prev;
        Node* next;
        Node(int k, int v) : key(k), val(v), prev(nullptr), next(nullptr) {}
    };

    int cap;
    unordered_map<int, Node*> mp;
    Node* head = new Node(-1, -1); // Dummy head (Most Recent side)
    Node* tail = new Node(-1, -1); // Dummy tail (Least Recent side)

    LRUCache(int capacity) {
        cap = capacity;
        head->next = tail;
        tail->prev = head;
    }

    // Node ko head ke bilkul baad (sabse aage) lagane ka function
    void addNode(Node* newNode) {
        Node* temp = head->next;
        newNode->next = temp;
        newNode->prev = head;
        head->next = newNode;
        temp->prev = newNode;
    }

    // Kisi bhi node ko list se hatane ka function
    void deleteNode(Node* delNode) {
        Node* delPrev = delNode->prev;
        Node* delNext = delNode->next;
        delPrev->next = delNext;
        delNext->prev = delPrev;
    }

    int get(int key) {
        if (mp.find(key) != mp.end()) {
            Node* resNode = mp[key];
            int ans = resNode->val;
            
            // Use hone ke baad ise sabse aage move karo
            deleteNode(resNode);
            addNode(resNode);
            
            return ans;
        }
        return -1;
    }

    void put(int key, int value) {
        // Agar key pehle se hai, toh purana node hatao
        if (mp.find(key) != mp.end()) {
            Node* existingNode = mp[key];
            mp.erase(key);
            deleteNode(existingNode);
            delete existingNode;
        }
        
        // Agar capacity full hai, toh tail ke paas wala sabse purana node hatao
        if (mp.size() == cap) {
            Node* lruNode = tail->prev;
            mp.erase(lruNode->key);
            deleteNode(lruNode);
            delete lruNode;
        }

        // Naya node bana kar sabse aage add karo
        Node* newNode = new Node(key, value);
        addNode(newNode);
        mp[key] = newNode;
    }
};
