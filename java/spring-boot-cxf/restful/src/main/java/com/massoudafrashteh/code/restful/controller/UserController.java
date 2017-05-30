package com.massoudafrashteh.code.restful.controller;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.massoudafrashteh.code.spring.dans.domain.User;
import com.massoudafrashteh.code.spring.dans.service.UserService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@Component
@Path("/users")
@Api(value = "/users") // Enables Swagger Documentation
@Produces(MediaType.APPLICATION_JSON)
public class UserController {

	@Autowired
	private UserService userService;

	@PUT
	@Consumes(MediaType.APPLICATION_FORM_URLENCODED)
	@ApiOperation(value = "Saves a new user which is not exist")
	public void save(@FormParam("firstName") final String firstName) {
		final User user = new User(firstName);
		userService.save(user);
	}

	@POST
	@Consumes(MediaType.APPLICATION_FORM_URLENCODED)
	@ApiOperation(value = "Updates an exist user with passed user fields")
	public void update(@FormParam("") final User user) {
		userService.update(user);
	}

	@DELETE
	@Path("/{userId}")
	@ApiOperation(value = "Deletes an exist user with passed ID")
	public void deleteById(@PathParam("userId") final long userId) {
		userService.deleteById(userId);
	}

	@GET
	@Path("/{userId}")
	@ApiOperation(value = "Finds an exist user with passed ID")
	public User findById(@PathParam("userId") final long userId) {
		return userService.findById(userId);
	}

	@GET
	@ApiOperation(value = "Find all users", response = User.class)
	public List<User> findAll() {
		return userService.findAll();
	}
}
