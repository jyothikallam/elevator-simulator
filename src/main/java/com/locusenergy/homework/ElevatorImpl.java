package com.locusenergy.homework;

import com.locusenergy.homework.InvalidStateException;
import com.locusenergy.homework.InvalidRequestException;

/**
 * This class implements Elevator interface and implements methods that register and run the elevator.
 *
 * <p>The method of this class throw a <tt>InvalidRequestException</tt>
 * if invalid inputs are provided to them.
 * 
 * <p>The method of this class throw a <tt>InvalidStateException</tt>
 * if requested an elevator that is not busy.
 * 
 * For example, invoking the <tt>requestFloor</tt> method with a floor value  
 * equal to currentFloorNumber throws <tt>InvalidStateException</tt>.
 *
 * @author  Jyothi
 */

public class ElevatorImpl implements Elevator {

	public int currentFloorNumber = 0;
	private int tofloor;
	private int totalFloors;
	public int direction;

	
	ElevatorImpl (int totalFloors, int currentFloorNumber, int direction){
		this.totalFloors = totalFloors;
		this.currentFloorNumber = currentFloorNumber;
		this.direction =  direction;
	}
	
	/**
	   * This method is used to register the requested floor by user. 
	   * 
	   * @param floor - The floor number to which user wants to go.
	   */
	@Override
	public void requestFloor(int floor) throws InvalidRequestException, InvalidStateException {
		this.tofloor = floor;
		//try {
		if (tofloor > totalFloors || tofloor < 0) {
			throw new InvalidRequestException("Enter a vaild floor number");
		} else {
			if (currentFloorNumber < tofloor) {
				direction = 1; // upward direction
			}
			else if (currentFloorNumber > tofloor) {
					direction = -1; // downward direction
			} 
			else
			{
				direction = 0; // stays in same floor
				throw new InvalidStateException("Elevator is not busy, it is in your floor");
			}
		}
//	} catch (InvalidStateException e){
//		System.out.println(e);
//	} catch (InvalidRequestException e) {
//		System.out.println(e);
//	}
	}
	
	/**
	   * This method is used to move elevator to the requested floor by user.
	   * 
	   */
	@Override
	public void moveFloor() {
		for (int i=1; i<=tofloor; i++){
			System.out.println("floor: "+ i);
		}
	}
	
	/**
	   * This method is used to see if the elevator is busy or available.
	   * 
	   * @param bool - returns true if the elevator is busy. 
	   */
	@Override
	public boolean isBusy() {
		if (direction == 1 || direction == -1) {
			return true;
		} else
			return false;
	}

	/**
	   * This method is used to get the current floor.
	   * 
	   * @return bool - returns current floor of the elevator. 
	   */
	@Override
	public int currentFloor() {
		return currentFloorNumber;
	}
	
}
