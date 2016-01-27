package com.locusenergy.homework;

public class ElevatorImpl extends InvalidStateException implements Elevator {

	private int currentFloorNumber = 0, destinationFloor, totalFloors;
	private int direction;

	ElevatorImpl (int totalFloors, int currentFloorNumber, int direction){
		this.totalFloors = totalFloors;
		this.currentFloorNumber = currentFloorNumber;
		this.direction =  direction;
	}
	
	@Override
	public void requestFloor(int floor) {
		this.destinationFloor = floor;
		try {
		if (destinationFloor > totalFloors || destinationFloor < 0) {
			System.out.println("Invalid Request, Please request a floor in between 1 to 100\n");
		} else {
			if (currentFloorNumber < destinationFloor) {
				direction = 1; // upward direction
				if (currentFloorNumber > destinationFloor) {
					direction = -1; // downward direction
				} else
					direction = 0; // stays in same floor
				throw new InvalidStateException();
			}
		}
	} catch (InvalidStateException e){
		System.out.println("Requested Floor is not registered with elevator:" + e);
	}
	}

	@Override
	public boolean isBusy() {
		if (direction == 1 || direction == -1) {
			return true;
		} else
			return false;
	}

	@Override
	public int currentFloor() {
		return currentFloorNumber;
	}
	
}
