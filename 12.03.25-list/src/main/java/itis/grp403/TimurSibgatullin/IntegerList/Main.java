package itis.grp403.TimurSibgatullin.IntegerList;

public class Main {
    public static void main(String[] args) {
        List list1 = new List();
        // добавление элементов в список
        list1.add(1);
        list1.add(3);
        list1.add(2);
        list1.add(0);
        // вывод списка
        System.out.println(list1);
        // сортировка по убыванию
        list1.sort(false);
        System.out.println(list1);
        // сортировка по возрастанию
        list1.sort(true);
        System.out.println(list1);
        // удаление элемента с индексом 1
        System.out.println(list1.remove(1));
        System.out.println(list1);
        // добавление элемента по индексу 1
        list1.add(10, 1);
        System.out.println(list1);
        // элемент по индексу
        System.out.println(list1.get(1));
        // Тест увеличения размера
        List list2 = new List();
        for (int i = 0; i < 100; i++) {
            list2.add(i);
        }
        System.out.println(list2);
        // несуществующий элемент по индексу
        System.out.println(list1.get(9));
    }
}