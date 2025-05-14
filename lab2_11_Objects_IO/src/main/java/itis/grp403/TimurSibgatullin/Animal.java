package itis.grp403.TimurSibgatullin;

import java.io.Serializable;

public class Animal implements Serializable {
    private String name;
    private Integer age;
    private AnimalType type;
    private AnimalClass category;
    public static long version = 0;
    public Animal() {
    }

    @Override
    public String toString() {
        return "Animal{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", type=" + type +
                ", category=" + category +
                '}';
    }

    public Animal(String name, Integer age, AnimalType type, AnimalClass category) {
        this.name = name;
        this.age = age;
        this.type = type;
        this.category = category;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public AnimalType getType() {
        return type;
    }

    public void setType(AnimalType type) {
        this.type = type;
    }

    public AnimalClass getCategory() {
        return category;
    }

    public void setCategory(AnimalClass category) {
        this.category = category;
    }
}
