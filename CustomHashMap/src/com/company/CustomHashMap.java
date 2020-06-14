package com.company;

import java.util.ArrayList;
import java.util.List;

public class CustomHashMap {
    private int size = 0;
    private HashEntry[] hashTable = new HashEntry[16];

    public CustomHashMap() {
    }

    private int getIndex(Object key) {
        int index = key.hashCode() % (hashTable.length - 1);
        while (index < 0) {
            index += hashTable.length;
        }
        return index;
    }

    private void threshold() {
        if (size == (int) (hashTable.length * 0.75)) {
            HashEntry[] oldHashTable = hashTable;
            hashTable = new HashEntry[hashTable.length * 2];
            size = 0;
            for (HashEntry temp : oldHashTable) {
                if (temp != null) {
                    while (temp.getNext() != null) {
                        put(temp.getKey(), temp.getValue());
                        temp = temp.getNext();
                    }
                    put(temp.getKey(), temp.getValue());
                }
            }
        }
    }

    public void put(Object key, Object value) {
        threshold();
        int index = getIndex(key);
        if (hashTable[index] == null) {
            hashTable[index] = new HashEntry(key, value);
            size++;
        } else {
            remove(key);
            if (hashTable[index] == null) {
                put(key, value);
            } else {
                HashEntry temp = hashTable[index];
                while (temp.getNext() != null) {
                    temp = temp.getNext();
                }
                temp.setNext(new HashEntry(key, value));
            }
        }
    }

    public void remove(Object key) {
        int index = getIndex(key);
        if (hashTable[index] == null) {
            return;
        } else {
            if (hashTable[index].getNext() == null) {
                if (hashTable[index].getKey().equals(key)) {
                    hashTable[index] = null;
                    size--;
                }
            } else {
                if (hashTable[index].getKey().equals(key)) {
                    hashTable[index] = hashTable[index].getNext();
                } else {
                    HashEntry temp = hashTable[index];
                    while (temp.getNext() != null) {
                        if (temp.getNext().getKey().equals(key)) {
                            temp.setNext(temp.getNext().getNext());
                        }
                        temp = temp.getNext();
                    }
                }
            }
        }
    }

    public Object get(Object key) {
        int index = getIndex(key);
        if (index < hashTable.length && hashTable[index] != null) {
            if (hashTable[index].getNext() == null && hashTable[index].getKey().equals(key)) {
                return hashTable[index].getValue();
            } else {
                HashEntry temp = hashTable[index];
                while (temp.getNext() != null) {
                    if (temp.getKey().equals(key)) {
                        return temp.getValue();
                    }
                    temp = temp.getNext();
                }
                if (temp.getKey().equals(key)) {
                    return temp.getValue();
                }
            }
        }
        return null;
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public List toList() {
        List lst = new ArrayList();
        for (int i = 0; i < hashTable.length; i++) {
            if (hashTable[i] != null) {
                if (hashTable[i].getNext() != null) {
                    HashEntry temp = hashTable[i];
                    while (temp != null) {
                        lst.add(temp.getKey() + "-" + hashTable[i].getValue());
                        temp = temp.getNext();
                    }
                } else {
                    lst.add(hashTable[i].getKey() + "-" + hashTable[i].getValue());
                }
            }
        }
        return lst;
    }
}
