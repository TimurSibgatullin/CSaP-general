package itis.grp403.TimurSibgatullin;


public class Main {
    public static void main(String[] args) {
//        todo
//         1. Описать интерфейс ITree (left(), right(), int value()
//         2. Описать абстрактный класс BinaryTree
//            бинарное дерево в котором значение левого потомка <= узла
//           значение правого потомка > значению узла
//            абстрактный метод traversalTree()
//            метод ввода дерева через аргумент-массив целых чисел
//         3. реализовать три класса
//                - обход слева
//            - обход справа
//            - центральный обход
        LeftBypass leftBypass = new LeftBypass(new int[] {7, 6, 4, 1, 5, 9, 8, 10});
        leftBypass.traversal();
        CentralBypass centralBypass = new CentralBypass(new int[] {7, 6, 4, 1, 5, 9, 8, 10});
        centralBypass.traversal();
        RightBypass rightBypass = new RightBypass(new int[] {7, 6, 4, 1, 5, 9, 8, 10});
        rightBypass.traversal();
    }
}