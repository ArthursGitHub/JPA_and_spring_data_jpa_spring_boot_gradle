package org.learn.bookpub.exception;

import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.ResponseBuilder;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

import org.learn.bookpub.envelope.Envelope;

@Provider
public class RoomUnAvailableExceptionMapper implements ExceptionMapper<RoomUnAvailableException> {

	@Override
	public Response toResponse(RoomUnAvailableException exception) {
		ResponseBuilder builder = Response.status(Response.Status.BAD_REQUEST);
		Envelope envelope =  new Envelope("Failed",exception.getMessage());
		return builder.entity(envelope).build();
	}
}
