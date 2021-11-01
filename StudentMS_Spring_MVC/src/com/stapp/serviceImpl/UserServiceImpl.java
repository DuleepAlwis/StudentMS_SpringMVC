package com.stapp.serviceImpl;

import com.stapp.DaoImpl.UserDAOImpl;
import com.stapp.Entity.UserEntity;

public class UserServiceImpl {

	private UserDAOImpl userDao;
	
	public UserServiceImpl() {
		userDao = new UserDAOImpl();
		
	}
	
	public Long saveUser(UserEntity user) {
		return userDao.save(user);
	}
	
	public UserEntity loginUser(String email,String password) {
		return userDao.login(email, password);
	}
}
