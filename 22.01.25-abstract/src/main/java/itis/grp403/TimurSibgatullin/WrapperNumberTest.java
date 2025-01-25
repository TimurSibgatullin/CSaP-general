package itis.grp403.TimurSibgatullin;

public class WrapperNumberTest {
    public static void main(String[] args) {
        Integer i = 10; // упаковка

        Integer a = 10;

        a++;

        System.out.println(a.getClass());

        Integer b = 20;
        int c = a + b; // распаковка

        Integer d = c * 20; // упаковка

        d = func3(d); //1. распаковка при передаче значения аргумента
        //2. упаковка результата функции в класс обертку

        System.out.println(d);
    }

    public static Integer func1(int a) {
        return a + 1; // упаковка
    }
    public static Integer func2(Integer a) {
        return a + 1; // 1. распаковка в int, 2. сложение 3. упаковка
    }
    public static int func3(int a) {
        return a + 1;
    }
}
