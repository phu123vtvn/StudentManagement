package com.ndp.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import com.ndp.model.ClassModel;
import com.ndp.model.MajorsModel;

public class ClassMapper implements RowMapper<ClassModel> {

	public ClassModel mapRow(ResultSet resultSet) {
		try {
			ClassModel classs = new ClassModel();
			classs.setClass_code(resultSet.getLong("class_code"));
			classs.setClass_name(resultSet.getString("class_name"));
			try {
				MajorsModel majors=new MajorsModel();
				majors.setMajors_name(resultSet.getString("majors_name"));
				majors.setMajors_code(resultSet.getLong("majors_code"));
				
				classs.setClass_majors(majors);
			}catch (Exception e) {
				// TODO: handle exception
			}
			return classs;
		} catch (SQLException e) {
			return null;
		}
	}
}