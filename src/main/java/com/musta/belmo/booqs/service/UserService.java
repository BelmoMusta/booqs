package com.musta.belmo.booqs.service;

import com.musta.belmo.booqs.entite.User;
import com.musta.belmo.booqs.entite.dto.CustomizedValueDTO;
import com.musta.belmo.booqs.entite.dto.RoleDTO;
import com.musta.belmo.booqs.entite.dto.UserDTO;
import com.musta.belmo.booqs.entite.dto.UserRoleDTO;

import java.util.List;

public interface UserService {
	
	User loadUserByUsernameOrEmail(String username);
	
	void createUser( UserDTO userRequest);
	
	void activate(String token);
	
	void assignRole(UserRoleDTO userRoleDTO);
	
	void revokeRole(UserRoleDTO userRoleDTO);
	
	List<CustomizedValueDTO> customizedProperties(Long id);
	
	void assignCustomizedValue(Long id, CustomizedValueDTO customizedValueDTO);
	
	List<RoleDTO> roles(Long id);
}
