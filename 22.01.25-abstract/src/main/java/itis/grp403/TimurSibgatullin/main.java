package itis.grp403.TimurSibgatullin;

public class main {
    public static void main(String[] args) {
        CalculateIntegralLeft l = new CalculateIntegralLeft(0, Math.PI, new Sin());
        System.out.println("По левому краю: " + l.get());
        CalculateIntegralRight r = new CalculateIntegralRight(0, Math.PI, new Sin());
        System.out.println("По правому краю: " + r.get());
        CalculateIntegralCenter c = new CalculateIntegralCenter(0, Math.PI, new Sin());
        System.out.println("По центру: " + c.get());
        CalculateIntegralTrapezoid tr = new CalculateIntegralTrapezoid(0, Math.PI, new Sin());
        System.out.println("Трапецией: " + tr.get());

    }
}
