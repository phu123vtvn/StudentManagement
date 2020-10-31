package com.ndp.service;

import java.util.List;

import com.ndp.model.MajorsModel;

public interface IMajorsService {
	List<MajorsModel> findAll();
	MajorsModel findOne(long id);
}
