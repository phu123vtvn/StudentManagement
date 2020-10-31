package com.ndp.service;

import java.util.List;

import com.ndp.model.ClassModel;

public interface IClassService {
	List<ClassModel> findAll();
	ClassModel findOne(long id);
	public void insert(ClassModel model);
	public void update(ClassModel model);
}
