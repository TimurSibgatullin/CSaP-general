package itis.grp403.TimurSibgatullin;

public class Main {
    public static void main(String[] args) {
        System.out.println("создаём массив чисел от 0 до 29");
        Set<Integer> set = new Set<>();
        for (int i = 0; i < 30; i++) {
            set.add(i);
        }
        System.out.println(set+ "\n");

        System.out.println("Выводим размер");
        System.out.println(set.size() + "\n");

        System.out.println("содержит 99?");
        System.out.println(set.contains(99)+ "\n");

        System.out.println("добавляем существующий элемент 5");
        set.add(5);
        System.out.println(set + "\n");

//        Object[] temp = set.getAll();
//        for (int i = 0; i < (temp.length); i++) {
//            System.out.println(temp[i]);
//        }
        System.out.println("получаем массив T");
        Integer a[] = set.getAll(new Integer[0]);
        for (Integer i : a) {
            System.out.println(i);
        }
        System.out.println("удаляем элементы");
        System.out.println(set.remove(5));
        System.out.println(set.remove(6));
        System.out.println(set+ "\n");

        System.out.println("создаём множество объектов другого типа");
        Set<String> set2 = new Set<>();
        set2.add("5");
        set2.add("6");
        set2.add("1");
        System.out.println("содержит '5' ?");
        System.out.println(set2.contains("5"));

    }
}