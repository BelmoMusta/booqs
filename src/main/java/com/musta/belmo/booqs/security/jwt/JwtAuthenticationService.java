package com.musta.belmo.booqs.security.jwt;

import com.musta.belmo.booqs.exception.AuthenticationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

@Service
public class JwtAuthenticationService {
	
	@Autowired
	private AuthenticationManager authenticationManager;
	
	@Autowired
	private JwtTokenUtil jwtTokenUtil;
	
	@Autowired
	private JwtUserDetailsService userDetailsService;
	
	public JwtResponse authenticate(JwtRequest authenticationRequest) {
		try {
			authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(authenticationRequest.getUsername(), authenticationRequest.getPassword()));
			final UserDetails userDetails = userDetailsService
					.loadUserByUsername(authenticationRequest.getUsername());
			
			final String token = jwtTokenUtil.generateToken(userDetails);
			return new JwtResponse(token);
			
		} catch (DisabledException e) {
			throw new AuthenticationException(String.format("the user %s is disabled",
					authenticationRequest.getUsername()));
		} catch (BadCredentialsException e) {
			throw new AuthenticationException("password and/or username are incorrect");
		}
	}
}