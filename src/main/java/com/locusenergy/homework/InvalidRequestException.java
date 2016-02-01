package com.locusenergy.homework;

/**This is a custom exception class for invalid requests
 *
 * @author  Jyothi
 */
public class InvalidRequestException extends Exception {
		
		 InvalidRequestException(String s) {
			 super(s);
		}
	}
