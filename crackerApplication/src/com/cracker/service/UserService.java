package com.cracker.service;

import com.cracker.domain.UserCrk;

public interface UserService {
	
	
	public void save(UserCrk user);
	
	public UserCrk get(String userId);

}
