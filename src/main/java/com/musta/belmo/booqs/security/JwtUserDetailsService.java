package com.musta.belmo.booqs.security;

import com.musta.belmo.booqs.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class JwtUserDetailsService implements UserDetailsService {
	@Autowired
	private UserService userService;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		UserDetails user = userService.loadUserByUsername(username);
		if (user != null) {
			return user;
		} else {
			throw new UsernameNotFoundException("User not found with username: " + username);
		}
	}
}
