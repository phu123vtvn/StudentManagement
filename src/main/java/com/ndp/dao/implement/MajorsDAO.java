package com.ndp.dao.implement;

import java.util.List;

import com.ndp.dao.IMajorsDAO;
import com.ndp.mapper.MajorsMapper;
import com.ndp.model.MajorsModel;

public class MajorsDAO extends AbstractDAO<MajorsModel> implements IMajorsDAO{

	@Override
	public List<MajorsModel> findAll() {
		String sql = "SELECT * FROM majors";
		return query(sql, new MajorsMapper());
	}

	@Override
	public MajorsModel findOne(long id) {
		String sql = "SELECT * FROM class WHERE id = ?";
		List<MajorsModel> majors = query(sql, new MajorsMapper(), id);
		return majors.isEmpty() ? null : majors.get(0);
	}

	
}
