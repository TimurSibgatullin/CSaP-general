package itis.grp403.TimurSibgatullin.GameSerializer;

import java.io.*;

public class GameStart {
    private static Game game = new Game();
    public static void main(String[] args) {
        int[][] collision = {{0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 1, 0, 1, 0, 1, 1, 1, 0},
                {0, 1, 0, 1, 1, 1, 0, 1, 0},
                {0, 1, 1, 1, 0, 0, 1, 1, 0},
                {0, 0, 1, 0, 0, 1, 1, 0, 0},
                {0, 1, 1, 1, 0, 1, 0, 0, 0},
                {0, 0, 0, 1, 1, 1, 1, 0, 0},
                {0, 0, 1, 1, 0, 0, 1, 1, 0},
                {0, 0, 0, 0, 0, 0, 0, 2, 0}};
        int[][] screen = {{2, 2, 2, 2, 2, 2, 2, 2, 2},
                {2, 4, 0, 0, 0, 0, 0, 0, 2},
                {2, 0, 0, 0, 0, 0, 0, 0, 2},
                {2, 0, 0, 0, 0, 0, 0, 0, 2},
                {2, 0, 0, 0, 0, 0, 0, 0, 2},
                {2, 0, 0, 0, 0, 0, 0, 0, 2},
                {2, 0, 0, 0, 0, 0, 0, 0, 2},
                {2, 0, 0, 0, 0, 0, 0, 0, 2},
                {2, 2, 2, 2, 2, 2, 2, 3, 2}};
        game.setAll(1, 1, 1, 1, 0, false, false, collision, screen);
        game.runGame();
    }

    public static void saveGame() {
        try (FileOutputStream fos = new FileOutputStream("game.save");
             ObjectOutputStream oos = new ObjectOutputStream(fos)) {
            oos.writeObject(game);
            oos.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void loadGame() {
        try (FileInputStream fis = new FileInputStream("game.save");
             ObjectInputStream ois = new ObjectInputStream(fis)) {
            Game game2 = (Game) ois.readObject();
            game.setAll(game2.getX(), game.getY(), game2.getX(), game2.getReal_y(), game2.getCounter(), game2.isFlag(),
                    game2.isFlag2(), game2.getCollision(), game2.getScreen());
        } catch (ClassNotFoundException | IOException e) {
            e.printStackTrace();
        }
    }
}
