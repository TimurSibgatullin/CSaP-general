package itis.grp403.TimurSibgatullin.callbacks;

public class Main implements Callback {
    public void work() {
        Thread2 thread2 = new Thread2(this);
        new Thread(thread2).start();
        while (true) {
            System.out.println("Work");
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
    public void call() {
        System.out.println("File read completed");
    }
}
