package com.ndp.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import com.ndp.model.MajorsModel;


public class MajorsMapper implements RowMapper<MajorsModel> {

	public MajorsModel mapRow(ResultSet resultSet) {
		try {
			MajorsModel majors = new MajorsModel();
			majors.setMajors_code(resultSet.getLong("majors_code"));
			majors.setMajors_name(resultSet.getString("majors_name"));
			return majors;
		} catch (SQLException e) {
			return null;
		}
	}
}
