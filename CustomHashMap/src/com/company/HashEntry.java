package com.company;

public class HashEntry<K, V> {
    private K key;
    private V value;
    private HashEntry next;

    HashEntry(K key, V value) {
        this.key = key;
        this.value = value;
        this.next = null;
    }

    public K getKey() {
        return key;
    }

    public V getValue() {
        return value;
    }

    public void setNext(HashEntry next) {
        this.next = next;
    }

    public HashEntry getNext() {
        return next;
    }
}
