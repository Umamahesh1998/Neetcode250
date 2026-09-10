package org.ps1.linkedList;

import java.util.HashMap;
import java.util.Map;

class LRUCache {
    class Node {
        int key;
        int value;
        Node prev;
        Node next;

        public Node(int key, int value) {
            this.value = value;
            this.key = key;
        }
    }

    private final int capacity;
    private final Map<Integer, Node> map;
    private final Node dummyHead;
    private final Node dummyTail;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        this.map = new HashMap<>();
        dummyHead = new Node(0, 0);
        dummyTail = new Node(0, 0);
        dummyHead.next = dummyTail;
        dummyTail.prev = dummyHead;
    }


    public int get(int key) {
        if (!map.containsKey(key))
            return -1;
        Node node = map.get(key);
        //recently used move to front
        remove(node);
        moveToFront(node);
        return node.value;
    }

    private void moveToFront(Node node) {
        Node first = dummyHead.next;
        node.next = first;
        node.prev = dummyHead;
        dummyHead.next = node;
        first.prev = node;
    }

    private void remove(Node node) {
        Node prevNode = node.prev;
        Node nextNode = node.next;
        prevNode.next = nextNode;
        nextNode.prev = prevNode;
    }

    public void put(int key, int value) {
        if (map.containsKey(key)) {
            Node node = map.get(key);
            node.value = value;
            remove(node);
            moveToFront(node);
            return;
        }
        Node node = new Node(key, value);
        map.put(key, node);
        moveToFront(node);
        //if capacity exceeds
        if (map.size() > capacity) {
            Node lru = dummyTail.prev;
            remove(lru);
            map.remove(lru.key);
        }
    }
}

public class LeastRecentyUsedCache_146_7 {
}
