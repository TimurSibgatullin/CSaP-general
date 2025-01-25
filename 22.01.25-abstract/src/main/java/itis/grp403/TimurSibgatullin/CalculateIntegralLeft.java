package itis.grp403.TimurSibgatullin;

public class CalculateIntegralLeft extends AbstractCalculateIntegral {
    private static final int N = 1000;
    public CalculateIntegralLeft(double a, double b, Function function) {
        super(a, b, function);
    }
    public double get() {
        double sum = 0;
        double h = (b - a) / N;
        for (int i = 0; i < N; i++) {
            sum += h * function.calculate(a + h * i);
        }
        return sum;
    }
}
