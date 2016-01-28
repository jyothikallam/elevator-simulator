/**
 * 
 */
package com.locusenergy.homework;

import java.util.Scanner;

/**
 * @author jyothi
 *
 */
public class ElevatorControllerImpl extends InvalidRequestException implements ElevatorController {

    static int totalfloors;
	public Elevator callElevator(int fromFloor, int direction) throws InvalidRequestException {
		ElevatorImpl e = new ElevatorImpl(totalfloors, fromFloor, direction);
		e.requestFloor(fromFloor);
		return e;
	}

	public static void main(String args[]) {
		System.out.println("Enter the total no of floors in the building:\t");
		Scanner input = new Scanner(System.in);
		totalfloors = input.nextInt();
		System.out.println("\nEnter the no of elevators in the building: \t");
		int noofelevators = input.nextInt();
		
//		System.out.println("\nEnter your destination floor number: \t");
//		int tofloor = input.nextInt();
		for (int i = 0; i < noofelevators; i++) {
			// create elevator instances here
		}
	}
}
