package itis.grp403.TimurSibgatullin;

public class Main {
    //todo Экспедиция:
    //10 машин вероятность поломки 60%
    //в машине 2 человека, а мест 5
    //Если машина ломается, то экипаж пересаживается в свободные автомобили
    //экспидиция неудачна, если после очередной поломки не хватает мест
    //1000 км
    //каждые (50) 100 км определяется наличие критической неисправности
    //факт поломки машины в программе отражается выбросом исключения

    public static void main(String[] args) {
        int k = 100;
        int n = 0;
        int chance = 20;
        for (int x = 0; x < 1000; x++) {
            boolean flag = true;
            int cars = 10;
            for (int i = 0; i < (1000 / 100) && flag; i++) {
                try {
                    for (int car = 0; car < cars; car++) {
                        throwTheDice(chance);
                    }
                } catch (CriticalFailure err) {
                    cars -= 1;
                    if (cars <= (2 * 10 / 5)) {
                        flag = false;
                    }
                }
            }
            if (!flag) {
//                System.out.println("Не доехали");
            } else {
//                System.out.println("Доехали, осталось " + cars + " машин");
                n += 1;
            }
        }
        System.out.println(n);
    }

    static private void throwTheDice(int chance) throws CriticalFailure {
        int dice = (int) (Math.random() * 100);
        if (dice < chance) throw new CriticalFailure();
    }
}
