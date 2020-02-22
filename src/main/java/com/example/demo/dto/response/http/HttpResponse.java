package com.example.demo.dto.response.http;

import java.time.ZonedDateTime;

/**
 *Generic Class of response HTTP
 */
public class HttpResponse {
	
	protected String message;
	protected String status;
	protected int statusCode;
	protected String uriRequested;
	protected ZonedDateTime dateTransaction;
	
	
	/**
	 * Constructor. 
	 */
	public HttpResponse() {
		super();
	}

	/**
	 * Constructor without parameter.
	 * @param message
	 * @param status
	 * @param statusCode
	 * @param uriRequested
	 * @param dateTransaction
	 */
	public HttpResponse(String message, String status, int statusCode, String uriRequested, ZonedDateTime dateTransaction) {
		this.message = message;
		this.status = status;
		this.statusCode = statusCode;
		this.uriRequested = uriRequested;
		this.dateTransaction = dateTransaction;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public int getStatusCode() {
		return statusCode;
	}

	public void setStatusCode(int statusCode) {
		this.statusCode = statusCode;
	}

	public String getUriRequested() {
		return uriRequested;
	}

	public void setUriRequested(String uriRequested) {
		this.uriRequested = uriRequested;
	}

	public ZonedDateTime getDateTransaction() {
		return dateTransaction;
	}

	public void setDateTransaction(ZonedDateTime dateTransaction) {
		this.dateTransaction = dateTransaction;
	}
	
	
	
}