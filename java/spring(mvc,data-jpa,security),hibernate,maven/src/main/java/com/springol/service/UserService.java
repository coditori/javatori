package com.springol.service;

import java.util.List;

import com.springol.model.User;

public interface UserService {
	public User findByUsername(String username);
	public User findById(long id);
	public List<User> getAll();
	public void save(User user);
}
