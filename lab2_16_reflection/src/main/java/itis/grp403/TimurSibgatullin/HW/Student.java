package itis.grp403.TimurSibgatullin.HW;

import java.util.Date;

public class Student {
    private String lastName;
    private String firstName;
    private String middleName;
    private String group;
    private Integer age;

    @DateFormat("dd/MM/yyyy")
    private Date entryDate;

    public Student() {
    }

    public Student(String lastName, String firstName, String middleName, String group, Integer age, Date entryDate) {
        this.lastName = lastName;
        this.firstName = firstName;
        this.middleName = middleName;
        this.group = group;
        this.age = age;
        this.entryDate = entryDate;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getMiddleName() {
        return middleName;
    }

    public void setMiddleName(String middleName) {
        this.middleName = middleName;
    }

    public String getGroup() {
        return group;
    }

    public void setGroup(String group) {
        this.group = group;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public Date getEntryDate() {
        return entryDate;
    }

    public void setEntryDate(Date entryDate) {
        this.entryDate = entryDate;
    }
}