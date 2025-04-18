package itis.grp403.TimurSibgatullin;

import java.util.Iterator;
import java.util.List;

//public class Main {
//    public static void main(String[] args) {
//        List<String> myFlowers = List.of("роза", "астра", "ромашка");
//        Garden garden = new Garden(myFlowers);
//
//        System.out.println("Садовник 1:");
//        Iterator<String> g1 = garden.iterator(GardenerType.FIRST);
//        while (g1.hasNext()) {
//            System.out.println(g1.next());
//        }
//
//        System.out.println("\nСадовник 2:");
//        Iterator<String> g2 = garden.iterator(GardenerType.SECOND);
//        while (g2.hasNext()) {
//            System.out.println(g2.next());
//        }
//
//        Iterator<String> g3 = garden.iterator();
//        while (g3.hasNext()) {
//            System.out.println(g3.next());
//        }
//    }
//}

public class Main {
    public static void main(String[] args) {
//        Menu menu2 = new Menu();
//
////        for(String n: menu2) {
////            System.out.println(n);
////        }
//        Iterator<String> iterator = menu2.iterator();
//        System.out.println(iterator.next());
//        System.out.println(iterator.next());
//        System.out.println(iterator.next());
//        System.out.println(iterator.next());

        test test = new test(GardenerType.FIRST, "роза", "астра", "ромашка");
        for(String n: test) {
            System.out.println(n);
        }
        test.setGardenWorker(GardenerType.SECOND);
        for(String n: test) {
            System.out.println(n);
        }
    }
}