package itis.grp403.TimurSibgatullin;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        DBUtils.open();

        Boolean isRunning = true;
        while (isRunning) {
            System.out.println("Введите опцию и нажмите Enter:\n" +
                    "add - добавление в БД\n" +
                    "get - поиск по ID\n" +
                    "del - удаление по ID\n" +
                    "edit - изменение данных\n" +
                    "html - вывод всех данных в файл students.html\n" +
                    "exit - закончить работу с базой данных\n--------------------------------");
            Scanner sc = new Scanner(System.in);
            switch (sc.nextLine().toLowerCase()) {
                case "add" :
                    System.out.println("Введите id, фамилию, имя, отчество и группу разделённые пробелом");
                    while (true) {
                        String[] temp = sc.nextLine().split(" ");
                        try {
                            Student student1 = new Student(Integer.parseInt(temp[0]), temp[1], temp[2], temp[3], temp[4]);
                            DBUtils.appendStudent(student1);
                            break;
                        } catch (Exception e) {
                            System.out.println("Введите корректные данные");
                        }
                    }
                    break;
                case "get" :
                    System.out.println("Введите id студента");
                    while (true) {
                        try {
                        System.out.println(DBUtils.get(sc.nextInt()));
                        break;
                        } catch (Exception e) {
                            System.out.println("Введите корректные данные");
                        }
                    }
                    System.out.println("---------------------------------");
                    break;
                case "del" :
                    System.out.println("Введите id студента");
                    while (true) {
                        try {
                            DBUtils.delete(sc.nextInt());
                            break;
                        } catch (Exception e) {
                            System.out.println("Введите корректные данные");
                        }
                    }
                    System.out.println("Сделано\n---------------------------------");
                    break;
                case "edit" :
                    System.out.println("Введите id, фамилию, имя, отчество и группу разделённые пробелом");
                    while (true) {
                        String[] temp = sc.nextLine().split(" ");
                        try {
                            Student student2 = new Student(Integer.parseInt(temp[0]), temp[1], temp[2], temp[3], temp[4]);
                            DBUtils.editStudent(student2);
                            break;
                        } catch (Exception e) {
                            System.out.println("Введите корректные данные");
                        }
                    }
                    break;
                case "html" :
                    DBUtils.toHTML();
                    System.out.println("База данных экспортирована\n--------------------------------");
                    break;
                case "exit" :
                    isRunning = false;
                    break;
                default:
                    System.out.println("--------------------------------");
            }
        }        DBUtils.close();
    }
}