/**
 * 
 */
package com.locusenergy.homework;

import java.util.Scanner;
import java.util.*;
import java.util.HashMap;

/**
 * @author jyothi
 *
 */
public class ElevatorControllerImpl extends InvalidRequestException implements ElevatorController {

    static int totalfloors;
	private static Scanner input;
	static ArrayList<ElevatorImpl> elevArr = new ArrayList<ElevatorImpl>();
	
	public Elevator callElevator(int fromFloor, int direction) throws InvalidRequestException {
		
		if(fromFloor < 0 || fromFloor > totalfloors)
		{
			throw new InvalidRequestException();
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
		System.out.println("Enter the total no of floors in the building:");
		input = new Scanner(System.in);
		totalfloors = input.nextInt();
		System.out.println("Enter the no of elevators in the building:");
		int noofelevators = input.nextInt();
		
		for (int i = 0; i < noofelevators; i++) {
			// create elevator instances here
			elevArr.add(new ElevatorImpl(totalfloors, 0, 0));
		}
		
		while(true)
		{
			System.out.println("Enter your current floor number:");
			int fromfloor = input.nextInt();
			System.out.println("Enter your desired direction of move:");
			int dir = input.nextInt();

			try {
				ElevatorImpl ei = (ElevatorImpl) new ElevatorControllerImpl().callElevator(fromfloor, dir);
				ei.direction = dir;
				System.out.printf("Elevator %d was requested and is on the way to your floor", elevArr.indexOf(ei));

				System.out.println("\nEnter your desired floor number:");
				int tofloor = input.nextInt();
				ei.requestFloor(tofloor);

				ei.moveFloor(tofloor);
				System.out.printf("\nElevator %d is on the desired floor %d", elevArr.indexOf(ei), tofloor);
				ei.currentFloorNumber = tofloor;
				ei.direction = 0;

			} catch (InvalidRequestException e) {
				e.printStackTrace();
			}	
		}
	}
}
