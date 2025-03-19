package itis.grp403.TimurSibgatullin;


public class Main {
    public static void main(String[] args) {
        List2Direction<Integer> list1 = new List2Direction<Integer>();
        list1.add(1);
        list1.add(2);
        list1.add(3);
        list1.add(4);
        System.out.println(list1);
        System.out.println(list1.get(2));
        System.out.println(list1.size());
        System.out.println(list1.remove(1));
        System.out.println(list1);
    }
}
