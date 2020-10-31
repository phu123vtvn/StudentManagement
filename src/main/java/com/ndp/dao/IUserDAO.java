package com.ndp.dao;

import com.ndp.model.UserModel;

public interface IUserDAO extends GenericDAO<UserModel>{

	UserModel findByUserNameAndPasswordAndStatus(String userName, String password, int status);
}
