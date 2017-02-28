package br.com.g2soft.g2web.generic;

import org.springframework.http.HttpStatus;

public class EventException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private HttpStatus httpStatus;
	
	public EventException(String message) {
		super(message);
	}
	
	public EventException(String message, HttpStatus status) {
		super(message);
		this.httpStatus = status;
	}

	public EventException(HttpStatus status) {
		this.httpStatus = status;
	}

	public HttpStatus getStatus() {
		return httpStatus;
	}
	
}
