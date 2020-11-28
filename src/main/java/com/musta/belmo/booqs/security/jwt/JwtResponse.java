package com.musta.belmo.booqs.security.jwt;

import com.musta.belmo.booqs.entite.dto.UserDTO;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class JwtResponse {
	private final String jwttoken;
	private UserDTO user;
	
	public JwtResponse(String token) {
		jwttoken = token;
	}
}
