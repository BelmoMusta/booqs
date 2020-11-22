package com.musta.belmo.booqs.security;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class JwtResponse {
	private final String jwttoken;
	
	public JwtResponse(String token) {
		jwttoken = token;
		
	}
}
