package com.ndp.service;

import com.ndp.model.UserModel;

public interface IUserService {

	UserModel findOneByEmailAndPasswordAndStatus(String email,String password,int status);
}
