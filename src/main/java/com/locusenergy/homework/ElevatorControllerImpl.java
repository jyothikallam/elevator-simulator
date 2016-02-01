package com.locusenergy.homework;

import java.util.Scanner;
import java.util.*;

/**
 * This class implements ElevatorController interface and implements 
 * a method that return the instance of elevator.
 *
 * <p>The method of this class throw a <tt>InvalidRequestException</tt>
 * if invalid inputs are provided to them.
 * 
 * For example, invoking the <tt>callElevator</tt> method with an invalid direction 
 * like -2 will throw <tt>InvalidRequestException</tt>.
 *
 * @author  Jyothi
 * @see     Collection
 * @see     ArrayList
 */
public class ElevatorControllerImpl implements ElevatorController {

	private static final long serialVersionUID = 1L;
	static int totalfloors;
	private static Scanner input;
	// Stores elevator instances
	static ArrayList<ElevatorImpl> elevArr = new ArrayList<ElevatorImpl>();
	
	/**
	   * This method is used to return the instance of the elevator.
	   * 
	   * @param fromFloor - The floor number from which, user requests the elevator.
	   * @param numB - The direction, in which user wants to go.
	   * @return ElevatorImpl - This returns the instance of the elevator.
	   */
	public Elevator callElevator(int fromFloor, int direction) throws InvalidRequestException {
		
		// checking if the request is being made from non-existing floor number
		if(fromFloor < 0 || fromFloor > totalfloors)
		{
			throw new InvalidRequestException("Invalid Floor Number - enter a valid floor number");
		}
		
		// checking for invalid direction- request of the user
		if(((fromFloor == totalfloors) && (direction == 1)) || ((fromFloor == 0) && (direction == -1)) || (direction == 0))
		{
			throw new InvalidRequestException(" Invalid direction - please choose correct direction");
		}
		
		int distance = Math.abs(((ElevatorImpl) elevArr.get(0)).currentFloor() - fromFloor);
		int idx = 0;
		
		for(int i = 0; i < elevArr.size(); i++)
		{
			if(!((ElevatorImpl) elevArr.get(i)).isBusy())
			{
				int cdistance = Math.abs(((ElevatorImpl) elevArr.get(i)).currentFloor() - fromFloor);
			    if(cdistance < distance){
			        idx = i;
			        distance = cdistance;
			    }
			}
		}
		return ((ElevatorImpl) elevArr.get(idx));
	}

	public static void main(String args[]) {
		input = new Scanner(System.in);
		System.out.println("Enter the total no of floors in the building:");
		totalfloors = input.nextInt();
		System.out.println("Enter the no of elevators in the building:");
		int noofelevators = input.nextInt();
		
		for (int i = 0; i < noofelevators; i++) {
			// create elevator instances here
			elevArr.add(new ElevatorImpl(totalfloors, 0, 0));
		}
		
		// accepting all requests from the user
		while(true)
		{
			System.out.println("\nEnter your current floor number:");
			int fromfloor = input.nextInt();
			System.out.println("\nEnter your desired direction of move:");
			int dir = input.nextInt();

			try {
				ElevatorImpl ei = (ElevatorImpl) new ElevatorControllerImpl().callElevator(fromfloor, dir);
				ei.direction = dir;
				System.out.printf("\nElevator %d was requested and is on the way to your floor", elevArr.indexOf(ei));

				System.out.println("\nEnter your desired floor number:");
				int tofloor = input.nextInt();
				try {
					ei.requestFloor(tofloor);
				} catch (InvalidStateException e) {
				}

				ei.moveFloor();
				System.out.printf("\nElevator %d is on the desired floor %d", elevArr.indexOf(ei), tofloor);
				ei.currentFloorNumber = tofloor;
				ei.direction = 0;

			} catch (InvalidRequestException e) {
				e.printStackTrace();
			}	
		}
	}
}
