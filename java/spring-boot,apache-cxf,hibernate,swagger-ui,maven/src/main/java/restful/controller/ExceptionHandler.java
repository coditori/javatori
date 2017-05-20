package restful.controller;

import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;

public class ExceptionHandler implements ExceptionMapper<Exception> {
	@Override
	public Response toResponse(final Exception exception) {
		final ErrorResponse errorResponse = new ErrorResponse();
		errorResponse.setStatus(Response.Status.INTERNAL_SERVER_ERROR.getStatusCode());
		errorResponse.setError("Internal Server Error");
		return Response.status(Response.Status.INTERNAL_SERVER_ERROR)
				.entity(errorResponse)
				.build();
		// {
		// "timestamp": 1495293065424,
		// "status": 500,
		// "error": "Internal Server Error",
		// "exception": "org.springframework.dao.InvalidDataAccessApiUsageException",
		// "message": "detached entity passed to persist: restful.model.User; nested exception is
		// org.hibernate.PersistentObjectException: detached entity passed to persist: restful.model.User",
		// "path": "/services/users"
		// }
	}
}