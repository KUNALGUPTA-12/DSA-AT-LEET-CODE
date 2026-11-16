class LFUCache {
    class Node {
        int key, val, cnt;
        Node prev, next;
        Node(int key, int val) {
            this.key = key;
            this.val = val;
            this.cnt = 1;
        }
    }

    class DLList {
        int size;
        Node head, tail;
        DLList() {
            head = new Node(0, 0);
            tail = new Node(0, 0);
            head.next = tail;
            tail.prev = head;
            size = 0;
        }

        void addFront(Node node) {
            Node temp = head.next;
            node.next = temp;
            node.prev = head;
            head.next = node;
            temp.prev = node;
            size++;
        }

        void removeNode(Node delNode) {
            Node delPrev = delNode.prev;
            Node delNext = delNode.next;
            delPrev.next = delNext;
            delNext.prev = delPrev;
            size--;
        }
    }

    final int capacity;
    int curSize;
    int minFreq;
    Map<Integer, Node> keyNode;
    Map<Integer, DLList> freqListMap;

    public LFUCache(int capacity) {
        this.capacity = capacity;
        this.curSize = 0;
        this.minFreq = 0;
        this.keyNode = new HashMap<>();
        this.freqListMap = new HashMap<>();
    }

    private void updateFreqListMap(Node node) {
        keyNode.remove(node.key);
        freqListMap.get(node.cnt).removeNode(node);

        if (node.cnt == minFreq && freqListMap.get(node.cnt).size == 0) {
            minFreq++;
        }

        DLList nextHigherFreqList = freqListMap.getOrDefault(node.cnt + 1, new DLList());
        node.cnt += 1;
        nextHigherFreqList.addFront(node);
        freqListMap.put(node.cnt, nextHigherFreqList);
        keyNode.put(node.key, node);
    }

    public int get(int key) {
        if (keyNode.containsKey(key)) {
            Node node = keyNode.get(key);
            int val = node.val;
            updateFreqListMap(node);
            return val;
        }
        return -1;
    }

    public void put(int key, int value) {
        if (capacity == 0) {
            return;
        }
        if (keyNode.containsKey(key)) {
            Node node = keyNode.get(key);
            node.val = value;
            updateFreqListMap(node);
        } else {
            if (curSize == capacity) {
                DLList list = freqListMap.get(minFreq);
                keyNode.remove(list.tail.prev.key);
                list.removeNode(list.tail.prev);
                curSize--;
            }
            curSize++;
            minFreq = 1;
            DLList listFreq = freqListMap.getOrDefault(minFreq, new DLList());
            Node node = new Node(key, value);
            listFreq.addFront(node);
            keyNode.put(key, node);
            freqListMap.put(minFreq, listFreq);
        }
    }
}

/**
 * Your LFUCache object will be instantiated and called as such:
 * LFUCache obj = new LFUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */
