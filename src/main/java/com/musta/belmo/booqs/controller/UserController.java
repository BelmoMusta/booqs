package com.musta.belmo.booqs.controller;

import com.musta.belmo.booqs.entite.dto.CustomizedValueDTO;
import com.musta.belmo.booqs.entite.dto.UserDTO;
import com.musta.belmo.booqs.entite.dto.UserRoleDTO;
import com.musta.belmo.booqs.security.annotation.IsAdmin;
import com.musta.belmo.booqs.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/user")
@CrossOrigin
public class UserController {
	@Autowired
	private UserService userService;
	
	@PostMapping("/create")
	public void createUser(@RequestBody UserDTO userRequest) {
		userService.createUser(userRequest);
	}
	
	@PostMapping("/register")
	public void registerUser(@RequestBody UserDTO userRequest) {
		userService.createUser(userRequest);
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
	
	@GetMapping("/{id}/customized-properties")
	public ResponseEntity<List<CustomizedValueDTO>> customizedProperties(@PathVariable Long id) {
		return ResponseEntity.ok(userService.customizedProperties(id));
	}
	
	@PostMapping("/{id}/assign-customized-value")
	public ResponseEntity<?> assignCustomizedValue(@PathVariable Long id, @RequestBody CustomizedValueDTO customizedValueDTO) {
		userService.assignCustomizedValue(id, customizedValueDTO);
		return ResponseEntity.ok().build();
	}
	
}