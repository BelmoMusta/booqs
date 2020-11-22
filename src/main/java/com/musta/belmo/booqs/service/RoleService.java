package com.musta.belmo.booqs.service;

import com.musta.belmo.booqs.entite.Role;

public interface RoleService {
	
	Role findByName(String roleName);
	
	Role createRole(String roleName);
}
