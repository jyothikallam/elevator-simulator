package com.locusenergy.homework;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * @author Jyothi
 *
 */
public class ElevatorImplTest {
	/**
	 * @throws java.lang.Exception
	 */
	ElevatorImpl elv;

	@Before
	public void setUp() throws Exception {
		elv = new ElevatorImpl(100, 0, 1);
	}

	/**
	 * @throws java.lang.Exception
	 */
	@After
	public void tearDown() throws Exception {
	}

	// If the requested floor is less than ground floor
	@Test (expected = InvalidRequestException.class)
	public void negativeRequestFloorValueTest() throws InvalidRequestException, InvalidStateException {
		elv.requestFloor(-1);
	}
	
	// If the requested floor is higher than top floor
	@Test (expected = InvalidRequestException.class)
	public void HighestRequestFloorValueTest() throws InvalidRequestException, InvalidStateException {
		elv.requestFloor(101);
	}
	
	// Tests if the requested floor = current floor
	@Test (expected = InvalidStateException.class)
	public void sameFloorValueTest() throws InvalidStateException, InvalidRequestException {
		elv.requestFloor(0);
	}
	
	// Successful Test
	@Test
	public void SuccessfulTest() throws InvalidStateException, InvalidRequestException {
		elv.requestFloor(4);
	}
}
