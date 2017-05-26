package com.massoudafrashteh.code.spring.boot.cxf.restful.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.massoudafrashteh.code.spring.dans.domain.User;
import com.massoudafrashteh.code.spring.dans.service.UserService;

@RestController
@RequestMapping("/users")
public class UserController {

	@Autowired
	private UserService userService;

	@PutMapping("")
	public void save(@ModelAttribute("user") final User user) {
		System.out.println("new user is " + user);
		userService.save(user);
	}

	@GetMapping("{id}")
	public User findById(@PathVariable("id") final Long id) {
		return userService.findById(id);
	}

	@GetMapping("")
	public List<User> findAll() {
		return userService.findAll();
	}

	@PostMapping("")
	public void update(@ModelAttribute("user") final User user) {
		userService.update(user);
	}

	@DeleteMapping("{id}")
	public void deleteById(@PathVariable("id") final Long id) {
		userService.deleteById(id);
	}

}