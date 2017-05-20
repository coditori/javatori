package com.springol.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.springol.model.Role;

public interface RoleRepository extends JpaRepository<Role, Long>{
	@Query("select a.role from Role a inner join User b on a.id=b.role where b.id=?1")
	public String findRoleByUserId(long id);
	
	@Query("select a.role from Role a inner join User b on a.id=b.role where b.username=?1")
	public String findRoleByUsername(String username);
}