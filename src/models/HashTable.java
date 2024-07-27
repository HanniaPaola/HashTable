package models;

import java.util.LinkedList;

public class HashTable {
    private LinkedList<Entry>[] table;
    private int size;

    public HashTable(int capacity) {
        table = new LinkedList[capacity];
        for (int i = 0; i < capacity; i++) {
            table[i] = new LinkedList<>();
        }
        size = 0;
    }

    // Función hash de suma y división
    private int hashFunction1(String key) {
        int hash = 0;
        for (int i = 0; i < key.length(); i++) {
            hash += key.charAt(i);
        }
        return Math.abs(hash) % table.length;
    }

    // Función hash de multiplicación y suma
    private int hashFunction2(String key) {
        int hash = 0;
        for (int i = 0; i < key.length(); i++) {
            hash = hash * 31 + key.charAt(i);
        }
        return Math.abs(hash) % table.length;
    }

    public void put(String key, Business value, boolean useHashFunction1) {
        int index = useHashFunction1 ? hashFunction1(key) : hashFunction2(key);
        table[index].add(new Entry(key, value));
        size++;
    }

    public Business get(String key, boolean useHashFunction1) {
        int index = useHashFunction1 ? hashFunction1(key) : hashFunction2(key);
        for (Entry entry : table[index]) {
            if (entry.getKey().equals(key)) {
                return entry.getValue();
            }
        }
        return null;
    }

    public void displayAll() {
        for (LinkedList<Entry> bucket : table) {
            for (Entry entry : bucket) {
                System.out.println(entry.getValue());
            }
        }
    }

    public int size() {
        return size;
    }
}
