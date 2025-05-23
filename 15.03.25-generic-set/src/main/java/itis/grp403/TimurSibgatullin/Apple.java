package itis.grp403.TimurSibgatullin;

public class Apple implements CanCompare {

    private String color;
    private int weight;
    private String kind;
    private int price;

    public Apple(String color, int weight, String kind, int price) {
        this.color = color;
        this.weight = weight;
        this.kind = kind;
        this.price = price;
    }

    @Override
    public int hashCode() {
        int h = super.hashCode();
        for (int i = 0; i < kind.length(); ++i) {
            h = h ^ kind.charAt(i);
        }
        h = h * weight * 17;
        return h;
    }


    @Override
    public int compare(CanCompare other) {
        return this.price - ((Apple)other).price;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null || obj.getClass() != this.getClass()) {
            return false;
        }
//        if (obj == null) return false;
//        if (!obj.getClass().equals(this.getClass())) return false;
//        if  (this == obj) return true;
        Apple apple = (Apple) obj;
        if (this.kind.equals(apple.getKind())) {
            return true;
        }
        return false;
    }

    public int getPrice() {
        return price;
    }

    public String getKind() {
        return kind;
    }

    public int getWeight() {
        return weight;
    }

    public String getColor() {
        return color;
    }

    @Override
    public String toString() {
        return color + " " + weight + " " + kind + " " + price;
    }
}