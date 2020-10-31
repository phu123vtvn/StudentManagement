package com.ndp.model;

public class ClassModel extends AbstractModel<ClassModel>{

	private long class_code;
	private String class_name;
	private MajorsModel class_majors;
	
	public long getClass_code() {
		return class_code;
	}
	public void setClass_code(long class_code) {
		this.class_code = class_code;
	}
	public String getClass_name() {
		return class_name;
	}
	public void setClass_name(String class_name) {
		this.class_name = class_name;
	}
	public MajorsModel getClass_majors() {
		return class_majors;
	}
	public void setClass_majors(MajorsModel class_majors) {
		this.class_majors = class_majors;
	}
	
}
