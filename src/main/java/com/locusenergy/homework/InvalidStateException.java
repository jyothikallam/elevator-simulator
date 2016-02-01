package com.locusenergy.homework;

/**This is a custom exception class thrown when elevator is not busy
*
* @author  Jyothi
*/
public class InvalidStateException extends Exception {
	
	 InvalidStateException(String s) {
		super(s);
	}
}
