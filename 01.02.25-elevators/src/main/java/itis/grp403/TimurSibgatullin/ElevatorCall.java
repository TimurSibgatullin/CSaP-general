package itis.grp403.TimurSibgatullin;

class ElevatorCall implements Call {
    private CallType callType;
    private int destinationFloor;

    public ElevatorCall(CallType callType, int destinationFloor) {
        this.callType = callType;
        this.destinationFloor = destinationFloor;
    }

    public CallType getCallType() {
        return callType;
    }

    public int getDestinationFloor() {
        return destinationFloor;
    }
}