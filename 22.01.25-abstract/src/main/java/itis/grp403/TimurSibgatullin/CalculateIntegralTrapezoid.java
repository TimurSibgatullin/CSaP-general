package itis.grp403.TimurSibgatullin;

public class CalculateIntegralTrapezoid extends AbstractCalculateIntegral {
    public CalculateIntegralTrapezoid(double a, double b, Function function) {
        super(a, b, function);
    }
    public double get() {
        return (function.calculate(a) + function.calculate(b)) / (2 * (b - a));
    }
}
