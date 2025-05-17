package itis.grp403.TimurSibgatullin;

public class Main {
    public static void main(String[] args) {
        Student student = new Student();
        student.setName("Artem");
        student.setLastName("Kuzmin");
        student.setFatherName("Ruslanovich");
        student.setGroup("11-403");
        student.setId(14);

        DBUtils.appendObject(student);

        Student student2 = new Student();
        student2.setName("Юлиан");
        student2.setLastName("Семенов");
        student2.setFatherName("Цезаревич");
        student2.setGroup("11-403");
        student2.setId(42);

        DBUtils.appendObject(student2);
        DBUtils.editStudent(student);

        DBUtils.readAll().forEach(s -> {
            System.out.println(s.getId() + " " +  s.getName());
        });
    }
}