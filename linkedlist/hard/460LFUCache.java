class Node {
    int key, val, freq;

    public Node(int key, int val) {
        this.key = key;
        this.val = val;
        this.freq = 1; // Default frequency value when a node is created for the first time.
    }
}

class LFUCache {
    private final int capacity;
    private int minFreq; // To keep track of most minimally used element

    // Final keyword used to prevent accidental reference to new Maps.
    // LinkedHashSet used to maintain insertion order. This will help when we need to get LRU node when the frequencies are same.
    private final Map<Integer, Node> keyMap;
    private final Map<Integer, LinkedHashSet<Node>> freqMap;

    // Initialization
    public LFUCache(int capacity) {
        this.capacity = capacity;
        this.minFreq = 0;
        this.keyMap = new HashMap<>();
        this.freqMap = new HashMap<>();
    }

    private void updateFreq(Node node) {
        int freq = node.freq; // Current frequency
        LinkedHashSet<Node> oldFreqSet = freqMap.get(freq);
        oldFreqSet.remove(node); // Removes the node from the old frequency list, because we will update to new frequency.

        if (freq == minFreq && oldFreqSet.isEmpty()) {
            // The last node of the old set was removed. Which means the old frequency doesn't exist anymore.
            // Update the minFreq in this case.
            minFreq++;
        }

        node.freq++; // Updating new frequency.
        freqMap.computeIfAbsent(node.freq, f -> new LinkedHashSet<>()).add(node);
    }

    public int get(int key) {
        if (!keyMap.containsKey(key))
            return -1; // No nodes found
        Node node = keyMap.get(key);
        updateFreq(node); // Updates frequency of the node and reassign to new frequency group.
        return node.val; // Value of the node
    }

    public void put(int key, int value) {
        if (capacity == 0)
            return; // Empty size
        if (keyMap.containsKey(key)) {
            // Key exists, update value and frequency
            Node node = keyMap.get(key);
            node.val = value;
            updateFreq(node);
        } else {
            // A new node has arrived. Check for existing capacity threshold and insert later
            if (keyMap.size() == capacity) {
                // Evict LFU Node (And LRU Node within it, if multiple nodes are present)
                LinkedHashSet<Node> minNodeList = freqMap.get(minFreq);
                Node evictNode = minNodeList.iterator().next();
                minNodeList.remove(evictNode);
                keyMap.remove(evictNode.key);
            }

            // Insert new node with frequency 1.
            Node newNode = new Node(key, value);
            keyMap.put(key, newNode);
            freqMap.computeIfAbsent(1, f -> new LinkedHashSet<>()).add(newNode);
            minFreq = 1; // Reset minFreq since the new node has been inserted.
        }

    }
}

/**
 * Your LFUCache object will be instantiated and called as such:
 * LFUCache obj = new LFUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */