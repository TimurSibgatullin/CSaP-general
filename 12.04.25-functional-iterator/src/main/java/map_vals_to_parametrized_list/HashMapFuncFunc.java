package map_vals_to_parametrized_list;

import itis.grp403.TimurSibgatullin.GenericList.List;
import itis.grp403.TimurSibgatullin.Set;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.NoSuchElementException;

public class HashMapFuncFunc<K,V> implements HashMapInterfacеFunc<K,V> {
    public HashMapFuncFunc() {
        this.array = new Node[capacity];
    }

    @Override
    public Iterator<Entry<K, V>> iterator() {
        return new HashMapIterator();
    }

    class HashMapIterator implements Iterator<Entry<K,V>> {
        private int currentIndex = 0;
        private Node currentNode = null;
        private int step = 0;

        public boolean hasNext() {
            return  (step < size);
        }

        public Entry<K,V> next() {
            if (!hasNext()) {
                throw new NoSuchElementException();
            }
            for (int i = currentIndex; i < array.length; i++) {
                if (array[i] != null) {
                    if (currentNode == null) {
                        currentNode = array[i];
                        step++;
                        return currentNode.getValue();
                    } else {
                        if (currentNode.next != null) {
                            currentNode = currentNode.next;
                            step++;
                            return currentNode.getValue();
                        } else {
                            currentNode = null;
                        }
                    }
                }
                currentIndex++;
            }
            step++;
            return null;
        }
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

        @Override
        public String toString() {
            StringBuilder sb = new StringBuilder();
            return sb.append(key).append(" ").append(value).toString();
        }
    }

    private int capacity = 16;
    private int size;
    private class Node<K,V> {
        public Node(K key, V value) {
            this.value = new EntryImpl<K,V>(key, value);
            this.next = null;
        }

        public Entry<K,V> getValue() {
            return value;
        }

        Entry<K,V> value;
        Node<K,V> next;
    }
    private Node<K,V>[] array;

    public HashMapFuncFunc(Node[] array) {
        this.array = new Node[capacity];
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
            while(current != null) {
                if (current.value.getKey().equals(key)) {
                    current.value.setValue(value);
                    return;
                }
                if (current.next == null) break;
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
        Set<K> temp = new Set<>();
        if (array != null) {
            for (int i = 0; i < array.length; i++) {
                Node<K, V> current = array[i];
                while (current != null) {
                    temp.add(current.value.getKey());
                    current = current.next;
                }
            }
        }
        return temp;
    }

    @Override
    public List<V> values() {
        List<V> temp = new List<>();
        if (array != null) {
            for (int i = 0; i < array.length; i++) {
                Node<K, V> current = array[i];
                while (current != null) {
                    temp.add(current.value.getValue());
                    current = current.next;
                }
            }
        }
        return temp;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean containsKey(K key) {
        return get(key) != null;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public boolean containsValue(V value) {
        if (array != null) {
            for (int i = 0; i < array.length; i++) {
                Node<K, V> current = array[i];
                while (current != null) {
                    if (value.equals(current.value.getValue())) {
                        return true;
                    }
                    current = current.next;
                }
            }
        }
        return false;
    }

    @Override
    public V remove(K key) {
        int index = Math.abs(key.hashCode()) % capacity;
        if (array[index] == null) {
            return null;
        }
        Node<K, V> current = array[index];
        Node<K, V> last = array[index];
        if (current.value.getKey().equals(key)) {
            array[index] = current.next;
            size--;
            return current.value.getValue();
        }
        current = current.next;
        while(current != null) {
            if (current.value.getKey().equals(key)) {
                last.next = current.next;
                size--;
                return current.value.getValue();
            }
            current = current.next;
        }
        return null;
    }

    public <R> List<R> map(Function<T, R> function) {
        List<Object> set = new List<>();
        for(int i = 0; i < size; ++i) {
            set.add(function.apply((T)values[i]));
        }
        return set;
    }

    @Override
    public void clear() {
        this.array = new Node[capacity];
        this.size = 0;
    }
}
