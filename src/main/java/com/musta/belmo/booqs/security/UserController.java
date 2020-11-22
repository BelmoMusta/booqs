package com.musta.belmo.booqs.security;

import com.musta.belmo.booqs.entite.dto.UserRoleDTO;
import com.musta.belmo.booqs.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
@CrossOrigin
public class UserController {
	@Autowired
	UserService userService;
	
	@PostMapping("/create")
	public void createUser(@RequestBody JwtRequest request) {
		userService.createUser(request.getUsername(), request.getPassword(), request.getEmail());
	}
	
	@GetMapping("/activate/{token}")
	public void activate(@PathVariable String token) {
		userService.activate(token);
	}
	
	@PostMapping("/assign-role")
	@IsAdmin
	public void assignRole(@RequestBody UserRoleDTO userRoleDTO) {
		userService.assignRole(userRoleDTO);
	}
	
	@PostMapping("/revoke-role")
	public void revokeRole(@RequestBody UserRoleDTO userRoleDTO) {
		userService.revokeRole(userRoleDTO);
	}
}
