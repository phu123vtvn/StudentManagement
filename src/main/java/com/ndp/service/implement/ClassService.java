package com.ndp.service.implement;

import java.util.List;

import javax.inject.Inject;

import com.ndp.dao.IClassDAO;
import com.ndp.model.ClassModel;
import com.ndp.service.IClassService;

public class ClassService implements IClassService{

	@Inject
	private IClassDAO classDAO;
	
	@Override
	public List<ClassModel> findAll() {
		return classDAO.findAll();
	}

	@Override
	public ClassModel findOne(long id) {
		// TODO Auto-generated method stub
		return classDAO.findOne(id);
	}

	@Override
	public void insert(ClassModel model) {
		classDAO.insert(model);
		
	}

	@Override
	public void update(ClassModel model) {
		classDAO.update(model);
		
	}

}
