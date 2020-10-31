package com.ndp.dao;

import java.util.List;

import com.ndp.model.MajorsModel;

public interface IMajorsDAO extends GenericDAO<MajorsModel>{
	List<MajorsModel> findAll();
	MajorsModel findOne(long id);
}
