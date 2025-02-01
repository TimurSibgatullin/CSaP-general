package itis.grp403.TimurSibgatullin;

class EmployeeElevator extends Elevator {
    String getElevatorType() {
        return "Employee Elevator";
    }
    CallType getSupportedCallType() {
        return CallType.EMPLOYEE;
    }
}