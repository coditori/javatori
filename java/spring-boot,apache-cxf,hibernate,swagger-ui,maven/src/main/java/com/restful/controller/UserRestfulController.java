package restful.controller;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import restful.model.User;
import restful.repository.UserRepository;

@Path("/users")
@Service
@Api(value = "/users") // Enables Swagger UI on /users
@Produces({ MediaType.APPLICATION_JSON })
public class UserRestfulController {
	@Autowired
	private UserRepository userRepository;

	@GET
	@ApiOperation(value = "Get all users details", response = User.class)
	public List<User> getAll() {
		return userRepository.findAll();
	}

	@GET
	@Path("/{userId}")
	public User get(@PathParam("userId") final long userId) {
		return userRepository.findById(userId);
	}

	@PUT
	@Consumes(MediaType.APPLICATION_FORM_URLENCODED)
	public void add(@FormParam("name") final String name) {
		final User user = new User(name);
		user.setId(3);
		userRepository.add(user);
	}

	@DELETE
	@Path("/{userId}")
	public void deleteById(@PathParam("userId") final long userId) {
		// Apache CXF generates standard errors with all details
		userRepository.deleteById(userId);
	}
}
