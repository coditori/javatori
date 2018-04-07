package com.massoudafrashteh.code.spring.dans.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.massoudafrashteh.code.spring.dans.domain.User;
import com.massoudafrashteh.code.spring.dans.repository.UserRepository;
import com.massoudafrashteh.code.spring.dans.service.UserService;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserRepository userRepository;

	@Override
	public User save(final User user) {
		return userRepository.save(user);
	}

	@Override
	public User findById(final long id) {
		return userRepository.findOne(id);
	}

	@Override
	public List<User> findAll() {
		return userRepository.findAll();
	}

	@Override
	public User update(final User user) {
		return userRepository.save(user);
	}

	@Override
	public void deleteById(final long id) {
		userRepository.delete(id);
	}
}
