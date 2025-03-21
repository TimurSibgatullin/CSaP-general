package itis.grp403.TimurSibgatullin;

class OddElevator extends Elevator {
    String getElevatorType() {
        return "Odd Elevator";
    }
    CallType getSupportedCallType() {
        return CallType.ODD;
    }
}
