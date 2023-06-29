package io.lcalmsky.leetcode.lru_cache;

import java.util.HashMap;
import java.util.Map;

public class LRUCache {

    private final Map<Integer, Node> cache;
    private final int capacity;
    private final Node dummyHead;
    private final Node dummyTail;

    public LRUCache(int capacity) {
        this.cache = new HashMap<>();
        this.capacity = capacity;
        this.dummyHead = new Node();
        this.dummyTail = new Node();
        this.dummyHead.next = dummyTail;
        this.dummyTail.prev = dummyHead;
    }

    public int get(int key) {
        if (!cache.containsKey(key)) {
            return -1;
        }
        Node node = cache.get(key);
        moveToHead(node);
        return node.value;
    }

    public void put(int key, int value) {
        Node node = cache.get(key);
        if (node != null) {
            node.value = value;
            moveToHead(node);
            return;
        }
        Node newNode = new Node();
        newNode.key = key;
        newNode.value = value;
        cache.put(key, newNode);
        addNodeToHead(newNode);
        removeTailIfCapacityExceeded();
    }

    private void moveToHead(Node node) {
        removeNode(node);
        addNodeToHead(node);
    }

    private void removeNode(Node node) {
        Node prev = node.prev;
        Node next = node.next;
        prev.next = next;
        next.prev = prev;
    }

    private void addNodeToHead(Node node) {
        node.prev = dummyHead;
        node.next = dummyHead.next;
        dummyHead.next.prev = node;
        dummyHead.next = node;
    }

    private void removeTailIfCapacityExceeded() {
        if (cache.size() > this.capacity) {
            Node removedTail = removeTail();
            this.cache.remove(removedTail.key);
        }
    }

    private Node removeTail() {
        Node realTail = dummyTail.prev;
        removeNode(realTail);
        return realTail;
    }

    private final static class Node {
        private int key;
        private int value;
        private Node prev;
        private Node next;
    }
}
