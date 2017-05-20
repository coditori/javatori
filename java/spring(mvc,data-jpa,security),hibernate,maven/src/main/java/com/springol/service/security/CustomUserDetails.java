package com.springol.service.security;

import java.util.Collection;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.UserDetails;

import com.springol.model.User;

public class CustomUserDetails extends User implements UserDetails {	
	
	private static final long serialVersionUID = 1L;
	private String userRole;

	public CustomUserDetails(User user,String userRole){
		super(user);
		this.userRole=userRole;
	}
	
	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		return AuthorityUtils.commaSeparatedStringToAuthorityList(userRole);
	}

	@Override
	public boolean isAccountNonExpired() {
		return true;
	}
	@Override
	public boolean isAccountNonLocked() {
		return true;
	}
	
	@Override
	public boolean isCredentialsNonExpired() {
		return true;
	}
	@Override
	public boolean isEnabled() {
		return true;
	}

	@Override
	public String getUsername() {
		return super.getUsername();
	}
}
