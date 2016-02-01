package com.locusenergy.homework;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * @author Jyothi
 *
 */
public class ElevatorControllerImplTest {

	/**
	 * @throws java.lang.Exception
	 */
	ElevatorControllerImpl elv;

	@Before
	public void setUp() throws Exception {
		elv = new ElevatorControllerImpl();
		ElevatorControllerImpl.totalfloors = 100;
	}

	/**
	 * @throws java.lang.Exception
	 */
	@After
	public void tearDown() throws Exception {
	}

	@Test(expected = InvalidRequestException.class)
	public void negativeFromFloorValueTest() throws InvalidRequestException {
		elv.callElevator(-1, 1);
	}

	@Test(expected = InvalidRequestException.class)
	public void HigherFromFloorValueTest() throws InvalidRequestException {
		elv.callElevator(1000, 1);
	}

	@Test(expected = InvalidRequestException.class)
	public void upwardWrongDirectionTest() throws InvalidRequestException {
		elv.callElevator(100, 1);
	}

	@Test(expected = InvalidRequestException.class)
	public void downwardWrongDirectionTest() throws InvalidRequestException {
		elv.callElevator(0, -1);
	}

	@Test(expected = InvalidRequestException.class)
	public void RemainInSameFloorTest() throws InvalidRequestException {
		elv.callElevator(0, 0);
	}
	
	@Test
	public void MoreRequestThanElevatorTest() throws InvalidRequestException  {
		ElevatorImpl e1 = new ElevatorImpl(100, 1, 1);
		ElevatorImpl e2 = new ElevatorImpl(100, 2 , 1);
		
		ElevatorControllerImpl.elevArr.add(e1);
		ElevatorControllerImpl.elevArr.add(e2);
		
		elv.callElevator(0, 1);
		elv.callElevator(2, 1);
		elv.callElevator(100,-1);
	}

}
