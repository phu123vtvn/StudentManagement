package com.ndp.dao.implement;

import java.util.List;

import com.ndp.dao.IStudentDAO;
import com.ndp.mapper.StudentMapper;
import com.ndp.model.StudentModel;

public class StudentDAO extends AbstractDAO<StudentModel> implements IStudentDAO{

	@Override
	public List<StudentModel> findAll() {
		String sql = "SELECT st.*, cl.*, mj.majors_name"
				+ " FROM student st JOIN class cl ON st.student_class=cl.class_code"
								  +" JOIN majors mj ON cl.class_majors =mj.majors_code";
		return query(sql, new StudentMapper());
	}

	@Override
	public StudentModel findOne(long id) {
		String sql = "SELECT st.*, cl.*, mj.majors_name"
				+ " FROM student st JOIN class cl ON st.student_class=cl.class_code"
				+ " JOIN majors mj ON cl.class_majors =mj.majors_code"
				+ " where st.student_code=?";
		List<StudentModel> student=query(sql, new StudentMapper(), id);
		return student.isEmpty()? null : student.get(0);
	}

	@Override
	public Long insert(StudentModel newStudent) {
		StringBuilder sql = new StringBuilder("INSERT INTO student");
		sql.append(" (student_name, student_birth, student_gender, student_address, student_class)");
		sql.append(" VALUES(?, ?, ?, ?, ?)");
		return insert(sql.toString(), newStudent.getStudent_name(),newStudent.getStudent_birth(),newStudent.getStudent_gender(),
						newStudent.getStudent_address(),newStudent.getStudent_class().getClass_code());
	}

	@Override
	public void update(StudentModel updateStudent) {
		StringBuilder sql = new StringBuilder("UPDATE student SET");
		sql.append(" student_name=?, student_birth=?, student_gender=?, student_address=?, student_class=?");
		sql.append(" where student_code=?");
		update(sql.toString(), updateStudent.getStudent_name(),updateStudent.getStudent_birth(),updateStudent.getStudent_gender(),
						updateStudent.getStudent_address(),updateStudent.getStudent_class().getClass_code(),updateStudent.getStudent_code());
	}

	@Override
	public void delete(long id) {
		String sql="delete from student where student_code=?";
		update(sql, id);
	}

	@Override
	public List<StudentModel> findStudentByClassCode(long id) {
		String sql = "SELECT st.*, cl.*, mj.majors_name"
				+ " FROM student st JOIN class cl ON st.student_class=cl.class_code"
				+ " JOIN majors mj ON cl.class_majors =mj.majors_code"
				+ " where st.student_class=?";
		return query(sql, new StudentMapper(), id);
	}


}
