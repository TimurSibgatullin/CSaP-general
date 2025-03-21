package itis.grp403.TimurSibgatullin;

public class AppleTest {
    public static void main(String[] arg) {
        Set<Apple> set1 = new Set<>();
        set1.add(new Apple("Красный", 55, "Антоновка", 120));
        set1.add(new Apple("Зеленый", 60, "Анто+новка", 100));
        set1.add(new Apple("Желтый", 80, "Голден", 130));
        set1.add(new Apple("Алый", 75, "Гала", 150));
        set1.add(new Apple("Сливовый", 70, "Спартан", 90));
        set1.add(new Apple("Красно-белый", 65, "Башкирская красавица", 110));
        System.out.println(set1);
    }
}
