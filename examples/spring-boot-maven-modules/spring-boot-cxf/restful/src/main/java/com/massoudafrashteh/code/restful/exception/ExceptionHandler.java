package com.massoudafrashteh.code.restful.exception;

import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;

import com.massoudafrashteh.code.restful.response.ErrorResponse;

public class ExceptionHandler implements ExceptionMapper<Exception> {
	@Override
	public Response toResponse(final Exception exception) {
		final ErrorResponse errorResponse = new ErrorResponse();
		errorResponse.setStatus(Response.Status.INTERNAL_SERVER_ERROR.getStatusCode());
		errorResponse.setError("Internal Server Error");
		return Response.status(Response.Status.INTERNAL_SERVER_ERROR)
				.entity(errorResponse)
				.build();
	}
}