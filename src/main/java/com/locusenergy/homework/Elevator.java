package com.locusenergy.homework;

public interface Elevator {
    /**
     * Requests the Elevator to move to a certain floor. This method immitates pressing a button inside the
     * elevator. Therefore, it should not move the Elevator immidiately but just register the request.
     * 
     * Bonus: this method should throw InvalidStateException if the Elevator is NOT busy.
     */
    void requestFloor(int floor);
    
    /**
     * Requests the Elevator to move to a certain floor. It should move the Elevator depending on the registered request.
     * 
     */
    void moveFloor();
    
    /**
     * Returns the internal state of the Elevator.
     */
    boolean isBusy();
    
    /**
     * Returns the floor where the Elevator is now.
     */
    int currentFloor();
    
}
