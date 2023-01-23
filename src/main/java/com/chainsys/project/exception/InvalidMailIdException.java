package com.chainsys.project.exception;

public class InvalidMailIdException extends Exception {
	{
		System.out.println("Invalid mail id format, mail id must contain '@' and domain name \n 'use: abcd@domain.com'");
	}
}
