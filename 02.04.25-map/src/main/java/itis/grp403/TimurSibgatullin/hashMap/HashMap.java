package itis.grp403.TimurSibgatullin.hashMap;

import itis.grp403.TimurSibgatullin.GenericList.List;
import itis.grp403.TimurSibgatullin.Set;

import javax.swing.border.EmptyBorder;

public class HashMap<K,V> implements HashMapInterface<K,V> {
    public HashMap() {
        this.array = new Node[16];
    }

    private class EntryImpl<K,V> implements Entry<K,V> {
        K key;
        V value;

        public EntryImpl(K key, V value) {
            this.key = key;
            this.value = value;
        }

        @Override
        public K getKey() {
            return key;
        }

        @Override
        public void setKey(K key) {
            this.key = key;
        }

        @Override
        public V getValue() {
            return value;
        }

        @Override
        public void setValue(V value) {
            this.value = value;
        }
    }
    private int capacity = 16;
    private int size;
    private class Node<K,V> {
        public Node(K key, V value) {
            this.value = new EntryImpl<K,V>(key, value);
            this.next = null;
        }

        Entry<K,V> value;
        Node<K,V> next;
    }
    private Node<K,V>[] array;

    public HashMap(Node[] array) {
        this.array = new Node[16];
    }

    @Override
    public void put(K key, V value) {
        int index = Math.abs(key.hashCode());
        index = index % capacity;
        Node<K,V> temp = new Node<>(key, value);
        if (array[index] == null) {
            array[index] = temp;
        } else {
            Node current = array[index];
            while(current.next != null) {
                if (current.value.getKey().equals(key)) {
                    current.value.setValue(value);
                }
                current = current.next;
            }
            current.next = temp;
        }
        size++;
    }

    @Override
    public V get(K key) {
        int index = Math.abs(key.hashCode()) % capacity;
        if (array[index] == null) {
            return null;
        }
        Node<K, V> current = array[index];
        while(current != null) {
            if (current.value.getKey().equals(key)) {
                return current.value.getValue();
            }
            current = current.next;
        }
        return null;
    }

    @Override
    public Set<K> keySet() {
        return null;
    }

    @Override
    public List<K> values() {
        return null;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean containsKey(K key) {
        return false;
    }

    @Override
    public boolean isEmpty() {
        return false;
    }

    @Override
    public boolean containsValue(V value) {
        return false;
    }

    @Override
    public V remove(K key) {
        return null;
    }

    @Override
    public void clear() {

    }
}
