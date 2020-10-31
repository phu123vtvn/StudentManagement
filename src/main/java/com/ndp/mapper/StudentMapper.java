package com.ndp.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import com.ndp.model.ClassModel;
import com.ndp.model.MajorsModel;
import com.ndp.model.StudentModel;


public class StudentMapper implements RowMapper<StudentModel> {

	public StudentModel mapRow(ResultSet resultSet) {
		try {
			StudentModel student = new StudentModel();
			student.setStudent_code(resultSet.getLong("student_code"));
			student.setStudent_name(resultSet.getString("student_name"));
			student.setStudent_birth(resultSet.getString("student_birth"));
			student.setStudent_gender(resultSet.getString("student_gender"));
			student.setStudent_address(resultSet.getString("student_address"));
			try {
				ClassModel classs=new ClassModel();
				classs.setClass_code(resultSet.getLong("class_code"));
				classs.setClass_name(resultSet.getString("class_name"));
				
				
				MajorsModel majors=new MajorsModel();
				majors.setMajors_name(resultSet.getString("majors_name"));
				
				classs.setClass_majors(majors);
				student.setStudent_class(classs);
				student.setStudent_majors(majors);
			}catch (Exception e) {
				// TODO: handle exception
			}
			return student;
		} catch (SQLException e) {
			return null;
		}	
	}
}
