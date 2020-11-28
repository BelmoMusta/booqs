package com.musta.belmo.booqs.controller;

import com.musta.belmo.booqs.entite.dto.UserDTO;
import com.musta.belmo.booqs.security.jwt.JwtAuthenticationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
@CrossOrigin
public class JwtAuthenticationController {
	
	@Autowired
	private JwtAuthenticationService jwtAuthenticationService;
	
	@RequestMapping(value = "/authenticate", method = RequestMethod.POST)
	public ResponseEntity<?> createAuthenticationToken(@RequestBody UserDTO authenticationRequest) {
		return ResponseEntity.ok(jwtAuthenticationService.authenticate(authenticationRequest));
	}
	
}