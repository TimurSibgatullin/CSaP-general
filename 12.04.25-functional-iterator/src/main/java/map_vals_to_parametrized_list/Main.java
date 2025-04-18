package map_vals_to_parametrized_list;

import java.util.Iterator;

public class Main {
    public static void main(String[] args) {
        HashMapInterfacеFunc<Integer, String> map = new HashMapFuncFunc<>();
        map.put(1, "Hello");
        map.put(1, "Hi");
        map.put(2, "my");
        map.put(3, "name");
        map.put(4, "Timur");
        map.put(4, "XÆA-12");

        Iterator<HashMapFuncFunc.Entry<Integer, String>> iterator = map.iterator();

        for (HashMapFuncFunc.Entry<Integer, String> val: map) {
            System.out.println(val);
        }

//        System.out.println(map.get(1) + " " + map.get(2) + " " + map.get(3) + " " + map.get(4) + "\n");
//
//        System.out.println(map.keySet());
//        System.out.println(map.values());
//        System.out.println(map.isEmpty() + "\n");
//
//        System.out.println(map.containsKey(1));
//        System.out.println(map.containsValue("Timur") + "\n");
//
//        System.out.println(map.remove(1));
//        System.out.println(map.get(1));
//        System.out.println(map.keySet());
//        System.out.println(map.values() + "\n");
//
//        map.clear();
//        System.out.println(map.isEmpty());
    }
}