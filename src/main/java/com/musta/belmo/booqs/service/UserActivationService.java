package com.musta.belmo.booqs.service;

import com.musta.belmo.booqs.entite.User;
import com.musta.belmo.booqs.entite.UserActivation;

public interface UserActivationService {
	
	UserActivation findbyToken(String token);
	
	void createActivationForUser(User user);
}
