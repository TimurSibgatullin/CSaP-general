package itis.grp403.TimurSibgatullin;

import java.io.*;

public class Main2 {
    public static void main(String[] args) {
        Animal animal1 = new Animal();
        animal1.setName("Alice the fox");
        animal1.setAge(12);
        animal1.setCategory(AnimalClass.МЛЕКОПИТАЮЩЕЕ);
        animal1.setType(AnimalType.ЛИСА);


        try (FileOutputStream fos = new FileOutputStream("fos.obj");
             ObjectOutputStream oos = new ObjectOutputStream(fos)) {
            oos.writeObject(animal1);
            oos.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }

//        for (byte b : savedData) {
//            System.out.println(b);
//        }

        try (FileInputStream fis = new FileInputStream("fos.obj");
             ObjectInputStream ois = new ObjectInputStream(fis)) {
            Animal animal2 = (Animal) ois.readObject();
            System.out.println(animal2);

        } catch (ClassNotFoundException | IOException e) {
            e.printStackTrace();
        }
    }
}