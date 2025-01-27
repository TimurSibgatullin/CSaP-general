package itis.grp403.TimurSibgatullin;

public class CalculateIntegralRight extends AbstractCalculateIntegral {
    private static final int N = 1000;
    public CalculateIntegralRight(double a, double b, Function function) {
        super(a, b, function);
    }
    public double get() {
        double sum = 0;
        double h = (b - a) / N;
        for (int i = N; i > 0; i--) {
            sum += h * function.calculate(b - h * i);
        }
        return sum;
    }
}
