package itis.grp403.TimurSibgatullin;

abstract class Elevator implements ElevatorInterface, Step {
    protected ElevatorState state;
    protected int currentFloor;
    protected Integer destinationFloor; // Если null – цель не задана

    public Elevator() {
        currentFloor = 1;
        state = ElevatorState.STANDS;
        destinationFloor = null;
    }

    public Elevator(ElevatorState state) {
        currentFloor = 1;
        this.state = state;
        destinationFloor = null;
    }

    public ElevatorState getState() {
        return state;
    }

    // Назначаем вызов (цель) лифту
    public void assignCall(int destFloor) {
        destinationFloor = destFloor;
        if (destFloor > currentFloor) {
            state = ElevatorState.GOING_UP;
        } else if (destFloor < currentFloor) {
            state = ElevatorState.GOING_DOWN;
        } else {
            state = ElevatorState.STANDS;
            destinationFloor = null;
        }
    }

    // Шаг: обновление текущего этажа в зависимости от направления
    public void step() {
        if (state == ElevatorState.GOING_UP) {
            currentFloor++;
            if (destinationFloor != null && currentFloor >= destinationFloor) {
                currentFloor = destinationFloor;
                state = ElevatorState.STANDS;
                destinationFloor = null;
            }
        } else if (state == ElevatorState.GOING_DOWN) {
            currentFloor--;
            if (destinationFloor != null && currentFloor <= destinationFloor) {
                currentFloor = destinationFloor;
                state = ElevatorState.STANDS;
                destinationFloor = null;
            }
        }
        // При состояниях NOT_WORKING или STANDS ничего не делаем
    }

    // Каждый наследник должен вернуть свой тип (для сообщений)
    abstract String getElevatorType();

    abstract CallType getSupportedCallType();
}