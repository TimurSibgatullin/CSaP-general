package itis.grp403.TimurSibgatullin;

public class Main {
    public static void main(String[] args) {
        DBUtils.open();

        Student student = new Student();
        student.setName("рполрор");
        student.setLastName("Семенов");
        student.setFatherName("Цезаревич");
        student.setGroup("11-403");
        student.setId(45);
        DBUtils.appendStudent(student);

        DBUtils.readAll().forEach(s -> {
            System.out.println(s.getId() + " " + s.getName() + " " + s.getLastName());
        });
        DBUtils.toHTML();

        DBUtils.close();
    }
}