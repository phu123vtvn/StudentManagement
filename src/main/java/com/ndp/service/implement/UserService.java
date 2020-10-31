package com.ndp.service.implement;

import javax.inject.Inject;

import com.ndp.dao.IUserDAO;
import com.ndp.model.UserModel;
import com.ndp.service.IUserService;

public class UserService implements IUserService{

	@Inject
	private IUserDAO userDao;
	
	@Override
	public UserModel findOneByEmailAndPasswordAndStatus(String email, String password, int status) {
		return userDao.findByUserNameAndPasswordAndStatus(email, password, status);
	}

}
