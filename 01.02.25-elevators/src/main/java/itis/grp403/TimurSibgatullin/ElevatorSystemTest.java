package itis.grp403.TimurSibgatullin;

public class ElevatorSystemTest {
    // подходит ли этаж для вызова
    static boolean isFloorSuitable(int floor, CallType ct) {
        if (ct == CallType.EVEN)
            return (floor % 2 == 0);
        if (ct == CallType.ODD)
            return (floor % 2 != 0);
        return true; // для сотрудников
    }

    static void processCall(Elevator[] elevators, ElevatorCall call) throws NoElevatorAvailableException {
        boolean assigned = false;
        for (int i = 0; i < elevators.length; i++) {
            if (elevators[i].getState() == ElevatorState.STANDS &&
                    elevators[i].getSupportedCallType() == call.getCallType()) {
                elevators[i].assignCall(call.getDestinationFloor());
                System.out.println("Вызов " + call.getCallType() + " на этаж " + call.getDestinationFloor()
                        + " назначен на " + elevators[i].getElevatorType());
                assigned = true;
                break;
            }
        }
        if (!assigned) {
            throw new NoElevatorAvailableException("нет доступного лифты "
                    + call.getCallType() + " на этаж " + call.getDestinationFloor());
        }
    }

    public static void main(String[] args) {
// создаём массив лифтов
        Elevator[] elevators = new Elevator[7];
        int idx = 0;
        for (int i = 0; i < 3; i++) {
            elevators[idx++] = new EvenElevator();
        }
        for (int i = 0; i < 3; i++) {
            elevators[idx++] = new OddElevator();
        }
        elevators[idx] = new EmployeeElevator();

        // симуляция работы
        for (int iter = 1; iter <= 10000; iter++) {
            // обновляем состояние лифтов
            for (int i = 0; i < elevators.length; i++) {
                elevators[i].step();
            }
            // генерируем вызов
            if (iter % 20 == 0) {
                // определяем тип вызова
                int r = (int)(Math.random() * 3);
                CallType ct;
                if (r == 0) {
                    ct = CallType.EVEN;
                } else if (r == 1) {
                    ct = CallType.ODD;
                } else {
                    ct = CallType.EMPLOYEE;
                }
                int destFloor;
                // генерируем этаж и проверяем соответствие типу лифта
                do {
                    destFloor = 2 + (int)(Math.random() * 15); // этаж от 2 до 16
                } while (!isFloorSuitable(destFloor, ct));

                ElevatorCall call = new ElevatorCall(ct, destFloor);
                try {
                    processCall(elevators, call); // вызов лифта если есть свободные
                } catch (NoElevatorAvailableException e) {
                    // иначе вывод сообщения об ошибке
                    System.err.println("Error: " + e.getMessage());
                }
            }
        }
    }
}