package itis.grp403.TimurSibgatullin;
import itis.grp403.TimurSibgatullin.GenericList.List;

import java.util.Random;
public class Main {
    public static void main(String[] args) {
        long time = System.nanoTime();
        List2Direction<Integer> list1 = new List2Direction<Integer>();
        for (int i = 0; i < 100000; i++) {
            Random rnd = new Random();
            list1.add(rnd.nextInt());
        }
        time = System.nanoTime() - time;
        System.out.println(time);

        time = System.nanoTime();
        for (int i = 0; i < 10000; i++) {
            list1.remove(i);
        }
        time = System.nanoTime() - time;
        System.out.println(time);

        time = System.nanoTime();
        List<Integer> list2 = new List<Integer>();
        for (int i = 0; i < 100000; i++) {
            Random rnd = new Random();
            list2.add(rnd.nextInt());
        }
        time = System.nanoTime() - time;
        System.out.println(time);

        time = System.nanoTime();
        for (int i = 0; i < 10000; i++) {
            list2.remove(i);
        }
        time = System.nanoTime() - time;
        System.out.println(time);
    }
}