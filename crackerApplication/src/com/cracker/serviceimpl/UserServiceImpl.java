package com.cracker.serviceimpl;

import org.springframework.stereotype.Service;



import com.cracker.dao.UserDao;
import com.cracker.domain.UserCrk;
import com.cracker.service.UserService;

@Service
public class UserServiceImpl implements UserService{

	
	private UserDao userDao;
	public void setUserDao(UserDao userDao) {
		this.userDao = userDao;
	}
	@Override
	public void save(UserCrk user) {
		userDao.save(user);
		
	}
	@Override
	public UserCrk get(String userId) {
		// TODO Auto-generated method stub
		return userDao.get(userId);
	}

}
