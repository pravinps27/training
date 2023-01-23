package com.chainsys.project.exception;

public class InvalidPhoneNoException extends Exception{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	{
		System.out.println("Invalid phone number, phone number must be 10 digit or phone number must be start between 6 to 9");
	}
}
