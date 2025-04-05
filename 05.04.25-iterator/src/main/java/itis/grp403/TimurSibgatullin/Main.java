package itis.grp403.TimurSibgatullin;

import itis.grp403.TimurSibgatullin.GenericList.List;
import itis.grp403.TimurSibgatullin.GenericList.ListInterface;

import java.util.Iterator;

public class Main {
    public static void main(String[] args) {
        Menu menu2 = new Menu();

//        for(String n: menu2) {
//            System.out.println(n);
//        }
        Iterator<String> iterator = menu2.iterator();
        System.out.println(iterator.next());
        System.out.println(iterator.next());
        System.out.println(iterator.next());
        System.out.println(iterator.next());
    }
}