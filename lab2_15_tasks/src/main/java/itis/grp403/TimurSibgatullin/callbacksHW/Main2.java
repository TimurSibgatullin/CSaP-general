package itis.grp403.TimurSibgatullin.callbacksHW;

public class Main2 {
    public static void main(String[] args) {
        ProcessGraph graph = new ProcessGraph();

        graph.addProcess(1, 2000);
        graph.addProcess(2, 5000);
        graph.addProcess(3, 6000);
        graph.addProcess(4, 4000);
        graph.addProcess(5, 8000);
        graph.addProcess(6, 7000);
        graph.addProcess(7, 11000);
        graph.addProcess(8, 5000);
        graph.addProcess(9, 3000);
        graph.addProcess(10, 4000);

        graph.addDependency(10, 9);
        graph.addDependency(9, 8);
        graph.addDependency(9, 7);
        graph.addDependency(6, 5);
        graph.addDependency(6, 4);
        graph.addDependency(8, 6);
        graph.addDependency(8, 7);
        graph.addDependency(7, 3);
        graph.addDependency(5, 2);
        graph.addDependency(4, 3);
        graph.addDependency(4, 2);
        graph.addDependency(3, 1);
        graph.addDependency(2, 1);

        graph.startProcess(1);
        graph.startProcess(2);
        graph.startProcess(3);
        graph.startProcess(4);
        graph.startProcess(5);
        graph.startProcess(6);
        graph.startProcess(7);
        graph.startProcess(8);
        graph.startProcess(9);
        graph.startProcess(10);
    }
}
