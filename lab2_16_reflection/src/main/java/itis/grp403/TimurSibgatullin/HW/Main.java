package itis.grp403.TimurSibgatullin.HW;

import java.util.Date;

public class Main {
    public static void main(String[] args) {
        JSONMapper mapper = new JSONMapper();

        Student student = new Student(
                "Поттер",
                "Гарри",
                "Джеймсович",
                "11-гриффиндор",
                12,
                new Date()
        );

        try {
            System.out.println(mapper.toJson(student));
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}