package com.ndp.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import com.ndp.model.UserModel;


public class UserMapper implements RowMapper<UserModel> {

	public UserModel mapRow(ResultSet resultSet) {
		try {
			UserModel user = new UserModel();
			user.setId(resultSet.getLong("id"));
			user.setEmail(resultSet.getString("email"));
			user.setFullname(resultSet.getString("fullname"));
			user.setPassword(resultSet.getString("password"));
			user.setStatus(resultSet.getInt("status"));
			user.setRoleid(resultSet.getLong("roleid"));
			return user;
		} catch (SQLException e) {
			return null;
		}	
	}
}
