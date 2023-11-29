package com.orive.Organisation.Exceptions;

public class ResourceNotFounException extends RuntimeException{

	public ResourceNotFounException(String s) {
		super(s);
	}
	
	public ResourceNotFounException() {
		super("Resource not found !!");
	}
}
