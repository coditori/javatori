package com.springol.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.springol.model.User;
import com.springol.repository.UserRepository;

@Service
public class UserServiceImpl implements UserService{
	@Autowired
    private UserRepository userRepository;
	
	@Autowired
	BCryptPasswordEncoder bCryptPasswordEncoder;
	
    @Override
    @Transactional
    public User findByUsername(String username) {
        return userRepository.findByUsername(username);
    }
	
	@Override
	@Transactional
	public List<User> getAll() {
		return userRepository.findAll();
	}
	
	@Override
	@Transactional
	public void save(User user) {
		user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
		userRepository.save(user);
	}
	
	@Override
	@Transactional
	public User findById(long id) {
		return userRepository.getOne(id);
	}
}
