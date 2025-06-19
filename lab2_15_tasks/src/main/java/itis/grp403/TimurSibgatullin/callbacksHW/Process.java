package itis.grp403.TimurSibgatullin.callbacksHW;

import java.util.ArrayList;
import java.util.List;

public class Process {
    private final int id;
    private final int executionTime;
    private final List<Process> dependencies = new ArrayList<>();
    private final List<Callback> callbacks = new ArrayList<>();
    private boolean completed = false;
    private boolean executing = false;

    public Process(int id, int executionTime) {
        this.id = id;
        this.executionTime = executionTime;
    }

    public void addDependency(Process dependency) {
        dependencies.add(dependency);
        dependency.addCallback(this::executeIfReady);
    }

    public void addCallback(Callback callback) {
        callbacks.add(callback);
    }

    public void execute() {
        if (completed || executing) return;

        for (Process dependency : dependencies) {
            if (!dependency.isCompleted()) {
                return;
            }
        }

        executing = true;

        new Thread(() -> {
            try {
                System.out.println("Процесс " + id + " начинает выполнение.");
                Thread.sleep(executionTime);
                completed = true;
                executing = false;
                System.out.println("Процесс " + id + " завершил выполнение.");

                for (Callback callback : callbacks) {
                    callback.call();
                }

            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                System.err.println("Процесс " + id + " был прерван.");
            }
        }).start();
    }

    public boolean isCompleted() {
        return completed;
    }

    private void executeIfReady() {
        execute();
    }
}