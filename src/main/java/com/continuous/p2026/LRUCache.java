package com.continuous.p2026;

import java.util.HashMap;
import java.util.Map;

public class LRUCache<K, V> {

    private final int capacity;

    private final Map<K, Node<K, V>> map;
    private final Node<K, V> head;
    private final Node<K, V> tail;

    public LRUCache(int capacity){
        this.capacity=capacity;
        this.map = new HashMap<K,Node<K, V>>();
        this.head = new Node<>(null, null);
        this.tail = new Node<>(null, null);
        head.next = tail;
        tail.prev = head;
    }

    public V get(K key){
        Node<K,V> currentNode = map.get(key);

        if(currentNode==null){
            return null;
        }
        remove(currentNode);
    }

    private void remove(Node<K,V> currentNode){
        currentNode.prev.next = currentNode.next;
        currentNode.next.prev = currentNode.prev;
    }

    private void insertAtFront(Node<K, V> currentNode){
        Node
    }
}
