package itis.grp403.TimurSibgatullin;

public class CalculateIntegralCenter extends AbstractCalculateIntegral {
    private static final int N = 1000;
    public CalculateIntegralCenter(double a, double b, Function function) {
        super(a, b, function);
    }
    public double get() {
        double sum = 0;
        double h = (b - a) / N;
        for (int i = 0; i < N; i++) {
            sum += h * function.calculate(a + h * (i * 0.5));
        }
        return sum;
    }
}
