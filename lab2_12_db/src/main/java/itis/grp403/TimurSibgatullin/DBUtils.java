package itis.grp403.TimurSibgatullin;

import java.io.*;
import java.net.Socket;
import java.util.*;

public class DBUtils {
    public static final String TABLE = "lab2_12_db/src/main/resources/student.tbl";
    private static Set<Index> indexSet = new TreeSet<>();

    public static void appendStudent(Student student) {
        Index index = new Index();

        index.setId(student.getId());
        if (indexSet.contains(index)) {
            System.out.println("Студент с этим id уже существует\n---------------------------------");
        } else {
            appendObject(student);
            System.out.println("Сделано\n---------------------------------");
        }
    }

    private static void appendObject(Student student) {
        // сериализация student
        byte[] studentData = null;

        try (ByteArrayOutputStream bos = new ByteArrayOutputStream();
             ObjectOutputStream oos = new ObjectOutputStream(bos)) {
            oos.writeObject(student);
            studentData = bos.toByteArray();

        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        File file = new File(TABLE);
        Index index = new Index();
        index.setId(student.getId());
        if (indexSet.contains(index)) {
            delete(student.getId());
            indexSet.remove(index);
        }
        try (FileOutputStream fos = new FileOutputStream(file, true);
             DataOutputStream dos = new DataOutputStream(fos)) {
            index.setPosition(fos.getChannel().position());
            indexSet.add(index);
            dos.writeInt(student.getId());
            dos.writeByte(1);
            dos.writeInt(studentData.length);
            dos.write(studentData);
            dos.flush();
        } catch (IOException e) {
            throw new RuntimeException("Не удалось записать данные");
        }
    }

    public static List<Student> readAll() {
        List<Student> result = new ArrayList<>();
        File file = new File(TABLE);
        if (!file.exists()) {
            return null;
        }
        try (DataInputStream dis = new DataInputStream(
                new FileInputStream(file))) {
            while (true) {
                int id = dis.readInt();
                byte flag = dis.readByte();
                int size = dis.readInt();
                byte[] data = new byte[size];
                dis.read(data);
                if (flag == 1) {
                    try (ObjectInputStream ois = new ObjectInputStream(
                            new ByteArrayInputStream(data)
                    )) {
                        Student student = (Student) ois.readObject();
                        result.add(student);
                    }
                }
            }
        } catch (EOFException e) {}
        catch (IOException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        return result;
    }

    public static long findPosition(int searchId) {
        List<Index> sortedList = new ArrayList<>(indexSet);
        int l = 0, r = sortedList.size() - 1;
        while (l <= r) {
            int m = l + (r - l) / 2;
            Index cur = sortedList.get(m);
            if (cur.getId() == searchId) {
                return cur.getPosition();
            } else if (cur.getId() < searchId) {
                l = m + 1;
            } else {
                r = m - 1;
            }
        }
        return -1;
    }

    public static void delete(int id) {
        long position = findPosition(id);
        if (position == -1) {
            System.out.println("Студент с этим id не найден\n--------------------------------");
            return;
        }
        Index index = new Index();
        index.setId(id);
        indexSet.remove(index);
        // Меняем 1 байт в файле
        File file = new File(TABLE);
        try (RandomAccessFile raf = new RandomAccessFile(file, "rw")) {
            raf.seek(position);
            raf.readInt();
            raf.write(0);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static Student get(int id) {
        long position = findPosition(id);
        if (position == -1) {
            System.out.print("Студент с этим id не найден: ");
            return null;
        }
        File file = new File(TABLE);
        try (RandomAccessFile raf = new RandomAccessFile(file, "rw")) {
            raf.seek(position);
            raf.readInt();
            raf.readByte();
            int size = raf.readInt();
            byte[] buffer = new byte[size];
            raf.readFully(buffer);
            try (ObjectInputStream ois = new ObjectInputStream(
                    new ByteArrayInputStream(buffer)
            )) {
                Student student = (Student) ois.readObject();
                return student;
            }
        } catch (IOException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    public static void toHTML() {
        try (FileOutputStream fos = new FileOutputStream("lab2_12_db/src/main/resources/students.html");
                PrintWriter writer = new PrintWriter(fos)) {
            writer.write("<!DOCTYPE html>\n" +
                    "<html>\n" +
                    "<head>\n" +
                    "    <meta charset=\"utf-8\"/>\n" +
                    "</head>\n" +
                    "<body>\n" +
                    "<h1>Студенты</h1>\n" +
                    "<table>\n" +
                    "    <tr>\n" +
                    "        <th>id</th><th>Фамилия</th><th>Имя</th><th>Отчество</th><th>Группа</th>\n" +
                    "    </tr>\n");
            for (Index idx : indexSet) {
                Student student = get(idx.getId());
                writer.write("    <tr>\n" +
                        "        <td>"+ idx.getId() +"</td><td>" + student.getLastName() + "</td><td>" + student.getName() +
                        "</td><td>" + student.getFatherName() + "</td><td>" + student.getGroup() + "</td>\n" +
                        "    </tr>\n");
            }
            writer.write("</table>\n" +
                    "</body>\n" +
                    "</html>");
            writer.flush();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static void editStudent(Student student) {
        Index index = new Index();
        index.setId(student.getId());
        if (indexSet.contains(index)) {
            appendObject(student);
            System.out.println("Сделано\n---------------------------------");
        } else {
            System.out.println("Студент с данным id отсутствует\n---------------------------------");
        }
    }

    public static void open() {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream("lab2_12_db/src/main/resources/student.idx"))) {
            indexSet = (TreeSet<Index>) ois.readObject();
        } catch (FileNotFoundException e) {
        } catch (IOException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        System.out.println("База данных инициализирована\n---------------------------------");
    }

    public static void close() {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("lab2_12_db/src/main/resources/student.idx"))){
            oos.writeObject(indexSet);
            oos.flush();
            System.out.println("База данных сохранена\n---------------------------------");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
