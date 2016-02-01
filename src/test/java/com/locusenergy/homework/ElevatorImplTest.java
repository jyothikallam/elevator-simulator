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

	//
	@Test(expected = InvalidRequestException.class)
	public void negativeRequestFloorValueTest() throws InvalidRequestException {
		elv.requestFloor(-1);
	}
	
	@Test(expected = InvalidRequestException.class)
	public void HighestRequestFloorValueTest() throws InvalidRequestException {
		elv.requestFloor(101);
	}
	
	@Test(expected = InvalidStateException.class)
	public void sameFloorValueTest() throws InvalidStateException {
		elv.requestFloor(0);
	}
}
