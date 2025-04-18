package map_vals_to_parametrized_list;


import itis.grp403.TimurSibgatullin.GenericList.List;
import itis.grp403.TimurSibgatullin.Set;


public interface HashMapInterfacеFunc<K, V> extends Iterable<HashMapFuncFunc.Entry<K, V>> {
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
    public <R> List<R> map(Function<T, R> function);

    interface Entry<K, V> {
        void setKey(K key);
        void setValue(V value);
        K getKey();
        V getValue();
    }
}
