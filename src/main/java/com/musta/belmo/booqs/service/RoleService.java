package com.musta.belmo.booqs.service;

import com.musta.belmo.booqs.entite.Role;

public interface RoleService {
	
	Role findByName(String authority);
	
	Role createRole(String authority);
	
	void enable(String authority);
	
	void disable(String authority);
}
