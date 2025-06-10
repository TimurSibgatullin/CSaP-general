package itis.grp403.TimurSibgatullin.Player;


import java.util.Scanner;

public class Console {
    private PlayList playlist;
    private Track currentTrack;

    public Console() {
        this.playlist = new PlayList();
        playlist.load();
    }
    public void showMenu() {
        System.out.println("Проигрывается " + currentTrack);
        System.out.println("1 Показать все треки\n" +
                "   2 Найти трек по названию\n" +
                "   3 Найти трек по автору\n" +
                "   4 Найти по номеру\n" +
                "   5 Проиграть трек по номеру\n" +
                "   6 Остановить проигрывание\n" +
                "   7 Следующий трек\n" +
                "   8 Предыдущий трек\n" +
                "   9 Добавить трек\n" +
                "   10 Выход");
    }

    public void startCommand() {
        Scanner sc = new Scanner(System.in);
        boolean flag = true;
        while (flag) {
            showMenu();
            System.out.println("Введите команду:");
            int command = sc.nextInt();
            flag = commandHandler(command);

        }
    }

    public boolean commandHandler(int command) {
        switch (command) {
            case 10:
                return false;
            case 1:
                playlist.showAll();
                break;
            case 5:


        }
        return true;

    }
}