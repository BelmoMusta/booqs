package com.musta.belmo.booqs.service.impl;

import com.musta.belmo.booqs.entite.Role;
import com.musta.belmo.booqs.exception.NotFoundException;
import com.musta.belmo.booqs.repository.RoleRepository;
import com.musta.belmo.booqs.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RoleServiceImpl implements RoleService {
	@Autowired
	private RoleRepository roleRepository;
	
	@Override
	public Role findByName(String authority) {
		return roleRepository.findOne(EqualsSpecification.create("authority", authority))
				.orElseThrow(() -> new NotFoundException("Role", authority));
	}
	
	@Override
	public Role createRole(String authority) {
		Role role = new Role();
		role.setAuthority(authority);
		return roleRepository.save(role);
	}
	
	@Override
	public void enable(String authority) {
		enableOrDisable(authority, true);
	}
	
	@Override
	public void disable(String authority) {
		enableOrDisable(authority, false);
	}
	
	private void enableOrDisable(String authority, boolean flag) {
		Role role = roleRepository.findOne(EqualsSpecification.create("authority", authority))
				.orElseThrow(() -> new NotFoundException("Role", authority));
		
		role.setEnabled(flag);
		roleRepository.saveAndFlush(role);
	}
}
