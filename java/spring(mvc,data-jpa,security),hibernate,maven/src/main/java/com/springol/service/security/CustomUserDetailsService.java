package com.springol.service.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.springol.model.User;
import com.springol.repository.RoleRepository;
import com.springol.repository.UserRepository;

@Service("customUserDetailsService")
public class CustomUserDetailsService implements UserDetailsService {
	private final UserRepository userRepository;
	private final RoleRepository roleRepository;

	@Autowired
	public CustomUserDetailsService(UserRepository userRepository, RoleRepository roleRepository) {
		this.userRepository = userRepository;
		this.roleRepository = roleRepository;
	}

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		User user = userRepository.findByUsername(username);
		String userRole = roleRepository.findRoleByUsername(username);
		return new CustomUserDetails(user, userRole);
	}
}