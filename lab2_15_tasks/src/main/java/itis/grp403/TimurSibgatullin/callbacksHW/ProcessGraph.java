package itis.grp403.TimurSibgatullin.callbacksHW;

import java.util.HashMap;
import java.util.Map;

public class ProcessGraph {
    private final Map<Integer, Process> processes;

    public ProcessGraph() {
        this.processes = new HashMap<>();
    }

    public void addProcess(int id, int executionTime) {
        processes.put(id, new Process(id, executionTime));
    }

    public void addDependency(int dependentId, int dependencyId) {
        Process dependent = processes.get(dependentId);
        Process dependency = processes.get(dependencyId);
        if (dependent != null && dependency != null) {
            dependent.addDependency(dependency);
            // Добавляем коллбек в зависимость, чтобы она уведомила зависимый процесс о завершении
            dependency.addCallback(new Callback() {
                @Override
                public void onComplete() {
                    dependent.executeIfReady();
                }
            });
        } else {
            throw new IllegalArgumentException("Процесс с указанным ID не существует.");
        }
    }

    public void startProcess(int id) {
        Process process = processes.get(id);
        if (process != null) {
            process.execute();
        } else {
            throw new IllegalArgumentException("Процесс с указанным ID не существует.");
        }
    }
}