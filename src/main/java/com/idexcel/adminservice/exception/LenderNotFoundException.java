package com.idexcel.adminservice.exception;

public class LenderNotFoundException extends RuntimeException{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public LenderNotFoundException(String message) {
		super(message);
	}
	
	public LenderNotFoundException(String message, Throwable cause) {
		super(message,cause );
	}
	
	public LenderNotFoundException(Throwable cause) {
		super(cause);
	}

}
