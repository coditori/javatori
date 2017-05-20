package com.springol.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.springol.model.Role;
import com.springol.repository.RoleRepository;

@Service
public class RoleServiceImpl implements RoleService {
	@Autowired
	RoleRepository roleRepository;

	@Override
	@Transactional
	public void save(Role role) {
		roleRepository.save(role);
	}

	@Override
	@Transactional
	public List<Role> getAll() {
		return roleRepository.findAll();
	}
	
	@Override
	@Transactional
	public Role findById(Long id) {
		return roleRepository.findOne(id);
	}
}
