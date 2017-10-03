package com.utility;

public class UserAlreadyExists extends Exception{

	public UserAlreadyExists() {
		super();
	}

	public UserAlreadyExists(String message) {
		super(message);
	}	

}
