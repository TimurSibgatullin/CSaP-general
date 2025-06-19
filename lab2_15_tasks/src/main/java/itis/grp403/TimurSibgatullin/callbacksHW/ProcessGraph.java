package itis.grp403.TimurSibgatullin.callbacksHW;

import java.util.HashMap;
import java.util.Map;

public class ProcessGraph {
    private final Map<Integer, Process> processes = new HashMap<>();

    public void addProcess(int id, int executionTime) {
        processes.put(id, new Process(id, executionTime));
    }

    public void addDependency(int dependentId, int dependencyId) {
        Process dependent = processes.get(dependentId);
        Process dependency = processes.get(dependencyId);
        dependent.addDependency(dependency);
    }

    public void startAll() {
        for (Process process : processes.values()) {
            process.execute();
        }
    }
}
