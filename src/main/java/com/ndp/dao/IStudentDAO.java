package com.ndp.dao;

import java.util.List;

import com.ndp.model.StudentModel;

public interface IStudentDAO extends GenericDAO<StudentModel>{
	List<StudentModel> findAll();
	List<StudentModel> findStudentByClassCode(long id);
	StudentModel findOne(long id);
	Long insert(StudentModel newStudent);
	void update(StudentModel updateStudent);
	void delete(long id);
}
