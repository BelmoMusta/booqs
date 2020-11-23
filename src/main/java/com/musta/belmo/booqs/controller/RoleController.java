package com.musta.belmo.booqs.controller;

import com.musta.belmo.booqs.entite.dto.RoleDTO;
import com.musta.belmo.booqs.security.annotation.IsAdmin;
import com.musta.belmo.booqs.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/role")
@CrossOrigin
public class RoleController {
	@Autowired
	private RoleService roleService;
	
	@PostMapping("/create")
	public void create(@RequestBody RoleDTO role) {
		roleService.createRole(role.getAuthority());
	}
	
	@PostMapping("/enable")
	@IsAdmin
	public void enable(@RequestBody RoleDTO roleDTO) {
		roleService.enable(roleDTO.getAuthority());
	}
	
	@PostMapping("/disable")
	@IsAdmin
	public void disable(@RequestBody RoleDTO roleDTO) {
		roleService.disable(roleDTO.getAuthority());
	}
}
