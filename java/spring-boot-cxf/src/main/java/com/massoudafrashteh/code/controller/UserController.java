package com.massoudafrashteh.code.controller;

import com.massoudafrashteh.code.domain.User;
import com.massoudafrashteh.code.service.UserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;

@Component
@Path("/users")
@Api(value = "/users") // Enables Swagger Documentation
@Produces(MediaType.APPLICATION_JSON)
public class UserController {

    @Autowired
    private UserService userService;

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public User save(final User user) {
        return userService.save(user).get();
    }

    @GET
    @Path("/{id}")
    @ApiOperation(value = "Finds an exist user with passed ID")
    public User findById(@PathParam("id") final long userId) {
        return userService.findById(userId).get();
    }

    @GET
    @ApiOperation(value = "Find all users", response = User.class)
    public List<User> findAll() {
        return userService.findAll().get();
    }

    @PUT
    @Path("/{id}")
    @ApiOperation(value = "Updates an exist user with passed user fields")
    public User update(@PathParam("id") final long id,
                       final User user) {
        return userService.update(id, user).get();
    }

    @DELETE
    @Path("/{id}")
    @ApiOperation(value = "Deletes an exist user with ID")
    public void deleteById(@PathParam("id") final long userId) {
        userService.deleteById(userId);
    }
}

