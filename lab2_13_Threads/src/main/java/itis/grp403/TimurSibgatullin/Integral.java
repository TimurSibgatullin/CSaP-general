package itis.grp403.TimurSibgatullin;

import java.lang.constant.Constable;
import java.util.function.Consumer;

public class Integral implements Consumer<Double> {
    private static int N;
    private volatile double integral = 0;

    public static void main(String[] args) throws InterruptedException {
        int countProc = Runtime.getRuntime().availableProcessors();
        int totalN = 1000;
        double a = 1.0;
        double b = 3.0;

        // последовательно
        long start = System.nanoTime();
        double seqResult = partSum(a, b, totalN);
        long end = System.nanoTime();
        System.out.println("Sequential duration " + (end - start));
        System.out.println(seqResult);

        // параллельно
        Integral integralObj = new Integral();
        Thread[] thread = new Thread[countProc];
        double h = (b - a) / countProc;
        N = totalN / countProc;

        start = System.nanoTime();
        for (int i = 0; i < countProc; i++) {
            double startX = a + i * h;
            double endX = a + (i + 1) * h;
            thread[i] = new Thread(new PartSumCalculate(startX, endX, integralObj));
            thread[i].start();
        }
        for (Thread t : thread) {
            t.join();
        }
        end = System.nanoTime();
        System.out.println("Parallel duration " + (end - start));
        System.out.println(integralObj.integral);
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
