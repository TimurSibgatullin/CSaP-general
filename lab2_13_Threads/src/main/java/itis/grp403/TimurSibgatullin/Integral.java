package itis.grp403.TimurSibgatullin;

import java.lang.constant.Constable;
import java.util.function.Consumer;

public class Integral implements Consumer<Double> {
    private static int N;
    private volatile double integral = 0;

    public static void main(String[] args) throws InterruptedException {
        // [1, 3]
        Integral integralObj1 = new Integral();
        Integral integralObj2 = new Integral();
        int countProc = Runtime.getRuntime().availableProcessors();
        N = 1000 / countProc; // количество столбиков для суммирования задачей
        double h = (3 - 1.0) / countProc; //
        Thread[] thread = new Thread[countProc];
        long start = System.nanoTime();
        for (int i = 0; i < countProc; i++) {
            thread[i] = new Thread(new PartSumCalculate(1 + i * h, 1 + (i + 1) * h, integralObj1));
            thread[i].start();
            thread[i].join();
        }
        long end = System.nanoTime();
        System.out.println("Sequential duration " + (end - start));
        System.out.println(integralObj1.integral);

        thread = new Thread[countProc];
        start = System.nanoTime();
        for (int i = 0; i < countProc; i++) {
            thread[i] = new Thread(new PartSumCalculate(1 + i * h, 1 + (i + 1) * h, integralObj2));
            thread[i].start();
        }
        for (int i = 0; i < countProc; i++) {
            thread[i].join();
        }
        end = System.nanoTime();
        System.out.println("Parallel duration " + (end - start));
        System.out.println(integralObj2.integral);
    }

    public static double func(double x) {
        return Math.exp(- x * x / 2) * Math.sin(x);
    }

    public static double partSum(double a, double b, int N) {
        double h = (b - a) / N;
        double sum = 0;
        for (int i = 0; i < N; ++i) {
            sum += h * (func(a + h * i) + func(a + h * (i + 1))) / 2;
        }
        return sum;
    }

    @Override
    public synchronized void accept(Double d) {
        integral += d;
    }

    static class PartSumCalculate implements Runnable {
        private double a;
        private double b;
        private Consumer<Double> consumer;

        public PartSumCalculate(double a, double b, Consumer<Double> consumer) {
            this.a = a;
            this.b = b;
            this.consumer = consumer;
        }

        public void run() {
            double result = partSum(a, b, N);
            consumer.accept(result);
        }
    }
}
