package com.ndp.model;


public class StudentModel extends AbstractModel<StudentModel>{
	
	private long student_code;
	private String student_name;
	private String student_birth;
	private String student_gender;
	private String student_address;
	private ClassModel student_class;
	private MajorsModel student_majors;
	
	public StudentModel() {
		
	}
	
	public StudentModel(long student_code, String student_name, String student_birth, String student_gender,
			String student_address, ClassModel student_class) {
		super();
		this.student_code = student_code;
		this.student_name = student_name;
		this.student_birth = student_birth;
		this.student_gender = student_gender;
		this.student_address = student_address;
		this.student_class = student_class;
	}

	public StudentModel(String student_name, String student_birth, String student_gender, String student_address,
			ClassModel student_class) {
		super();
		this.student_name = student_name;
		this.student_birth = student_birth;
		this.student_gender = student_gender;
		this.student_address = student_address;
		this.student_class = student_class;
	}
	public ClassModel getStudent_class() {
		return student_class;
	}
	public MajorsModel getStudent_majors() {
		return student_majors;
	}
	public void setStudent_majors(MajorsModel student_majors) {
		this.student_majors = student_majors;
	}
	public void setStudent_class(ClassModel student_class) {
		this.student_class = student_class;
	}
	public long getStudent_code() {
		return student_code;
	}
	public void setStudent_code(long student_code) {
		this.student_code = student_code;
	}
	public String getStudent_name() {
		return student_name;
	}
	public void setStudent_name(String student_name) {
		this.student_name = student_name;
	}
	public String getStudent_birth() {
		return student_birth;
	}
	public void setStudent_birth(String student_birth) {
		this.student_birth = student_birth;
	}
	public String getStudent_gender() {
		return student_gender;
	}
	public void setStudent_gender(String student_gender) {
		this.student_gender = student_gender;
	}
	public String getStudent_address() {
		return student_address;
	}
	public void setStudent_address(String student_address) {
		this.student_address = student_address;
	}
	
	
}
