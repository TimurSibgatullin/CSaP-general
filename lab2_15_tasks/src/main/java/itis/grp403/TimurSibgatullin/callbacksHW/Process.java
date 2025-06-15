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
        // Проверяем, завершен ли процесс
        if (completed || executing) {
            return;
        }

        // Проверяем, все ли зависимости завершены
        for (Process dependency : dependencies) {
            if (!dependency.isCompleted()) {
                // Добавляем текущий процесс как коллбек к зависимости
                dependency.addCallback(new Callback() {
                    @Override
                    public void onComplete() {
                        executeIfReady();
                    }
                });
                return;
            }
        }

        // Все зависимости завершены, выполняем текущий процесс
        runProcess();
    }

    private void runProcess() {
        executing = true;
        new Thread(() -> {
            try {
                // Выполняем текущий процесс
                System.out.println("Процесс " + id + " начинает выполнение.");
                Thread.sleep(executionTime);
                System.out.println("Процесс " + id + " завершил выполнение.");

                // Устанавливаем флаг завершения
                completed = true;
                executing = false;

                // Вызываем все коллбеки
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
        // Проверяем, все ли зависимости завершены
        for (Process dependency : dependencies) {
            if (!dependency.isCompleted()) {
                return;
            }
        }

        // Все зависимости завершены, выполняем текущий процесс
        execute();
    }
}