package com.ndp.service;

import java.util.List;

import com.ndp.model.StudentModel;

public interface IStudentService {
	List<StudentModel> findAll();
	List<StudentModel> findStudentByClassCode(long id);
	StudentModel findOne(long id);
	StudentModel insert(StudentModel newStudent);
	StudentModel update(StudentModel updateStudent);
	public void delete(long id);
}
