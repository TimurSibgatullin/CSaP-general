package itis.grp403.TimurSibgatullin.Player;

import java.util.Scanner;
public class Console {
    private final PlayList playlist;
    private Track currentTrack;
    private final SoundPlayer soundPlayer;
    private Thread soundThread;
    private final Scanner sc = new Scanner(System.in);

    public Console() {
        this.playlist = new PlayList();
        playlist.load();
        this.soundPlayer = new SoundPlayer();
        this.soundThread = new Thread();
    }

    public void showMenu() {
        if (currentTrack != null) {
            System.out.println("Проигрывается: " + currentTrack);
        }
        System.out.println("""
               1 Показать все треки
               2 Найти трек по названию
               3 Найти трек по автору
               4 Найти по номеру
               5 Проиграть трек по номеру
               6 Остановить проигрывание
               7 Предыдущий трек
               8 Следующий трек
               9 Добавить трек
               0 Выход""");
    }

    public void startCommand() {
        boolean flag = true;
        while (flag) {
            showMenu();
            System.out.println("Введите команду:");
            int command = sc.nextInt();
            sc.nextLine();
            flag = commandHandler(command);
        }
    }

    public boolean commandHandler(int command) {
        switch (command) {
            case 0:
                return false;
            case 1:
                playlist.showAll();
                break;
            case 2:
                System.out.println("Введите название:");
                playlist.findByName(sc.nextLine());
                break;
            case 3:
                System.out.println("Введите автора:");
                playlist.findByAuthor(sc.nextLine());
                break;
            case 4:
                System.out.println("Введите номер:");
                int number = sc.nextInt();
                sc.nextLine();
                playlist.findByNumber(number)
                        .ifPresent(track -> System.out.println(track.getNumber() + ": " + track.getName() + ", " + track.getAuthor()));
                break;
            case 5:
                System.out.println("Введите номер:");
                int numb2 = sc.nextInt();
                sc.nextLine();
                playlist.findByNumber(numb2).ifPresent(this::playTrack);
                break;
            case 6:
                soundPlayer.stop();
                currentTrack = null;
                break;
            case 7:
                if (currentTrack != null) {
                    playlist.findByNumber(currentTrack.getNumber() - 1)
                            .ifPresent(this::playTrack);
                }
                break;
            case 8:
                if (currentTrack != null) {
                    playlist.findByNumber(currentTrack.getNumber() + 1)
                            .ifPresent(this::playTrack);
                }
                break;
            case 9:
                System.out.println("Введите имя трека:");
                String name = sc.nextLine();
                System.out.println("Введите автора трека:");
                String author = sc.nextLine();
                System.out.println("Введите путь к треку:");
                String path = sc.nextLine();
                playlist.add(new Track(name, author, path));
                break;
            default:
                System.out.println("Неизвестная команда");
        }
        return true;
    }

    private void playTrack(Track track) {
        soundPlayer.stop();
        try {
            soundThread.join();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        currentTrack = track;
        soundThread = new Thread(() -> soundPlayer.play(track, this::playNext));
        soundThread.start();
    }

    private void playNext() {
        int nextNumber = currentTrack.getNumber() + 1;
        playlist.findByNumber(nextNumber)
                .ifPresent(this::playTrack);
    }
}