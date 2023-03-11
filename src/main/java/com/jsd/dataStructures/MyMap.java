package com.jsd.dataStructures;

import java.util.ArrayList;
import java.util.List;

public class MyMap<K, V> {
    private List<Entry<K, V>> entries;

    public MyMap() {
        entries = new ArrayList<>();
    }

    public void add(K key, V value) {
        for (Entry<K, V> entry : entries) {
            if (entry.getKey().equals(key)) {
                entry.setValue(value);
                return;
            }
        }
        entries.add(new Entry<>(key, value));
    }

    public V find(K key) {
        for (Entry<K, V> entry : entries) {
            if (entry.getKey().equals(key)) {
                return entry.getValue();
            }
        }
        return null;
    }

    public void remove(K key) {
        Entry<K, V> toRemove = null;
        for (Entry<K, V> entry : entries) {
            if (entry.getKey().equals(key)) {
                toRemove = entry;
                break;
            }
        }
        if (toRemove != null) {
            entries.remove(toRemove);
        }
    }

    public List<Entry<K, V>> getEntries() {
        return entries;
    }

    public static void main(String[] args) {
        MyMap<String, Integer> myMap = new MyMap<>();
        myMap.add("one", 1);
        myMap.add("two", 2);
        myMap.add("three", 3);

        List<Entry<String, Integer>> entries = myMap.getEntries();
        int i = 0;
        do {
            Entry<String, Integer> entry = entries.get(i);
            System.out.println(entry.getKey() + " = " + entry.getValue());
            i++;
        } while (i < entries.size());
    }

    private static class Entry<K, V> {
        private K key;
        private V value;

        public Entry(K key, V value) {
            this.key = key;
            this.value = value;
        }

        public K getKey() {
            return key;
        }

        public V getValue() {
            return value;
        }

        public void setValue(V value) {
            this.value = value;
        }
    }
}
