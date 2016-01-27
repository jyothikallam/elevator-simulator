/**
 * 
 */
package com.locusenergy.homework;

/**
 * @author jyothi
 *
 */
public class ElevatorControllerImpl extends InvalidRequestException implements ElevatorController {
	public Elevator callElevator(int fromFloor, int direction) throws InvalidRequestException{
		ElevatorImpl e = new ElevatorImpl(100, 2, direction);
		e.requestFloor(fromFloor);
		return e;
	}

}
