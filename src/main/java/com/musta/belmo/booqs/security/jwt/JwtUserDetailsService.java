package com.musta.belmo.booqs.security.jwt;

import com.musta.belmo.booqs.exception.AuthenticationException;
import com.musta.belmo.booqs.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;

@Service
public class JwtUserDetailsService implements UserDetailsService {
	@Autowired
	private UserService userService;
	
	@Override
	public UserDetails loadUserByUsername(String username) {
		UserDetails user = userService.loadUserByUsername(username);
		if (user != null) {
			return user;
		} else {
			throw new AuthenticationException("User not found with username: " + username);
		}
	}
}
