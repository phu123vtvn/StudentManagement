package com.ndp.dao.implement;

import java.util.List;

import com.ndp.dao.IUserDAO;
import com.ndp.mapper.UserMapper;
import com.ndp.model.UserModel;

public class UserDAO extends AbstractDAO<UserModel> implements IUserDAO{

	@Override
	public UserModel findByUserNameAndPasswordAndStatus(String userName, String password, int status) {
		String sql="select * from user where email=? and password=? and status=?";
		List<UserModel> arr=query(sql,new UserMapper(), userName,password,status);
		return arr.isEmpty()?null:arr.get(0);
	}
}
