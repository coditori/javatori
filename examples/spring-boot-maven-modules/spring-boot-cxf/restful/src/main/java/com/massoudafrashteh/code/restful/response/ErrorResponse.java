package com.massoudafrashteh.code.restful.response;

public class ErrorResponse {

	private int status;
	private String error;

	public String getError() {
		return error;
	}

	public void setError(final String error) {
		this.error = error;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(final int status) {
		this.status = status;
	}
}
