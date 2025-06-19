package itis.grp403.TimurSibgatullin.HW;

import java.lang.reflect.InvocationTargetException;
import java.util.Date;

public class Main {
    public static void main(String[] args) {
        Student s = new Student("Ivanov", "Ivan", "Ivanovich", "11-403", 20, new Date());
        JSONMapper mapper = new JSONMapper();

        String json = null;
        try {
            json = mapper.toJson(s);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        System.out.println(json);

        Student parsed = null;
        try {
            parsed = (Student) mapper.parseJson(json, Student.class);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        try {
            System.out.println(mapper.toJson(parsed));
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}