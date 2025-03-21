package itis.grp403.TimurSibgatullin;

class EvenElevator extends Elevator {
    String getElevatorType() {
        return "Even Elevator";
    }
    CallType getSupportedCallType() {
        return CallType.EVEN;
    }
}