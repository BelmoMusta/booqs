package com.musta.belmo.booqs.service.impl;

import com.musta.belmo.booqs.entite.Role;
import com.musta.belmo.booqs.entite.User;
import com.musta.belmo.booqs.entite.UserActivation;
import com.musta.belmo.booqs.entite.dto.UserRoleDTO;
import com.musta.belmo.booqs.repository.UserRepository;
import com.musta.belmo.booqs.service.RoleService;
import com.musta.belmo.booqs.service.UserActivationService;
import com.musta.belmo.booqs.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.Collection;
import java.util.HashSet;

@Service
public class UserServiceImpl implements UserService {
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private RoleService roleService;
	@Autowired
	private PasswordEncoder passwordEncoder;
	
	@Autowired
	private UserActivationService userActivationService;
	
	@Override
	public User loadUserByUsername(String username) {
		
		return userRepository.findOne(new EqualsSpecification<>("username", username))
				.orElse(null);
	}
	
	@Override
	public void createUser(String username, String password, String email) {
		final User user = new User();
		user.setUsername(username);
		user.setEmail(email);
		user.setPassword(passwordEncoder.encode(password));
		user.setAccountNonExpired(true);
		user.setAccountNonLocked(true);
		user.setEnabled(false); // TO be activated
		user.setCredentialsNonExpired(true);
		final Role member = roleService.findByName("member");
		if (member != null) {
			user.setAuthorities(Arrays.asList(member));
		}
		userRepository.save(user);
		userActivationService.createActivationForUser(user);
	}
	
	@Override
	public void activate(String token) {
		UserActivation activation = userActivationService.findbyToken(token);
		if (activation != null) {
			User user = activation.getUser();
			user.setEnabled(true);
			userRepository.saveAndFlush(user);
			
		}
	}
	
	@Override
	public void assignRole(UserRoleDTO userRoleDTO) {
		Role role = roleService.findByName(userRoleDTO.getRole());
		if (role == null) {
			role = roleService.createRole(userRoleDTO.getRole());
		}
		User user = userRepository.findById(userRoleDTO.getUserId())
				.orElseThrow(() -> new RuntimeException("User not found"));
		Collection<Role> authorities = user.getAuthorities();
		if (authorities == null) {
			authorities = new HashSet<>();
			user.setAuthorities(authorities);
		}
		if (!authorities.contains(role)) {
			authorities.add(role);
		}
		userRepository.saveAndFlush(user);
		
	}
	
	@Override
	public void revokeRole(UserRoleDTO userRoleDTO) {
		Role role = roleService.findByName(userRoleDTO.getRole());
		if (role != null) {
			
			User user = userRepository.findById(userRoleDTO.getUserId())
					.orElseThrow(() -> new RuntimeException("User not found"));
			Collection<Role> authorities = user.getAuthorities();
			if (authorities == null) {
				return;
			}
			if (!authorities.contains(role)) {
				authorities.remove(role);
			}
			userRepository.saveAndFlush(user);
		}
	}
}
