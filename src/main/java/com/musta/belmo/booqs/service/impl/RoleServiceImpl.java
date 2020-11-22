package com.musta.belmo.booqs.service.impl;

import com.musta.belmo.booqs.entite.Role;
import com.musta.belmo.booqs.repository.RoleRepository;
import com.musta.belmo.booqs.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RoleServiceImpl implements RoleService {
	@Autowired
	private RoleRepository roleRepository;
	
	@Override
	public Role findByName(String roleName) {
		return roleRepository.findOne(new EqualsSpecification<>("authority", roleName))
				.orElse(null); // TODO
	}
	
	@Override
	public Role createRole(String roleName) {
		Role role = new Role();
		role.setAuthority(roleName);
		return roleRepository.save(role);
	}
}
