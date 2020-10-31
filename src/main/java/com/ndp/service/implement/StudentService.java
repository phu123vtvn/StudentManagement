package com.ndp.service.implement;

import java.util.List;

import javax.inject.Inject;

import com.ndp.dao.IClassDAO;
import com.ndp.dao.IMajorsDAO;
import com.ndp.dao.IStudentDAO;
import com.ndp.model.StudentModel;
import com.ndp.service.IStudentService;

public class StudentService implements IStudentService{

	@Inject
	private IStudentDAO studentDAO;
	
	@Inject
	private IClassDAO classDAO;
	
	@Inject
	private IMajorsDAO majorsDAO;
	
	@Override
	public List<StudentModel> findAll() {
		return studentDAO.findAll();
	}

	@Override
	public StudentModel findOne(long id) {
		return studentDAO.findOne(id);
	}

	@Override
	public StudentModel insert(StudentModel newStudent) {
		studentDAO.insert(newStudent);
		return null;
	}

	@Override
	public StudentModel update(StudentModel updateStudent) {
		studentDAO.update(updateStudent);
		return studentDAO.findOne(updateStudent.getStudent_code());
	}

	@Override
	public List<StudentModel> findStudentByClassCode(long id) {
		return studentDAO.findStudentByClassCode(id);
	}

	@Override
	public void delete(long id) {
		studentDAO.delete(id);
	}

}
