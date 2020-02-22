package com.example.demo.exception;

public class ParameterException extends Exception {
	
	private static final long serialVersionUID = 1L;

	public ParameterException() {
        super();
    }

    public ParameterException(String message) {
        super(message);
    }

    public ParameterException(String message, Throwable cause) {
        super(message, cause);
    }

    public ParameterException(Throwable cause) {
        super(cause);
    }
	
	
}
