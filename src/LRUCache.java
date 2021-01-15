import java.util.HashMap;
import java.util.Map;
import java.util.Queue;

public class LRUCache {
    class DoubleLinkedNode{
        public int key;
        public int value;
        public DoubleLinkedNode prev;
        public DoubleLinkedNode next;
    }
    private Map<Integer,DoubleLinkedNode> cache;
    private int capacity;
    private int size;
    private DoubleLinkedNode head, tail;

    public LRUCache(int capacity){
        this.cache = new HashMap<>();
        this.capacity = capacity;
        this.size = 0;

        this.head = new DoubleLinkedNode();
        this.tail = new DoubleLinkedNode();

        head.next = tail;
        tail.prev = head;
    }

    private void addNode(DoubleLinkedNode node){
        node.prev = head;
        node.next = head.next;

        head.next.prev = node;
        head.next = node;
    }

    private void removeNode(DoubleLinkedNode node){
        node.next.prev = node.prev;
        node.prev.next = node.next;
    }

    private DoubleLinkedNode popTail(){
        DoubleLinkedNode old = tail.prev;
        removeNode(old);
        return old;
    }

    private void moveToHead(DoubleLinkedNode node){
        // Pull current node out of its location in list
        node.prev.next = node.next;
        node.next.prev = node.prev;

        // Insert it at front
        node.prev = head;
        node.next = head.next;

        head.next = node;
        node.next.prev = node;

    }

    public int get(int key){
        DoubleLinkedNode node = cache.get(key);
        if(node == null) return -1;
        moveToHead(node);
        return node.value;
    }

    public void put(int key, int val){
        DoubleLinkedNode node = cache.get(key);

        if(node == null){
            DoubleLinkedNode entry = new DoubleLinkedNode();
            entry.key = key;
            entry.value = val;
            cache.put(key, entry);
            addNode(entry);
            size++;

            // pop tail
            if(size > capacity){
                // This functions re organizes the links so that the item between the tail, and 2 from the tail is no longer in list, but node still exists
                DoubleLinkedNode tail = popTail();
                cache.remove(tail.key);
                size--;
            }
        }else{
            node.value = val;
            moveToHead(node);
        }
    }

    public static void main(String[] args){
        LRUCache cache = new LRUCache(2);
        LRUCache lRUCache = new LRUCache(2);
        lRUCache.put(1, 1); // cache is {1=1}
        lRUCache.put(2, 2); // cache is {1=1, 2=2}
        System.out.println(lRUCache.get(1));    // return 1
        lRUCache.put(3, 3); // LRU key was 2, evicts key 2, cache is {1=1, 3=3}
        System.out.println(lRUCache.get(2));    // returns -1 (not found)
        lRUCache.put(4, 4); // LRU key was 1, evicts key 1, cache is {4=4, 3=3}
        System.out.println(lRUCache.get(1));    // return -1 (not found)
        System.out.println(lRUCache.get(3));    // return 3
        System.out.println(lRUCache.get(4));    // return 4
    }
}

/**
 * Hashmap and doubleLinkedList implementation
 */
//public class LRUCache {
//
//    class DLinkedNode {
//        int key;
//        int value;
//        DLinkedNode prev;
//        DLinkedNode next;
//    }
//
//    private void addNode(DLinkedNode node) {
//        /**
//         * Always add the new node right after head.
//         */
//        node.prev = head;
//        node.next = head.next;
//
//        head.next.prev = node;
//        head.next = node;
//    }
//
//    private void removeNode(DLinkedNode node){
//        /**
//         * Remove an existing node from the linked list.
//         */
//        DLinkedNode prev = node.prev;
//        DLinkedNode next = node.next;
//
//        prev.next = next;
//        next.prev = prev;
//    }
//
//    private void moveToHead(DLinkedNode node){
//        /**
//         * Move certain node in between to the head.
//         */
//        removeNode(node);
//        addNode(node);
//    }
//
//    private DLinkedNode popTail() {
//        /**
//         * Pop the current tail.
//         */
//        DLinkedNode res = tail.prev;
//        removeNode(res);
//        return res;
//    }
//
//    private Map<Integer, DLinkedNode> cache = new HashMap<>();
//    private int size;
//    private int capacity;
//    private DLinkedNode head, tail;
//
//    public LRUCache(int capacity) {
//        this.size = 0;
//        this.capacity = capacity;
//
//        head = new DLinkedNode();
//        // head.prev = null;
//
//        tail = new DLinkedNode();
//        // tail.next = null;
//
//        head.next = tail;
//        tail.prev = head;
//    }
//
//    public int get(int key) {
//        DLinkedNode node = cache.get(key);
//        if (node == null) return -1;
//
//        // move the accessed node to the head;
//        moveToHead(node);
//
//        return node.value;
//    }
//
//    public void put(int key, int value) {
//        DLinkedNode node = cache.get(key);
//
//        if(node == null) {
//            DLinkedNode newNode = new DLinkedNode();
//            newNode.key = key;
//            newNode.value = value;
//
//            cache.put(key, newNode);
//            addNode(newNode);
//
//            ++size;
//
//            if(size > capacity) {
//                // pop the tail
//                DLinkedNode tail = popTail();
//                cache.remove(tail.key);
//                --size;
//            }
//        } else {
//            // update the value.
//            node.value = value;
//            moveToHead(node);
//        }
//    }
//}


/**
 * Pretty much some implementation as above, except using the java.utils.linkedhashmap instead of building one customly
 */
//class LRUCache extends LinkedHashMap<Integer, Integer>{
//    private int capacity;
//
//    public LRUCache(int capacity) {
//        super(capacity, 0.75F, true);
//        this.capacity = capacity;
//    }
//
//    public int get(int key) {
//        return super.getOrDefault(key, -1);
//    }
//
//    public void put(int key, int value) {
//        super.put(key, value);
//    }
//
//    @Override
//    protected boolean removeEldestEntry(Map.Entry<Integer, Integer> eldest) {
//        return size() > capacity;
//    }
//}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */