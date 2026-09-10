package org.ps1.linkedList;

import java.util.HashMap;
import java.util.Map;

class LFUCache {
    class Node {
        int key;
        int value;
        int freq;
        Node prev;
        Node next;

        public Node(int key, int value) {
            this.key = key;
            this.value = value;
            this.freq = 1;
        }
    }

    class DoublyLinkedList {
        Node head;
        Node tail;
        int size;

        public DoublyLinkedList() {
            head = new Node(0, 0);
            tail = new Node(0, 0);
            head.next = tail;
            tail.prev = head;
        }

        void addFirst(Node node) {
            Node first = head.next;
            node.next = first;
            node.prev = head;
            head.next = node;
            first.prev = node;
            size++;
        }

        void remove(Node node) {
            node.prev.next = node.next;
            node.next.prev = node.prev;
            size--;
        }

        Node removeLast() {
            if (size == 0)
                return null;
            Node node = tail.prev;
            remove(node);
            return node;
        }

        boolean isEmpty() {
            return size == 0;
        }
    }

    private int capacity;
    private int minFreq;
    private Map<Integer, Node> keyMap;
    private Map<Integer, DoublyLinkedList> freqMap;

    public LFUCache(int capacity) {
        this.capacity = capacity;
        this.minFreq = 0;
        this.keyMap = new HashMap<>();
        this.freqMap = new HashMap<>();
    }

    public int get(int key) {
        if (!keyMap.containsKey(key))
            return -1;
        Node node = keyMap.get(key);
        increaseFrequency(node);
        return node.value;
    }

    public void put(int key, int value) {
        if (capacity == 0)
            return;

        //existing key
        if (keyMap.containsKey(key)) {
            Node node = keyMap.get(key);
            node.value = value;
            increaseFrequency(node);
            return;
        }
        //cache full
        if (keyMap.size() >= capacity) {
            DoublyLinkedList list = freqMap.get(minFreq);
            Node lru = list.removeLast();
            keyMap.remove(lru.key);
        }
        //create new node
        Node node = new Node(key, value);
        keyMap.put(key, node);
        freqMap.computeIfAbsent(1, k -> new DoublyLinkedList())
                .addFirst(node);
        minFreq = 1;

    }

    private void increaseFrequency(Node node) {
        int oldFreq = node.freq;
        DoublyLinkedList oldList = freqMap.get(oldFreq);
        oldList.remove(node);
        //if old frequency was minimum
        if (oldFreq == minFreq && oldList.isEmpty()) {
            minFreq++;
        }
        node.freq++;
        freqMap.computeIfAbsent(node.freq, k -> new DoublyLinkedList())
                .addFirst(node);
    }
}

public class LFUCache_460_7 {

}
