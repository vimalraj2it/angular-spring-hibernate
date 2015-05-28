package com.cracker.dao;

import com.cracker.domain.UserCrk;

public interface UserDao {
	
	
	public void save(UserCrk user);
	public UserCrk get(String userId);
}
