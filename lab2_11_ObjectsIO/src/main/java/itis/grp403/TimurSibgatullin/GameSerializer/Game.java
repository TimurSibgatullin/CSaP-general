package itis.grp403.TimurSibgatullin.GameSerializer;

import java.io.Serializable;
import java.util.Arrays;
import java.util.Scanner;

public class Game implements Serializable {
    private int x;
    private int y;
    private int real_x;
    private int real_y;
    private int counter;
    private boolean flag;
    private boolean flag2;
    private int[][] collision;
    private int[][] screen;

    public void runGame() {
        String RECTANGLE = "\u2588";
        String input = "";
        while (true) {
            System.out.print("\033[H\033[J");
            if ((input.equals("q")) | (input.equals("Q"))) {
                GameStart.saveGame();
                System.out.println("Игра сохранена");
            } else if ((input.equals("e")) | (input.equals("E"))) {
                GameStart.loadGame();
                System.out.println("Сохранение загружено");
            } else if ((input.equals("w")) | (input.equals("W"))) {
                x -= 1;
                counter += 1;
            } else if ((input.equals("s")) | (input.equals("S"))) {
                x += 1;
                counter += 1;
            } else if ((input.equals("a")) | (input.equals("A"))) {
                y -= 1;
                counter += 1;
            } else if ((input.equals("d")) | (input.equals("D"))) {
                y += 1;
                counter += 1;
            }
            if (collision[x][y] == 1) {
                screen[real_x][real_y] = 1;
                screen[x][y] = 4;
                real_x = x;
                real_y = y;
            } else if (collision[x][y] == 0) {
                screen[x][y] = 2;
                x = real_x;
                y = real_y;
                flag2 = true;
            } else {
                screen[real_x][real_y] = 1;
                screen[x][y] = 4;
                real_x = x;
                real_y = y;
                flag = true;
            }
            for (int i = 0; i < screen.length; i++) {
                for (int j = 0; j < screen[0].length; j++) {
                    if (screen[i][j] == 0) {
                        System.out.printf("\u001B[38;2;%d;%d;%dm", 0, 0, 0);
                        System.out.printf(RECTANGLE + RECTANGLE);
                    } else if (screen[i][j] == 2) {
                        System.out.printf("\u001B[38;2;%d;%d;%dm", 75, 75, 75);
                        System.out.printf(RECTANGLE + RECTANGLE);
                    } else if (screen[i][j] == 1) {
                        System.out.printf("\u001B[38;2;%d;%d;%dm", 150, 150, 150);
                        System.out.printf(RECTANGLE + RECTANGLE);
                    } else if (screen[i][j] == 4) {
                        System.out.printf("\u001B[38;2;%d;%d;%dm", 200, 200, 0);
                        System.out.printf(RECTANGLE + RECTANGLE);
                    } else if (screen[i][j] == 3) {
                        System.out.printf("\u001B[38;2;%d;%d;%dm", 200, 0, 0);
                        System.out.printf(RECTANGLE + RECTANGLE);
                    }
                }
                System.out.printf("\n");
            }
            System.out.print("\u001B[0m");
            if (flag) {
                System.out.println("Вы прошли лабириринт за " + counter + " ходa(ов)!");
                break;
            }
            if (flag2) {
                System.out.println("ВЫ УПЁРЛИСЬ В СТЕНУ!");
                flag2 = false;
            }
            System.out.println("Сделайте новый ход (wasd), либо сохраните/загрузите игру (q/e) и нажмите enter: ");
            Scanner scanner = new Scanner(System.in);
            input = scanner.nextLine();
        }
    }

    public void setAll(int x, int y, int real_x, int real_y, int counter, boolean flag, boolean flag2, int[][] collision, int[][] screen) {
        this.x = x;
        this.y = y;
        this.real_x = real_x;
        this.real_y = real_y;
        this.counter = counter;
        this.flag = flag;
        this.flag2 = flag2;
        this.collision = collision;
        this.screen = screen;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public int getReal_x() {
        return real_x;
    }

    public void setReal_x(int real_x) {
        this.real_x = real_x;
    }

    public int getReal_y() {
        return real_y;
    }

    public void setReal_y(int real_y) {
        this.real_y = real_y;
    }

    public int getCounter() {
        return counter;
    }

    public void setCounter(int counter) {
        this.counter = counter;
    }

    public boolean isFlag() {
        return flag;
    }

    public void setFlag(boolean flag) {
        this.flag = flag;
    }

    public boolean isFlag2() {
        return flag2;
    }

    public void setFlag2(boolean flag2) {
        this.flag2 = flag2;
    }

    public int[][] getCollision() {
        return collision;
    }

    public void setCollision(int[][] collision) {
        this.collision = collision;
    }

    public int[][] getScreen() {
        return screen;
    }

    public void setScreen(int[][] screen) {
        this.screen = screen;
    }

    public Game() {
    }

    @Override
    public String toString() {
        return "Game{" +
                "x=" + x +
                ", y=" + y +
                ", real_x=" + real_x +
                ", real_y=" + real_y +
                ", counter=" + counter +
                ", flag=" + flag +
                ", flag2=" + flag2 +
                ", collision=" + Arrays.toString(collision) +
                ", screen=" + Arrays.toString(screen) +
                '}';
    }

}
