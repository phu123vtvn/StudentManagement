package com.ndp.service.implement;

import java.util.List;

import javax.inject.Inject;

import com.ndp.dao.implement.MajorsDAO;
import com.ndp.model.MajorsModel;
import com.ndp.service.IMajorsService;

public class MajorsService implements IMajorsService{

	@Inject
	private MajorsDAO majors;
	
	@Override
	public List<MajorsModel> findAll() {
		return majors.findAll();
	}

	@Override
	public MajorsModel findOne(long id) {
		return majors.findOne(id);
	}

}
