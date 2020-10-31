package com.ndp.dao;

import java.util.List;

import com.ndp.model.ClassModel;

public interface IClassDAO extends GenericDAO<ClassModel>{

	List<ClassModel> findAll();
	ClassModel findOne(long id);
	public void update(ClassModel model);
	public void insert(ClassModel model);
}
