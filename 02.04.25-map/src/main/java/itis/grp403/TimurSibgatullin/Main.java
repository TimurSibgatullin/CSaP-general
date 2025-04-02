package itis.grp403.TimurSibgatullin;


import itis.grp403.TimurSibgatullin.hashMap.HashMap;
import itis.grp403.TimurSibgatullin.hashMap.HashMapInterface;

public class Main {
    public static void main(String[] args) {
        HashMapInterface<Integer, String> map = new HashMap<>();
        map.put(1, "Hi");
        map.put(2, "grupp");
        map.put(3, "2");
        map.put(3, "3");

        System.out.println(map.get(1));
        System.out.println(map.get(2));
        System.out.println(map.get(3));
        System.out.println(map.get(4));
    }
}