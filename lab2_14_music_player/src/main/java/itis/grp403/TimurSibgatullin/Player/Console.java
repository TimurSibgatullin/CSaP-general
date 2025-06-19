package itis.grp403.TimurSibgatullin.Player;


import java.util.Optional;
import java.util.Scanner;

public class Console {
    private PlayList playlist;
    private Track currentTrack;
    private SoundPlayer soundPlayer;
    private Thread soundThread;

    public Console() {
        this.playlist = new PlayList();
        playlist.load();
        this.soundPlayer = new SoundPlayer();
        this.soundThread = new Thread();
    }

    public void showMenu() {
        if (currentTrack != null) {
            System.out.println("Проигрывается " + currentTrack);
        }
        System.out.println("   1 Показать все треки\n" +
                "   2 Найти трек по названию\n" +
                "   3 Найти трек по автору\n" +
                "   4 Найти по номеру\n" +
                "   5 Проиграть трек по номеру\n" +
                "   6 Остановить проигрывание\n" +
                "   7 Предыдущий трек\n" +
                "   8 Следующий трек\n" +
                "   9 Добавить трек\n" +
                "   0 Выход");
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
        Scanner sc = new Scanner(System.in);
        switch (command) {
            case 0:
                return false;
            case 1:
                playlist.showAll();
                break;
            case 2:
                System.out.println("Введите название:");
                String name = sc.nextLine();
                playlist.findByName(name);
                break;
            case 3:
                System.out.println("Введите автора:");
                String author = sc.nextLine();
                playlist.findByAuthor(author);
                break;
            case 4:
                System.out.println("Введите номер:");
                Integer numb = sc.nextInt();
                Optional<Track> temp1 = playlist.findByNumber(numb);
                temp1.ifPresent(track -> System.out.println(track.getNumber() + ": " +
                        track.getName() + ", " +
                        track.getAuthor()));
                break;
            case 5:
                System.out.println("Введите номер:");
                Integer numb2 = sc.nextInt();
                Optional<Track> temp2 = playlist.findByNumber(numb2);
                soundPlayer.stop();
                temp2.ifPresent(track -> currentTrack = track);
                soundThread = new Thread(() ->
                        temp2.ifPresent(track -> {
                            soundPlayer.play(track);
                            try {
                                soundPlayer.currentThread.join();
                            } catch (InterruptedException e) {
                                throw new RuntimeException(e);
                            }
                            currentTrack = null;}
                        ));
                soundThread.start();
                break;
            case 6:
                soundPlayer.stop();
                try {
                    soundThread.join();
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                break;
            case 7:
                Track track2 = playlist.findByNumber(currentTrack.getNumber() - 1).orElse(currentTrack);
                soundPlayer.stop();
                try {
                    soundThread.join();
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                currentTrack = track2;
                soundThread = new Thread(()-> {
                            soundPlayer.play(track2);
                            try {
                                soundPlayer.currentThread.join();
                            } catch (InterruptedException e) {
                                throw new RuntimeException(e);
                            }
                            currentTrack = null;
                });
                soundThread.start();
                break;
            case 8:
                track2 = playlist.findByNumber(currentTrack.getNumber()+1).orElse(currentTrack);
                soundPlayer.stop();
                try {
                    soundThread.join();
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                currentTrack = track2;
                soundThread = new Thread(()-> {
                    soundPlayer.play(track2);
                    try {
                        soundPlayer.currentThread.join();
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                    currentTrack = null;
                });
                soundThread.start();
                break;
            case 9:
                System.out.println("Введите имя трека");
                name = sc.nextLine();
                System.out.println("Введите автора трека");
                author = sc.nextLine();
                System.out.println("Введите путь к треку");
                String path = sc.nextLine();
                playlist.add(new Track(name, author, path));
                break;

            default:
                throw new IllegalStateException("Unexpected value: " + command);
        }
        return true;

    }
}