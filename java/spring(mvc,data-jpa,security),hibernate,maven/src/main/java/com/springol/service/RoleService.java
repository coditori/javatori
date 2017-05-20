package com.springol.service;

import java.util.List;

import com.springol.model.Role;

public interface RoleService {
	public void save(Role role);
	public List<Role> getAll();
	public Role findById(Long id);
}
