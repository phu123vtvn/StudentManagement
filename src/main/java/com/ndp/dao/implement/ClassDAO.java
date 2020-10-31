package com.ndp.dao.implement;

import java.util.List;

import com.ndp.dao.IClassDAO;
import com.ndp.mapper.ClassMapper;
import com.ndp.model.ClassModel;

public class ClassDAO extends AbstractDAO<ClassModel> implements IClassDAO{

	@Override
	public List<ClassModel> findAll() {
		String sql = "SELECT cl.*,mj.* FROM class cl join majors mj on cl.class_majors=mj.majors_code";
		return query(sql, new ClassMapper());
	}

	@Override
	public ClassModel findOne(long id) {
		String sql = "SELECT cl.*,mj.* FROM class cl join majors mj on cl.class_majors=mj.majors_code and cl.class_code = ?";
		List<ClassModel> clas = query(sql, new ClassMapper(), id);
		return clas.isEmpty() ? null : clas.get(0);
	}

	@Override
	public void update(ClassModel model) {
		String sql="update class set class_name=?,class_majors=? where class_code=?";
		update(sql, model.getClass_name(),model.getClass_majors().getMajors_code(),model.getClass_code());
	}

	@Override
	public void insert(ClassModel model) {
		String sql="insert into class(class_name,class_majors) values(?,?)";
		insert(sql, model.getClass_name(),model.getClass_majors().getMajors_code());
	}

}
