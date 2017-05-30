package com.massoudafrashteh.code.restful.controller;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.springframework.stereotype.Component;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@Component
@Path("/")
@Api(value = "/")
@Produces(MediaType.TEXT_PLAIN)
public class IndexController {

	@GET
	@Path("ping")
	@ApiOperation(value = "Returns a simple text \"Pong\" that shows API is working well")
	public String ping() {
		return "pong";
	}
}
