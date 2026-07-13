// isme dikkat ye nhi thi normal approach mae apan jab erase kar rhe thae to vo jo push tha uske baad saare elements  ek sapce pehle aa jaate thae to that was a bit costly so we need to reduce that 
import java.util.HashMap;
import java.util.Map;

class ListNode {
    int key;
    int value;
    ListNode prev;
    ListNode next;

    ListNode(int key, int value) {
        this.key = key;
        this.value = value;
    }
}

class DLinkedList {
    private ListNode head;
    private ListNode tail;

    DLinkedList() {
        head = new ListNode(-1, -1);
        tail = new ListNode(-1, -1);

        head.next = tail;
        tail.prev = head;
    }

    public void addFirst(ListNode node) {
        ListNode first = head.next;

        node.next = first;
        node.prev = head;

        head.next = node;
        first.prev = node;
    }

    public void remove(ListNode node) {
        ListNode prevNode = node.prev;
        ListNode nextNode = node.next;

        prevNode.next = nextNode;
        nextNode.prev = prevNode;

        node.prev = null;
        node.next = null;
    }

    public ListNode removeLast() {
        ListNode last = tail.prev;

        if (last == head) {
            return null;
        }

        remove(last);
        return last;
    }
}

class LRUCache {
    private int capacity;
    private Map<Integer, ListNode> cache;
    private DLinkedList cacheQueue;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        this.cache = new HashMap<>();
        this.cacheQueue = new DLinkedList();
    }

    public int get(int key) {
        if (!cache.containsKey(key)) {
            return -1;
        }

        ListNode node = cache.get(key);

        cacheQueue.remove(node);
        cacheQueue.addFirst(node);

        return node.value;
    }

    public void put(int key, int value) {
        if (cache.containsKey(key)) {
            ListNode node = cache.get(key);

            node.value = value;

            cacheQueue.remove(node);
            cacheQueue.addFirst(node);

            return;
        }

        if (cache.size() >= capacity) {
            ListNode removedNode = cacheQueue.removeLast();
            cache.remove(removedNode.key);
        }

        ListNode newNode = new ListNode(key, value);
        cacheQueue.addFirst(newNode);
        cache.put(key, newNode);
    }
}