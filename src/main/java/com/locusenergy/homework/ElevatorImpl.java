package com.locusenergy.homework;

import java.util.Scanner;

public class ElevatorImpl extends InvalidStateException implements Elevator {

	private int currentFloorNumber = 0, tofloor, totalFloors;
	private int direction;

	ElevatorImpl (int totalFloors, int currentFloorNumber, int direction){
		this.totalFloors = totalFloors;
		this.currentFloorNumber = currentFloorNumber;
		this.direction =  direction;
	}
	
	@Override
	public void requestFloor(int floor) {
		this.tofloor = floor;
		try {
		if (tofloor > totalFloors || tofloor < 0) {
			System.out.println("Invalid Request, Please request a valid floor number \n");
			//throw new InvalidRequestException();
		} else {
			if (currentFloorNumber < tofloor) {
				direction = 1; // upward direction
				if (currentFloorNumber > tofloor) {
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
	
	//TODO -- parameter passing required? reuse?
	@Override
	public void moveFloor(int tofloor) {
		//this.tofloor = tofloor;
		for (int i=1; i<=tofloor; i++){
			System.out.println("floor: "+ i);
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
