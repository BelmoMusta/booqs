package com.musta.belmo.booqs.security;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
public class JwtRequest implements Serializable {
	private String email;
	private String username;
	private String password;
}
