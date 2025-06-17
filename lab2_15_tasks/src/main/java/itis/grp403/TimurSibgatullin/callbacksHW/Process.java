package itis.grp403.TimurSibgatullin.callbacksHW;

import java.util.ArrayList;
import java.util.List;

public class Process {
    private final int id;
    private final int executionTime;
    private final List<Process> dependencies;
    private final List<Callback> callbacks;
    private boolean completed;
    private boolean executing;

    public Process(int id, int executionTime) {
        this.id = id;
        this.executionTime = executionTime;
        this.dependencies = new ArrayList<>();
        this.callbacks = new ArrayList<>();
        this.completed = false;
        this.executing = false;
    }

    public int getId() {
        return id;
    }

    public int getExecutionTime() {
        return executionTime;
    }

    public List<Process> getDependencies() {
        return dependencies;
    }

    public void addDependency(Process process) {
        dependencies.add(process);
    }

    public void addCallback(Callback callback) {
        callbacks.add(callback);
    }

    public void execute() {
        if (completed || executing) {
            return;
        }

        for (Process dependency : dependencies) {
            if (!dependency.isCompleted()) {
                dependency.addCallback(new Callback() {
                    @Override
                    public void onComplete() {
                        executeIfReady();
                    }
                });
                return;
            }
        }
        runProcess();
    }

    private void runProcess() {
        executing = true;
        new Thread(() -> {
            try {
                System.out.println("Процесс " + id + " начинает выполнение.");
                Thread.sleep(executionTime);
                System.out.println("Процесс " + id + " завершил выполнение.");

                completed = true;
                executing = false;

                for (Callback callback : callbacks) {
                    callback.onComplete();
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

    void executeIfReady() {
        for (Process dependency : dependencies) {
            if (!dependency.isCompleted()) {
                return;
            }
        }
        execute();
    }
}