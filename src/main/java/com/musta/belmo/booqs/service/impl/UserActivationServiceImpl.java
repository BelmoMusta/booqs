package com.musta.belmo.booqs.service.impl;

import com.musta.belmo.booqs.entite.User;
import com.musta.belmo.booqs.entite.UserActivation;
import com.musta.belmo.booqs.repository.UserActivationRepository;
import com.musta.belmo.booqs.service.UserActivationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Date;
import java.util.UUID;

@Service
public class UserActivationServiceImpl implements UserActivationService {
	@Autowired
	private UserActivationRepository userActivationRepository;
	
	@Override
	public UserActivation findbyToken(String token) {
		return userActivationRepository.findOne(new EqualsSpecification<>("token", token))
				.orElse(null);
	}
	
	@Override
	public void createActivationForUser(User user) {
		final UserActivation activation = new UserActivation();
		activation.setUser(user);
		activation.setToken(UUID.randomUUID().toString());
		final LocalDateTime localDateTime = LocalDateTime.now().plusDays(1);
		final Date expiresAt = Date.from(localDateTime.atZone(ZoneId.systemDefault()).toInstant());
		activation.setExpiresAt(expiresAt);
		userActivationRepository.save(activation);
		
	}
}
