package itis.grp403.TimurSibgatullin.hashMap;


import itis.grp403.TimurSibgatullin.GenericList.List;
import itis.grp403.TimurSibgatullin.Set;

import java.util.Iterator;


public interface HashMapInterface<K, V> extends Iterable<HashMap.Entry<K, V>> {
    void put(K key, V value);
    V get (K key);
    Set<K> keySet();
    List<V> values();
    int size();
    boolean containsKey(K key);
    boolean isEmpty();
    boolean containsValue(V value);
    V remove(K key);
    void clear();

    interface Entry<K, V> {
        void setKey(K key);
        void setValue(V value);
        K getKey();
        V getValue();
    }
}
