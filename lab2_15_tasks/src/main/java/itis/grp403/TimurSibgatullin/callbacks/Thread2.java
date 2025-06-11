package itis.grp403.TimurSibgatullin.callbacks;


public class Thread2 implements Runnable{
    private Callback callback;

    public Thread2(Callback callback) {
        this.callback = callback;
    }

    @Override
    public void run() {
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        callback.call();
    }
}
