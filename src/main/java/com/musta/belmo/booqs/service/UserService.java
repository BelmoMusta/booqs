package com.musta.belmo.booqs.service;

import com.musta.belmo.booqs.entite.User;
import com.musta.belmo.booqs.entite.dto.UserRoleDTO;

public interface UserService {
	
	User loadUserByUsername(String username);
	
	void createUser(String username, String password, String email);
	
	void activate(String token);
	
	void assignRole(UserRoleDTO userRoleDTO);
	
	void revokeRole(UserRoleDTO userRoleDTO);
}
