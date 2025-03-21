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

        long time2 = System.nanoTime();
        for (int i = 0; i < 10000; i++) {
            list1.remove(randRange(list1.size()));
        }
        time2 = System.nanoTime() - time2;

        long time3 = System.nanoTime();
        List<Integer> list2 = new List<Integer>();

        for (int i = 0; i < 100000; i++) {
            Random rnd = new Random();
            list2.add(rnd.nextInt());
        }
        time3 = System.nanoTime() - time3;

        long time4 = System.nanoTime();
        for (int i = 0; i < 10000; i++) {
            list2.remove(randRange(list2.size()));
        }
        time4 = System.nanoTime() - time4;

        System.out.println("Добавление в двусвязный список " + time);
        System.out.println("Удаление из двусвязного списка " + time2);
        System.out.println("Добавление в список " + time3);
        System.out.println("Удаление из списка " + time4);

        System.out.println("Добавление -- двусвязный/обычный = " + (double) time / time3);
        System.out.println("Удаление -- двусвязный/обычный = " + (double) time2 / time4);


    }

    public static int randRange(int length) {
        return (int) (Math.random() * length);
    }
}